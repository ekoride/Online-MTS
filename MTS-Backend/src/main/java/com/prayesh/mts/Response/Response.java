package com.prayesh.mts.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    @JsonProperty("Token")
	private String token;
	@JsonProperty("Data")
	private Object data;
	@JsonProperty("Details")
	private String details;
	@JsonProperty("Status")
	private int status;
	@JsonProperty("InMaintenanceMode")
	private String inMaintenanceMode;
	
	public Response(int status) {
		this.status = status;
	}
	
	public Response(Object data, int status) {
		this.data = data;
		this.status = status;
	}
	
	public Response(Object data, String details, int status) {
		this.data = data;
		this.details = details;
		this.status = status;
	}   
}
