package com.jobApp.jobApp.model;



import java.util.List;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class JobPost {

    private int postId;
    private String profile;
    private String description; // Changed from postDesc to description
    private int requiredExperience; // Changed from reqExperience to requiredExperience
    private List<String> techStack; // Changed from postTechStack to techStack
}
