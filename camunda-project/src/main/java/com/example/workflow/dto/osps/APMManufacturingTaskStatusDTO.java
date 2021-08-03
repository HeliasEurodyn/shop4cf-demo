package com.example.workflow.dto.osps;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
public class APMManufacturingTaskStatusDTO {
    private String publisherId;
    private String taskId;
    private Instant when;
    private Integer statusCode;
}
