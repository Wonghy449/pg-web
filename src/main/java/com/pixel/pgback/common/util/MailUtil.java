package com.pixel.pgback.common.util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

/**
 * @BelongsProject: PG-back
 * @BelongsPackage: com.pixel.pgback.util
 * @Author: zhouzw
 * @CreateTime: 2019/5/12 14:59
 * @Description: email相关工具类
 */
public class MailUtil {
    private static Properties properties = new Properties();
    //邮件常量
    /**
     * 发件人
     */
    public static String MAIL_SENDER_ADDRESS;
    /**
     * 发件人用户名
     */
    public static String MAIL_SENDER_USERNAME;
    /**
     * 发件人密码
     */
    public static String MAIL_SENDER_PASSWORD;

    /**
     * 收件人地址,现在收件人地址由参数传入,先留着
     */
    public static String MAIL_RECIPIENT_ADDRESSES;

    static {
        InputStream in = MailUtil.class.getClassLoader().getResourceAsStream("mail.properties");
        try {
            properties.load(in);
            MAIL_SENDER_ADDRESS = properties.getProperty("sender.address");
            MAIL_SENDER_USERNAME = properties.getProperty("sender.username");
            MAIL_SENDER_PASSWORD = properties.getProperty("sender.password");
            MAIL_RECIPIENT_ADDRESSES = properties.getProperty("recipient.address");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 发送文本邮件，单发或群发
     *
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param address 收件人地址
     * @throws Exception
     */
    public static void sendMailText(String subject, String content, String address) throws Exception {
        //2.创建session对象
        Session session = Session.getInstance(properties);
        //设置调试信息控制台打印
        session.setDebug(true);
        //3.创建邮件实例对象
        Message message = getMimeMessageText(session, subject, content, address);
        //4.获取Transport对象
        Transport transport = session.getTransport();
        //设置发件人账户密码
        transport.connect(MAIL_SENDER_USERNAME, MAIL_SENDER_PASSWORD);
        //发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        //5.关闭邮件连接
        transport.close();
    }

    /**
     * 发送MP邮件
     */
    public static void sendMailMulti() {

    }


    /**
     * 获取文本邮件实例对象
     *
     * @param session 环境信息
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param address 收件人地址
     * @return
     * @throws Exception
     */
    private static MimeMessage getMimeMessageText(Session session, String subject, String content, String address) throws Exception {
        //创建邮件实例对象
        MimeMessage message = new MimeMessage(session);
        //设置发件人地址
        message.setFrom(new InternetAddress(MAIL_SENDER_ADDRESS));
        // 设置收件人地址（可以增加多个收件人、抄送、密送）
        message.setRecipients(Message.RecipientType.TO, address);
        //设置邮件主题
        message.setSubject(subject, "UTF-8");
        //设置邮件正文
        message.setContent(content, "text/html;charset=UTF-8");
        //设置邮件发送时间，默认立即发送
        message.setSentDate(new Date());
        return message;
    }

    /**
     * 获取Multiple Part邮件实例对象
     *
     * @param session 环境信息
     * @return
     * @throws Exception
     */
    private static MimeMessage getMimeMessageMulti(Session session) throws Exception {
        //创建邮件实例对象
        MimeMessage message = new MimeMessage(session);
        //设置发件人地址
        message.setFrom();
        return message;
    }
}
