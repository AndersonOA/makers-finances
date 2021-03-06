/**
 * 
 */
package br.com.makersweb.finances.web.message;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

/**
*
* @author anderson.aristides
*
*/
public class MakersMessage {
	
	@Autowired
	private MessageSource messageSource;

	public MakersMessage(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public String message(String message, Object... params) {
		return messageSource.getMessage(message, params, Locale.getDefault());
	}

	public String message(String message) {
		return messageSource.getMessage(message, null, Locale.getDefault());
	}

}
