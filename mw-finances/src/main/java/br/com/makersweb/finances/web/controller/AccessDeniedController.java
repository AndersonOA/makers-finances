/**
 * 
 */
package br.com.makersweb.finances.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
*
* @author anderson.aristides
*
*/
@Controller
public class AccessDeniedController {
	
	private static String GO_ACCESS_DENIED = "access-denied";
	
	@RequestMapping(value = "access-denied.html")
	public ModelAndView denied() {
		ModelAndView mav = new ModelAndView(GO_ACCESS_DENIED);
		return mav;
	}

}
