package com.example.workflow.service;

import com.example.workflow.dto.store.StoreDTO;
import com.example.workflow.dto.store.StoreSubscriptionResponceDTO;
import org.camunda.bpm.BpmPlatform;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.task.Task;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CamundaProcessService {

    public List<String> getActiveProcesses() {
        ProcessEngine processEngine = BpmPlatform.getDefaultProcessEngine();
        List<Task> tasks = processEngine.getTaskService().createTaskQuery().active().list();
        return tasks.stream().map(task -> task.getName()).collect(Collectors.toList());
    }

    public Response storeLocationUpdateTrigger(StoreSubscriptionResponceDTO storeSubscriptionResponceDTO) {
        storeSubscriptionResponceDTO.data
                .forEach(storeDTO -> {
                    this.startProcessExample(storeDTO);
                });
        return Response.status(200).build();
    }

    public void startProcessExample(StoreDTO storeDTO) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("streetAddress", storeDTO.address.value.streetAddress);
        variables.put("addressRegion", storeDTO.address.value.addressRegion);

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstanceWithVariables instance = runtimeService.createProcessInstanceByKey("teams")
                .setVariables(variables)
                .executeWithVariablesInReturn();
    }

    public Response startProcessExample() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("nombrePdf", "Hello");
        variables.put("datos", "What?");

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();

        ProcessInstanceWithVariables instance = runtimeService.createProcessInstanceByKey("teams")
                .setVariables(variables)
                .executeWithVariablesInReturn();

        return Response.status(200).build();
    }

}
