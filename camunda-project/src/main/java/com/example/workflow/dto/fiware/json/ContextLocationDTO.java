package com.example.workflow.dto.fiware.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContextLocationDTO {
    @JsonProperty("coordinates")
    private long[] coordinates = {(long) -3.712247222222222, (long) 40.423852777777775};

    private String type = "Point";
}
