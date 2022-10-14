package com.truck.entity;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "routeid",
        "startDate",
        "endDate",
        "source",
        "destination",
        "status"
})
@Generated("jsonschema2pojo")
public class Route {

    @JsonProperty("routeid")
    public String routeid;
    @JsonProperty("startDate")
    public String startDate;
    @JsonProperty("endDate")
    public String endDate;
    @JsonProperty("source")
    public String source;
    @JsonProperty("destination")
    public String destination;
    @JsonProperty("status")
    public String status;
}