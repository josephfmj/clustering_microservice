package co.edu.ucatolica.clustering.microservice.api.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ClusteringData {
	
	@Id
	private ObjectId id;
	
	private String clusteringType;
	
	private String name;

	
	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getClusteringType() {
		return clusteringType;
	}

	public void setClusteringType(String clusteringType) {
		this.clusteringType = clusteringType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
