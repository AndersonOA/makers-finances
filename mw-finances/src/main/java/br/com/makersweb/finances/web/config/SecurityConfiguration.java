/**
 * 
 */
package br.com.makersweb.finances.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 *
 * @author anderson.aristides
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users.query}")
	private String usersQuery;

	@Value("${spring.queries.roles.query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(shaPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/plain/login.html").permitAll()
			.antMatchers("/resources/**", "/*/api/**", "/_cdn/**").permitAll()
			.anyRequest()
			.authenticated().and().csrf().disable().formLogin()
			.loginPage("/plain/login.html").failureUrl("/plain/login.html?error=true")
			.defaultSuccessUrl("/page/dashboard.html")
			.usernameParameter("email")
			.passwordParameter("password")
			.and().logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/").and().exceptionHandling()
			.accessDeniedPage("/access-denied");
//		http
//			.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/resources/**", "/*/api/**", "/_cdn/**").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.loginPage("/plain/login.html").permitAll()
//			.failureUrl("/plain/login.html?error=invalid_user")
//			.defaultSuccessUrl("/page/dashboard.html")
//			.usernameParameter("email")
//			.passwordParameter("password")
//			.and().logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/").and().exceptionHandling()
//			.accessDeniedPage("/access-denied.html");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**", "/_cdn/**");
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}
