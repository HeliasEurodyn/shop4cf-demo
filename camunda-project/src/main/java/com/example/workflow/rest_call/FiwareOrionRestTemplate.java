package com.example.workflow.rest_call;

import com.example.workflow.dto.store.StoreDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@Service
public class FiwareOrionRestTemplate {

    @Value("${fiwareurl}")
    private String fiwareServerUrl = "http://localhost:10260";

    public Object getVersion() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            HttpEntity httpEntity = new HttpEntity(headers);
            ResponseEntity<Object> responce = restTemplate.exchange(
                    URI.create(fiwareServerUrl + "/version"),
                    HttpMethod.GET,
                    httpEntity,
                    new ParameterizedTypeReference<Object>() {
                    }
            );

            return responce.getBody();
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    public void postStore(StoreDTO store) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            HttpEntity<StoreDTO> httpEntity = new HttpEntity<StoreDTO>(store, headers);

            restTemplate.postForObject(
                    fiwareServerUrl + "/v2/entities",
                    httpEntity,
                    Void.class
            );

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    public List<StoreDTO> getAllStores() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();

            HttpEntity httpEntity = new HttpEntity(headers);

            ResponseEntity<List<StoreDTO>> responce = restTemplate.exchange(
                    URI.create(fiwareServerUrl + "/v2/entities?type=Store"),
                    HttpMethod.GET,
                    httpEntity,
                    new ParameterizedTypeReference<List<StoreDTO>>() {
                    }
            );

            return responce.getBody();

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    public StoreDTO getStoreById(String id) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
            ResponseEntity<StoreDTO> responce = restTemplate.exchange(
                    URI.create(fiwareServerUrl + "/v2/entities/urn:ngsi-ld:Store:" + id + "?type=Store"),
                    HttpMethod.GET,
                    httpEntity,
                    new ParameterizedTypeReference<StoreDTO>() {
                    }
            );

            return responce.getBody();

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

    public List<StoreDTO> getStoresWithUrlFilters(String subUrl) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

            HttpEntity httpEntity = new HttpEntity(headers);

            ResponseEntity<List<StoreDTO>> responce = restTemplate.exchange(
                    URI.create(fiwareServerUrl + "/v2/entities?type=Store&" + subUrl),
                    HttpMethod.GET,
                    httpEntity,
                    new ParameterizedTypeReference<List<StoreDTO>>() {
                    }
            );

            return responce.getBody();

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        }
    }

}
