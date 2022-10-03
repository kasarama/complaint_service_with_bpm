package sysint.complaint.workflow.service;


import sysint.complaint.workflow.model.EmailDataDTO;

public interface EmailService {

    public String sendEmail(EmailDataDTO emailData);
}
