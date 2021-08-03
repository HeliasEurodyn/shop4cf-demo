package com.example.workflow.controller;

import com.example.workflow.dto.example.PersonDTO;
import com.example.workflow.dto.fiware.json.AlertNormalizedDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ioinformarics.oss.jackson.module.jsonld.JsonldModule;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @GetMapping
    String helloWorld() {
        return "Hello world!";
    }


    @GetMapping(value = "person")
    PersonDTO getPerson() {
        PersonDTO person = new PersonDTO();
        person.setId("1");
        person.setName("Helias");
        return person;
    }

    @GetMapping(value = "person-ld", produces = MediaType.APPLICATION_JSON_VALUE )
    String getPersonLd() throws JsonProcessingException {
        PersonDTO person = new PersonDTO();
        person.setId("1");
        person.setName("Helias");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JsonldModule());
        String personJsonLd = objectMapper.writeValueAsString(person);

        return personJsonLd;
    }


    @GetMapping(value = "alert")
    AlertNormalizedDTO getAlert() {
        AlertNormalizedDTO alertNormalizedDTO = new AlertNormalizedDTO();
        return alertNormalizedDTO;
    }

}
