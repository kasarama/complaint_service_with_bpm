package sysint.complaint.workflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import sysint.complaint.workflow.delegate.AutoValidateComplaint;
import sysint.complaint.workflow.delegate.SendAutoResponse;
import sysint.complaint.workflow.delegate.SendRejectionEmail;
import sysint.complaint.workflow.delegate.SendResponseEmail;
import sysint.complaint.workflow.service.impl.ComplaintServiceImpl;
import sysint.complaint.workflow.service.impl.EmailServiceImpl;

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