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
* @Description: TODO(这里用一句话描述这个类的作用)
* @date 2018年11月27日 上午10:09:03    
* Company www.igeekhome.com
*    
*/
public class MailUtil {
	//发送者的邮箱地址
	private String fromAddress = "18856112558@163.com";
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	//发送者邮箱密码
	private String fromPass = "wangkai0921";
	public void setFromPass(String fromPass) {
		this.fromPass = fromPass;
	}

	public void sendMaill(String title,String content,String toAddress) throws Exception {
		// 使用properties类进行相关配置
		Properties props = new Properties();
		// 设置发送邮件的协议
		props.setProperty("mail.transport.protocol", "SMTP");
		// 设置发送邮件的服务器
		props.setProperty("mail.host", "smtp.163.com");
		// 设置进行用户验证
		props.setProperty("mail.smtp.auth", "true");
		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				String name = fromAddress.substring(0, fromAddress.indexOf("@"));
				return new PasswordAuthentication(name, fromPass);
			}
		};
		//根据上面的Properties的配置和验证器打开一个session
		Session session = Session.getInstance(props, auth);
		//创建message对象
		Message message = new MimeMessage(session);
		//设置邮件标题
		message.setSubject(title);
		//设置邮件内容（有多个API，可以满足多各种需求）
		message.setContent(content,"text/html;charset=utf-8");
		//设置发送者地址
		message.setFrom(new InternetAddress(fromAddress));
		//这只接受者地址
		message.setRecipient(RecipientType.TO, new InternetAddress(toAddress));
		//发送
		Transport.send(message);
	}
}
