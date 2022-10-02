package com.example.workflow.delegate;

import com.example.workflow.model.EmailDataDTO;
import com.example.workflow.service.impl.EmailServiceImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class SendResponseEmail  implements JavaDelegate {



    @Autowired
    EmailServiceImpl emailService;



    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        EmailDataDTO emailData = new EmailDataDTO();
        String subject = "RE: " + (String) delegateExecution.getVariable("complaint_title");
        String email = (String) delegateExecution.getVariable("email");
        String body = (String) delegateExecution.getVariable("complaint_response_body");

        emailData.setEmail(email);
        emailData.setSubject(subject);
        emailData.setBody(body);
        emailService.sendEmail(emailData);

    }
}
