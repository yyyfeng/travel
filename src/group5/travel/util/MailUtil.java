package group5.travel.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**  
* @ClassName: MailUtil  
* @Description: TODO(������һ�仰��������������)
* @date 2018��11��27�� ����10:09:03    
* Company www.igeekhome.com
*    
*/
public class MailUtil {
	//�����ߵ������ַ
	private String fromAddress = "18856112558@163.com";
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	//��������������
	private String fromPass = "wangkai0921";
	public void setFromPass(String fromPass) {
		this.fromPass = fromPass;
	}

	public void sendMaill(String title,String content,String toAddress) throws Exception {
		// ʹ��properties������������
		Properties props = new Properties();
		// ���÷����ʼ���Э��
		props.setProperty("mail.transport.protocol", "SMTP");
		// ���÷����ʼ��ķ�����
		props.setProperty("mail.host", "smtp.163.com");
		// ���ý����û���֤
		props.setProperty("mail.smtp.auth", "true");
		// ������֤��
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				String name = fromAddress.substring(0, fromAddress.indexOf("@"));
				return new PasswordAuthentication(name, fromPass);
			}
		};
		//���������Properties�����ú���֤����һ��session
		Session session = Session.getInstance(props, auth);
		//����message����
		Message message = new MimeMessage(session);
		//�����ʼ�����
		message.setSubject(title);
		//�����ʼ����ݣ��ж��API������������������
		message.setContent(content,"text/html;charset=utf-8");
		//���÷����ߵ�ַ
		message.setFrom(new InternetAddress(fromAddress));
		//��ֻ�����ߵ�ַ
		message.setRecipient(RecipientType.TO, new InternetAddress(toAddress));
		//����
		Transport.send(message);
	}
}
