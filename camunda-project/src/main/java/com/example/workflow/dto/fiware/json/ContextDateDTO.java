package com.example.workflow.dto.fiware.json;

import com.example.workflow.tool.ISO8601ToInstantDeserializer;
import com.example.workflow.tool.InstantToISO8601Serializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.Instant;

@Data
public class ContextDateDTO {

    @JsonProperty("@type")
    private String type = "DateTime";

    @JsonProperty("@value")
    @JsonDeserialize(using = ISO8601ToInstantDeserializer.class)
    @JsonSerialize(using = InstantToISO8601Serializer.class)
    private Instant value = Instant.now();
}
