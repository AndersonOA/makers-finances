/**
 * 
 */
package br.com.makersweb.finances.web.util;

/**
*
* @author anderson.aristides
*
*/
public class MakersUtils {
	
	/**
	 * CONSTANTES GERAIS
	 */
	public final static String E_USER_NOTICE = "trigger_info";
	public final static String E_USER_WARNING = "trigger_warning";
	public final static String E_USER_ERROR = "trigger_error";
	public final static String E_USER_SUCESS = "trigger_success";
	public final static String EMAIL_REGEX = "[a-zA-Z0-9]+[a-zA-Z0-9_.-]+@{1}[a-zA-Z0-9_.-]*\\.+[a-z]{2,4}";
	public final static String EMAIL_NOREPLY_SENDER = "no-replay@makersweb.com.br";
	public final static String EMAIL_TEST_SENDER = "marrecogevans@gmail.com";
	public final static String USER_ANONYMOUS = "anonymousUser";
	public final static String DUPLICATE_ENTRY = "Duplicate entry";

	/**
	 * Método responsavel por deixa string com apenas numeros
	 * 
	 * @param value
	 * @return string
	 */
	public static String somenteNumeros(String value) {
		return value.replaceAll("\\D", "");
	}

	/**
	 * Método responsavel por validar e-mail
	 * 
	 * Aceita palavras que comecem de a ate z maiúsculo ou minusculo Depois
	 * aceita de a ate z e alguns caracteres especiais como . _ e - Aceita um
	 * único @ Por fim tem que ter de 2 a 4 letras no final da palavra
	 * 
	 * @param email
	 * @return boolean
	 */
	public static boolean isMail(String email) {
		return email.matches(EMAIL_REGEX);
	}

}
