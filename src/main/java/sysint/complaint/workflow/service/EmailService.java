package com.example.workflow.service;

import com.example.workflow.model.EmailDataDTO;

public interface EmailService {

    public String sendEmail(EmailDataDTO emailData);
}
