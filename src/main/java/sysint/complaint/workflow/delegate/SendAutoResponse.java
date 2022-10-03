package sysint.complaint.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import sysint.complaint.workflow.model.EmailDataDTO;
import sysint.complaint.workflow.service.impl.EmailServiceImpl;

public class SendAutoResponse implements JavaDelegate {

    @Autowired
    EmailServiceImpl emailService;

    private final String body = "Processing ....";

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