package com.example.workflow.controller;

import com.example.workflow.dto.store.StoreSubscriptionResponceDTO;
import com.example.workflow.service.CamundaProcessService;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.util.List;

@RestController
@RequestMapping("/camunda-process")
public class CamundaProcessController {

    private final CamundaProcessService camundaProcessService;

    public CamundaProcessController(CamundaProcessService camundaProcessService) {
        this.camundaProcessService = camundaProcessService;
    }

    @GetMapping("/active")
    public List<String> getActiveProcesses() {
       return this.camundaProcessService.getActiveProcesses();
    }

    @PostMapping("/store-location-updated")
    public Response storeLocationUpdateTrigger(@RequestBody StoreSubscriptionResponceDTO storeSubscriptionResponceDTO) {
        return this.camundaProcessService.storeLocationUpdateTrigger(storeSubscriptionResponceDTO);
    }

    @PostMapping
    public Response startProcess() {
        return this.camundaProcessService.startProcessExample();
    }

}
