package co.edu.ucatolica.clustering.microservice.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ClusteringExecData {

	@Id
	private ObjectId id;
	private String dataId;
	private RserveResponse response;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public RserveResponse getResponse() {
		return response;
	}
	public void setResponse(RserveResponse response) {
		this.response = response;
	}
	
	
}
