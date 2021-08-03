package com.example.workflow.dto.fiware.json;

import com.example.workflow.tool.ISO8601ToInstantDeserializer;
import com.example.workflow.tool.InstantToISO8601Serializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.Instant;

//@JsonldResource
////@JsonldNamespace(name = "s", uri = "http://schema.org/")
//@JsonldType("Alert")
//@JsonldLink(rel = "s:knows", name = "knows", href = "http://example.com/person/2345")
@Data
public class AlertNormalizedDTO {

    @JsonProperty("@context")
    public String[] context = {"https://smartdatamodels.org/context.jsonld","https://uri.etsi.org/ngsi-ld/v1/ngsi-ld-core-context.jsonld" };

    private String id = "urn:ngsi-ld:Alert:Alert:1";

    private String alertSource = "https://account.lab.fiware.org/users/8";

    private String category = "traffic";

    @JsonDeserialize(using = ISO8601ToInstantDeserializer.class)
    @JsonSerialize(using = InstantToISO8601Serializer.class)
    private Instant createdAt = Instant.now();

    @JsonDeserialize(using = ISO8601ToInstantDeserializer.class)
    @JsonSerialize(using = InstantToISO8601Serializer.class)
    private Instant modifiedAt = Instant.now();

    private ContextDateDTO dateIssued = new ContextDateDTO();

    private ContextLocationDTO location = new ContextLocationDTO();

    private String severity = "high";

    private String subCategory = "trafficJam";

    private String type = "Alert";

    private ContextDateDTO validFrom = new ContextDateDTO();

    private ContextDateDTO validTo = new ContextDateDTO();

}
