package co.edu.ucatolica.clustering.microservice.api.service.impl;

import org.springframework.stereotype.Service;

import co.edu.ucatolica.clustering.microservice.api.model.RServeRequest;
import co.edu.ucatolica.clustering.microservice.api.model.RserveResponse;
import co.edu.ucatolica.clustering.microservice.api.service.IClusteringAlgorithm;

@Service("pam")
public class PamAlgorithm implements IClusteringAlgorithm {

	@Override
	public RserveResponse execClusteringMethod(RServeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
