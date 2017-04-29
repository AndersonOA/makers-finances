package br.com.makersweb.finances.web;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EntityScan(basePackageClasses = { MwFinancesApplication.class, Jsr310JpaConverters.class })
public class MwFinancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MwFinancesApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean dispatcherRegistration(DispatcherServlet dispatcherServlet) {
		ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet);
		registration.setName("mw-finances");
		registration.addUrlMappings("/page/*", "/none/*", "/plain/*", "/main/*");
		return registration;
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:messages", "classpath:application-dev");
		messageSource.setCacheSeconds(3600); // refresh cache once per hour
		return messageSource;
	}

	@Bean
	public FilterRegistrationBean sitemeshFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setName("sitemesh");
		filter.setFilter(new SiteMeshFilter());
		filter.addUrlPatterns("*.html");
		filter.addInitParameter("decorators-file", "/WEB-INF/decorators.xml");
		return filter;
	}
}
