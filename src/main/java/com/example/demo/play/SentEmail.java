package com.example.demo.play;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

@Validated
@RestController
@Api(value = "/",description = "发送邮件")
@RequestMapping("")
public class SentEmail {
    User user=new User();
    @RequestMapping(value = "/sentMsg",method = RequestMethod.POST)
    @ApiOperation(value = "发送邮件",httpMethod = "POST")
    public String sentMsg(@RequestBody EmailUesr E){
        new SentEmail().sentEmail(E.username);
        user.setEmail(E.username);
        return new ResultVO<>(user).getMsg();
    }

    public String sentEmail(String username)  {
        try {
            // 创建Properties 类用于记录邮箱的一些属性
            Properties props = new Properties();
            // 表示SMTP发送邮件，必须进行身份验证
            props.put("mail.smtp.auth", "true");
            //此处填写SMTP服务器
            props.put("mail.smtp.host", "smtp.qq.com");
            //端口号，QQ邮箱端口587
            props.put("mail.smtp.port", "587");
            // 此处填写，写信人的账号
            props.put("mail.user", username);
            // 此处填写16位STMP口令
            props.put("mail.password", "gvahujqbxhbpbegj");

            // 构建授权信息，用于进行SMTP进行身份验证
            Authenticator authenticator = new Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {
                    // 用户名、密码
                    String userName = props.getProperty("mail.user");
                    String password = props.getProperty("mail.password");
                    return new PasswordAuthentication(userName, password);
                }
            };
            // 使用环境属性和授权信息，创建邮件会话
            Session mailSession = Session.getInstance(props, authenticator);
            // 创建邮件消息
            MimeMessage message = new MimeMessage(mailSession);
            // 设置发件人
            InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(form);

            // 设置收件人的邮箱
            InternetAddress to = new InternetAddress("1047681847@qq.com");
            message.setRecipient(RecipientType.TO, to);

            // 设置邮件标题
            message.setSubject("验证码是："+ new SentEmail().getCode());

            // 设置邮件的内容体
            message.setContent("哈哈哈哈", "text/html;charset=UTF-8");

            // 最后当然就是发送邮件啦
            Transport.send(message);

            return "发送成功";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "失败";
    }

    public String getCode(){
        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb=new StringBuilder(4);
        for(int i=0;i<4;i++)
        {
            char ch=str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);

        }
        String result=sb.toString();
        return result;
    }
}
