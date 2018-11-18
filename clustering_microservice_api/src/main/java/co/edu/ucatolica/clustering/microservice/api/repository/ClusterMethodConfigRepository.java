package co.edu.ucatolica.clustering.microservice.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.ucatolica.clustering.microservice.api.model.ClusterMethodConfig;

public interface ClusterMethodConfigRepository extends MongoRepository<ClusterMethodConfig, String> {

}
