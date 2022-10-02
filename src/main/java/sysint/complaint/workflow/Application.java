package com.example.workflow;

import com.example.workflow.delegate.AutoValidateComplaint;
import com.example.workflow.delegate.SendAutoResponse;
import com.example.workflow.delegate.SendRejectionEmail;
import com.example.workflow.delegate.SendResponseEmail;
import com.example.workflow.service.impl.ComplaintServiceImpl;
import com.example.workflow.service.impl.EmailServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public AutoValidateComplaint autoValidateComplaint() {
        return new AutoValidateComplaint();
    }

    @Bean
    public ComplaintServiceImpl complaintService() {
        return new ComplaintServiceImpl();
    }

    @Bean
    public EmailServiceImpl emailService() {
        return new EmailServiceImpl();
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public SendAutoResponse sendAutoResponse() {
        return new SendAutoResponse();
    }

    @Bean
    public SendRejectionEmail sendRejectionEmail() {
        return new SendRejectionEmail();
    }

    @Bean
    public SendResponseEmail sendResponseEmail() {
        return new SendResponseEmail();
    }

}