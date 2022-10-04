package sysint.complaint.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDataDTO {
    private String toEmail;
    private String subject;
    private String text;

}
