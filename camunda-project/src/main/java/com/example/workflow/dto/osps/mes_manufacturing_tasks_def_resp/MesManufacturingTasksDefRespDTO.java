package com.example.workflow.dto.osps.mes_manufacturing_tasks_def_resp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MesManufacturingTasksDefRespDTO {
      private String publisherId;
      private MesMTDRManufacturingTasksDTO manufacturingTasks;
}
