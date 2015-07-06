package com.bs.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.bs.bean.User;
/**
 * 发邮件
 * @author 若水
 *
 */
public class Mail {
	/**
	 * 发送邮件
	 * @param user 接收邮件的用户
	 * @param checkUrl 邮箱验证链接
	 * @param url 图书商城系统主页
	 * @param status 状态（“修改密码”为1，“验证邮箱”为2）
	 * @return 发送成功返回true，否则返回false
	 */
	public static boolean sendMail(User user,String checkUrl,String url,int status){
		String statu=(status==1)?(statu="修改密码"):(statu="验证邮箱");
		String username=user.getUsername();
		String mail=user.getEmail();
		Date dt=new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=formatter.format(new Date(dt.getTime()+1000*60*30));
		Properties props=new Properties();
		props.put("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");
		Session mailsession=Session.getInstance(props);
		mailsession.setDebug(true);
		Message msg=new MimeMessage(mailsession);
		try {
			//msg.setFrom(new InternetAddress("longxueruoshui@163.com"));
			msg.setFrom(new InternetAddress("longxueruoshui@sina.com"));
			msg.setReplyTo(new InternetAddress[]{new InternetAddress(mail)});
			msg.setSubject("图书商城系统——"+statu);
			msg.setSentDate(new Date());
			msg.setContent(
					"<html><head><body>"+"亲爱的<font color=blue>"+username+"</font>:您好！<br><br>&nbsp;&nbsp;"
					+"您收到这封电子邮件是因为您 (也可能是某人冒充您的名义) 申请"+statu+"。假如这不是您本人操作, " +
					"请不用理会这封电子邮件,<br> 但是如果您持续收到这类信件的骚扰, 请您尽快联络管理员。"
					+"<br><br>&nbsp;&nbsp;&nbsp;"+"<font color='red' size='5px'>请点击以下链接"+statu+"。</font>"
					+"<br><br>&nbsp;&nbsp;&nbsp;"+
					"<a href="+checkUrl+">"+"点击此处"+"</a>"
					+"<br><br>&nbsp;&nbsp;&nbsp;"+"如果无法点击该URL链接地址，请将它复制并粘帖到浏览器的地址栏，然后单击回车即可。"
					+"<br><br>&nbsp;&nbsp;&nbsp;"+"<font color='red'>注意:</font>请您在收到该邮件30分钟内（"+date+"之前）使用，否则该链接将会失效。"
					+"<br><br>关注图书商城系统，请访问图书商城系统主页："+"<a href="+url+">"+url+"</a>"
					+"<br>关注技术支持，请咨询SuperTeam团队！"
					+"<br><br>我们将一如既往、热忱的为您服务！"+"</body></head></html>"
				    ,
					"text/html;charset=utf-8");
			Transport transport=mailsession.getTransport();
			//transport.connect("smtp.163.com", 25, "longxueruoshui", "12411514151757");
			transport.connect("smtp.sina.com", 25, "longxueruoshui", "950124");
			transport.sendMessage(msg, new Address[]{new InternetAddress(mail)});
			transport.close();
		} catch (AddressException e) {
			e.printStackTrace();
			return false;
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
