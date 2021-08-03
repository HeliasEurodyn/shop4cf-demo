package com.example.workflow.dto.osps.mes_manufacturing_tasks_def_resp;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MesMTDRManufacturingTasksDTO {

       private String manufacturingFacilityId;
       private List<MesMTDRManufacturingTasksSopDefsDTO> sopDefs;

}
