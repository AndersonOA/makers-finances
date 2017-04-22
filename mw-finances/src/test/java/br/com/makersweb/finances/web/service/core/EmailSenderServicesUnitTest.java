/**
 * 
 */
package br.com.makersweb.finances.web.service.core;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.makersweb.finances.web.service.IEmailSenderService;
import br.com.makersweb.finances.web.service.exception.BusinessException;
import br.com.makersweb.finances.web.util.MakersUtils;

/**
*
* @author anderson.aristides
*
*/
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailSenderServicesUnitTest {
	
	@Autowired
	private IEmailSenderService emailSenderService;
	
	@Ignore
	@Test
	public void sentRegisterEmailTest() throws BusinessException {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("name", "Anderson O. Aristides");
		data.put("subject", "Teste E-mail Makers Finances");
		Boolean sendEmail = this.emailSenderService.sendTestEmail(MakersUtils.EMAIL_TEST_SENDER, data);
		assertTrue(sendEmail);
	}

}
