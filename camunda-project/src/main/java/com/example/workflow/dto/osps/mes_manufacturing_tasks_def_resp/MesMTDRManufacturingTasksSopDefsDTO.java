package com.example.workflow.dto.osps.mes_manufacturing_tasks_def_resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MesMTDRManufacturingTasksSopDefsDTO {
    private String id;
    private String name;
    private List<MesMTDRManufacturingTasksDefsDTO> manufacturingTaskDefs;
}
