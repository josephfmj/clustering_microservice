package co.edu.ucatolica.clustering.microservice.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ucatolica.clustering.microservice.api.model.ClusteringData;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringCLARAResponse;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringHIERARCHICALResponse;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringKMEANSResponse;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringPAMResponse;

@RestController("/run")
public class ClusteringController {

	@RequestMapping(method = RequestMethod.POST, value = "/kmeans")
	public ResponseEntity<ClusteringKMEANSResponse> execKMeans(@RequestBody ClusteringData clusteringData) {

		return null;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/pam")
	public ResponseEntity<ClusteringPAMResponse> execPam(@RequestBody ClusteringData clusteringData) {

		return null;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/clara")
	public ResponseEntity<ClusteringCLARAResponse> execClara(@RequestBody ClusteringData clusteringData) {

		return null;

	}

	@RequestMapping(method = RequestMethod.POST, value = "/hierarchical/{method}")
	public ResponseEntity<ClusteringHIERARCHICALResponse> execHierarchical(@RequestBody ClusteringData clusteringData,
			@PathVariable("method") String method) {

		return null;

	}

}
