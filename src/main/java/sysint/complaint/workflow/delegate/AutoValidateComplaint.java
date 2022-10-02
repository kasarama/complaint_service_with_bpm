package com.example.workflow.delegate;

import com.example.workflow.service.impl.ComplaintServiceImpl;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

public class AutoValidateComplaint implements JavaDelegate {
    @Autowired
    ComplaintServiceImpl complaintService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String complaint = "";

        try {
            complaint = (String) delegateExecution.getVariable("complaint_body");
            //TODO add exception handling
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        boolean isValid = complaintService.validate(complaint);

        delegateExecution.setVariable("is_complaint_valid", String.valueOf(isValid));

    }


}
