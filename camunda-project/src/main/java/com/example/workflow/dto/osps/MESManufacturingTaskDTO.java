package com.example.workflow.dto.osps;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MESManufacturingTaskDTO {
    private String publisherId;
    private String manufacturingFacilityId;
    private String manufacturingFacilityName;
    private String manufacturingAreaId;
    private String finalProductId;
    private String manufacturingTaskId;
    private String manufacturingTaskName;
    private String productionResourceId;
    private String manufacturingTaskDefId;
    private String workStationId;
    private String containerId;
    private String containerType;
}
