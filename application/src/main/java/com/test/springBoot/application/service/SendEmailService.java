package com.test.springBoot.application.service;

import com.test.springBoot.application.model.Device;
import com.test.springBoot.application.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.servlet.ServletContext;
import java.util.Objects;


@Service
public class SendEmailService {

    private final Environment env;

    private final JavaMailSender mailSender;

    private final ServletContext context;

    @Autowired
    private UserService userService;

    @Autowired
    private DeviceService deviceService;

    public SendEmailService(Environment env, JavaMailSender mailSender, ServletContext context) {
        this.env = env;
        this.mailSender = mailSender;
        this.context = context;
    }
    public void sendRegistrationMail(Long id) {
        User user = userService.findUserById(id);
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress(Objects.requireNonNull(env.getProperty("email.sender"))));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            mimeMessage.setSubject("Congratulation, successful registration!!!");

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setText("<html><body>" +
                    "<h1>" +  "Hello" + " " + user.getName() + "!</h1>" +
                    "<p>" + "Thank you for registration in our website" + "." + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<h1>" +  "This message was send from server please dont answer!!!!"  + "!</h1>" +
                    "<p>" + "If you have some questions,  there our  contact data's:" + "(+375-25-765-16-51) - (+375-25-985-14-54)" + "</p>" +
                    "</body></html>", true);

        };

        try {
            mailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
    public void sendChangeProfileMail(Long id) {
        User user = userService.findUserById(id);
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress(Objects.requireNonNull(env.getProperty("email.sender"))));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            mimeMessage.setSubject("Congratulation, successful change profile data's!!!");

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setText("<html><body>" +
                    "<h1>" +  "Hello" + " " + user.getName() + "!</h1>" +
                    "<p>" + "In our website you change profile data's you can check it in website " + "." + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<h1>" +  "This message was send from server please dont answer!!!!"  + "!</h1>" +
                    "<p>" + "If you have some questions,  there our  contact data's:" + "(+375-25-765-16-51) - (+375-25-985-14-54)" + "</p>" +
                    "</body></html>", true);

        };

        try {
            mailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
    public void sendDeleteProfileMail(Long id) {
        User user = userService.findUserById(id);
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress(Objects.requireNonNull(env.getProperty("email.sender"))));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            mimeMessage.setSubject("Your profile was deleted!!!");

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setText("<html><body>" +
                    "<h1>" +  "Hello" + " " + user.getName() + "!</h1>" +
                    "<p>" + "In our website you profile was delete " + "." + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<h1>" +  "This message was send from server please dont answer!!!!"  + "!</h1>" +
                    "<p>" + "If you have some questions,  there our  contact data's:" + "(+375-25-765-16-51) - (+375-25-985-14-54)" + "</p>" +
                    "</body></html>", true);

        };

        try {
            mailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
    public void sendMailDeviceBuy(Long id, Long deviceId) {
        User user = userService.findUserById(id);
        Device device = deviceService.findById(deviceId);
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress(Objects.requireNonNull(env.getProperty("email.sender"))));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            mimeMessage.setSubject("The products you purchased!!!");

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setText("<html><body>" +
                    "<h1>" +  "Hello" + " " + user.getName() + "!</h1>" +
                    "<p>" + "\n" + "List of goods " + ":" + device.getName() + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<h1>" +  "This message was send from server please dont answer!!!!"  + "!</h1>" +
                    "<p>" + "If you have some questions,  there our  contact data's:" + "(+375-25-765-16-51) - (+375-25-985-14-54)" + "</p>" +
                    "</body></html>", true);

        };

        try {
            mailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    public void sendMailDeviceChange(Long id, Long deviceId) {
        User user = userService.findUserById(id);
        Device device = deviceService.findById(deviceId);
        MimeMessagePreparator mimeMessagePreparator = mimeMessage -> {
            mimeMessage.setFrom(new InternetAddress(Objects.requireNonNull(env.getProperty("email.sender"))));
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
            mimeMessage.setSubject("This products was changed!!!");

            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setText("<html><body>" +
                    "<h1>" +  "Hello" + " " + user.getName() + "!</h1>" +
                    "<p>" + "\n" + "List of product changes" + ":" + "</p>" +
                    "<p>"  + device.getName() + "</p>" +
                    "<p>"  + device.getYear() + "</p>" +
                    "<p>"  + device.getBrandDevice().getName() + "</p>" +
                    "<p>"  + device.getCount()+ "</p>" +
                    "<p>"  + device.getPrice() + "</p>" +
                    "<p>" + "</p>" +
                    "<p>" + "</p>" +
                    "<h1>" +  "This message was send from server please dont answer!!!!"  + "!</h1>" +
                    "<p>" + "If you have some questions,  there our  contact data's:" + "(+375-25-765-16-51) - (+375-25-985-14-54)" + "</p>" +
                    "</body></html>", true);

        };

        try {
            mailSender.send(mimeMessagePreparator);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }

}
