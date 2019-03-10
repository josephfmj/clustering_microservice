package co.edu.ucatolica.clustering.microservice.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ClusteringExecData {

	@Id
	private ObjectId id;
	private String dataId;
	private RserveResponse result;
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
		return result;
	}
	public void setResponse(RserveResponse result) {
		this.result = result;
	}
	
	
}
