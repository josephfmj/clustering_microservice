package co.edu.ucatolica.clustering.microservice.api.model;

import java.util.List;
import java.util.Map;

public class ClusteringExecutionRequest {
	
	private String name;
	
	private Map<String,String> params;
	
	private Map<String,List<String>> data_frame;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public Map<String, List<String>> getData_frame() {
		return data_frame;
	}

	public void setData_frame(Map<String, List<String>> data_frame) {
		this.data_frame = data_frame;
	}
	
	
}
