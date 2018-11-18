package co.edu.ucatolica.clustering.microservice.api.model;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="configuration")
public class ClusterMethodConfig {
	
	@Id
	private ObjectId id;
	
	@Field(value="name")        
	private String name;
	
	@Field(value="description")  
	private String description;
	
	@Field(value="params")
	private Map<String, Object> params;

}
