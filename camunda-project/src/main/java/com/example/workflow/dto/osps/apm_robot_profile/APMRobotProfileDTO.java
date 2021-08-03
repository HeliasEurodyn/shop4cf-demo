package com.example.workflow.dto.osps.apm_robot_profile;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class APMRobotProfileDTO {
    private String publisherId;
    private String robotType;
    private String manufacturingAreaId;
    private List<APMRobotProfileSkillDTO> skills;
}
