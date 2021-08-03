package com.example.workflow.controller;

import com.example.workflow.dto.store.StoreDTO;
import com.example.workflow.service.FiwareOrionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fiware-orion")
public class FiwareOrionController {
    private final FiwareOrionService fiwareOrionService;

    public FiwareOrionController(FiwareOrionService fiwareOrionService) {
        this.fiwareOrionService = fiwareOrionService;
    }

    @PostMapping
    public void postStore(@RequestBody StoreDTO store) {
        fiwareOrionService.postStore(store);
    }

    @GetMapping(path = "/by-id/{id}")
    public StoreDTO getStoreById(@PathVariable("id") String id) {
        return fiwareOrionService.getStoreById(id);
    }

    @GetMapping(path = "/all")
    public List<StoreDTO> getAllStores() {
        return fiwareOrionService.getAllStores();
    }

    @GetMapping(path = "/by-filters")
    public List<StoreDTO> getStoresWithUrlFilters() {
        return fiwareOrionService.getStoresWithUrlFilters();
    }

    @GetMapping(path = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
    Object getVersion() {
        return fiwareOrionService.getVersion();
    }

}
