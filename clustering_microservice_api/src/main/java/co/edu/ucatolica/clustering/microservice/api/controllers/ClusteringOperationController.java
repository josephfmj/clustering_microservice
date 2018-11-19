package co.edu.ucatolica.clustering.microservice.api.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucatolica.clustering.microservice.api.model.ClusterMethodConfig;

@RestController("/operations")
public class ClusteringOperationController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/method/all")
	public ResponseEntity<List<ClusterMethodConfig>> getallMethods() {

		return null;

	}

}
