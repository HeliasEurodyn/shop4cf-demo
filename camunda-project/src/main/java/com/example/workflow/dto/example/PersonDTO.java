package com.example.workflow.dto.example;

import ioinformarics.oss.jackson.module.jsonld.annotation.*;
import lombok.Data;

@JsonldResource
@JsonldNamespace(name = "s", uri = "http://schema.org/")
@JsonldType("s:Person")
@JsonldLink(rel = "s:knows", name = "knows", href = "http://example.com/person/2345")
@Data
public class PersonDTO {
    @JsonldId
    private String id;
    @JsonldProperty("s:name")
    private String name;

    // constructor, getters, setters
}
