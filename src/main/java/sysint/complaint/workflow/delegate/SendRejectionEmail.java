package com.example.workflow.delegate;

import com.example.workflow.model.EmailDataDTO;
import com.example.workflow.service.impl.EmailServiceImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class SendRejectionEmail implements JavaDelegate {

    @Autowired
    EmailServiceImpl emailService;

    private final String body = "Sorry, but not!";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        EmailDataDTO emailData = new EmailDataDTO();
        String subject = "RE: " + (String) delegateExecution.getVariable("complaint_title");
        String email = (String) delegateExecution.getVariable("email");

        emailData.setEmail(email);
        emailData.setSubject(subject);
        emailData.setBody(body);
        emailService.sendEmail(emailData);

    }

}


