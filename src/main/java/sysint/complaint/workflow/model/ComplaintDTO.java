package com.example.workflow.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComplaintDTO {
    private String title;
    private String body;
    private String email;
    private String firstName;
    private String lastName;

}
