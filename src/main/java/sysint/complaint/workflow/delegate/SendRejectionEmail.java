package sysint.complaint.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import sysint.complaint.workflow.model.EmailDataDTO;
import sysint.complaint.workflow.service.impl.EmailServiceImpl;

public class SendRejectionEmail implements JavaDelegate {

    @Autowired
    EmailServiceImpl emailService;

    private final String body = "Sorry, but not!";

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        EmailDataDTO emailData = new EmailDataDTO();
        String subject = "RE: " + (String) delegateExecution.getVariable("complaint_title");
        String email = (String) delegateExecution.getVariable("email");

        emailData.setToEmail(email);
        emailData.setSubject(subject);
        emailData.setText(body);
        emailService.sendEmail(emailData);

    }

}


