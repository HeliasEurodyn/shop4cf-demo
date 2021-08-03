package com.example.workflow.service;

import com.example.workflow.dto.store.StoreDTO;
import com.example.workflow.rest_call.FiwareOrionRestTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FiwareOrionService {

    private final FiwareOrionRestTemplate fiwareOrionRestTemplate;

    public FiwareOrionService(FiwareOrionRestTemplate fiwareOrionRestTemplate) {
        this.fiwareOrionRestTemplate = fiwareOrionRestTemplate;
    }

    public void postStore(StoreDTO store) {
        fiwareOrionRestTemplate.postStore(store);
    }

    public StoreDTO getStoreById(String id) {
        return fiwareOrionRestTemplate.getStoreById(id);
    }

    public List<StoreDTO> getAllStores() {
        return fiwareOrionRestTemplate.getAllStores();
    }

    public List<StoreDTO> getStoresWithUrlFilters() {
        return fiwareOrionRestTemplate.getStoresWithUrlFilters("options=keyValues&mq=address.verified==true");
    }

    public Object getVersion() {
        return fiwareOrionRestTemplate.getVersion();
    }

}
