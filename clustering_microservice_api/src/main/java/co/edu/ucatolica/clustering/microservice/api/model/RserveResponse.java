package co.edu.ucatolica.clustering.microservice.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class RserveResponse {
	
	private String description;
	
	private RserveResponse() {
		
	}
	
	@JsonIgnoreType
	public static class Builder {
		
		private String description;
		
		public Builder(){
			
		}
		
		public Builder withDescription(String description){
			
			this.description = description;
			return this;
		}
		
		public RserveResponse build() {
			
			RserveResponse rServeResponse = new RserveResponse();
			rServeResponse.description = this.description;
			
			return rServeResponse;
		}
		
	}

	public String getDescription() {
		return description;
	}

}
