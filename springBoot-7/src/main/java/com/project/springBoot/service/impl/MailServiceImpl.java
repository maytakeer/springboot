package com.project.springBoot.service.impl;


import java.io.File;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.project.springBoot.service.MailService;

@Component
public class MailServiceImpl implements MailService{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Value("${mail.fromMail.addr}")
	private String from;
	
	/**
	 * 发送文本邮件
	 */
	@Override
	public void sendSimpleMail(String to, String subject, String content) {		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		
		try {
			mailSender.send(mailMessage);
			logger.info("简单邮件已经发送。");
		} catch (Exception e) {
			logger.info("发送简单邮件时发生异常",e);
		}
		
	}
	
	/**
	 * 发送html邮件
	 */
	@Override
	public void sendHtmlMail(String to, String subject, String content) {
		MimeMessage mailMessage = mailSender.createMimeMessage();
		try {
			//true表示需要创建一个multipart message
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content,true);
			
			mailSender.send(mailMessage);
			logger.info("html邮件发送成功");
		} catch (Exception e) {
			logger.error("发送html邮件时发生异常",e);
		}
	}
	
	/**
	 * 发送带附件的文件
	 */
	@Override
	public void sendAttachmentsMail(String to, String subject, String content,
			String filePath) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			//true表示需要创建一个multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content,true);
			
			FileSystemResource file = new FileSystemResource(new File(filePath));
			String fileName = filePath.substring(filePath.lastIndexOf(File.separator)+1);
			//System.out.println(fileName);
			//添加多个附件可以使用多条 helper.addAttachment(fileName, file)
			helper.addAttachment(fileName, file);
			
			mailSender.send(message);
			logger.info("带附件的邮件已经发送");
		} catch (Exception e) {
			logger.info("带附件的邮件发送失败",e);
		}
	}
	
	/**
	 * 发送正文中有静态资源（图片）的邮件
	 */
	@Override
	public void sendInlineResourceMail(String to, String subject,
			String content, String rscPath, String rscId) {
		MimeMessage message = mailSender.createMimeMessage();
		
		try {
			//true表示需要创建一个multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message,true);
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(content,true);
			
			FileSystemResource res = new FileSystemResource(new File(rscPath));
			helper.addInline(rscId, res);
			
			mailSender.send(message);
	        logger.info("嵌入静态资源的邮件已经发送。");
		} catch (Exception e) {
			logger.error("发送嵌入静态资源的邮件时发生异常！", e);
		}
	}

}
