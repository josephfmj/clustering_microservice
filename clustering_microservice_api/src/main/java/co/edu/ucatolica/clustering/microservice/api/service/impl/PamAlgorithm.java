package co.edu.ucatolica.clustering.microservice.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.edu.ucatolica.clustering.microservice.api.model.RServeRequest;
import co.edu.ucatolica.clustering.microservice.api.model.RserveResponse;
import co.edu.ucatolica.clustering.microservice.api.service.IClusteringAlgorithm;
import co.edu.ucatolica.clustering.microservice.api.service.IRserveService;

@Service("pam")
public class PamAlgorithm extends AbstractClusteringAlgorithm implements IClusteringAlgorithm {

	@Autowired
	public PamAlgorithm(IRserveService rserveService, 
			@Value("${clustering.rserve.source.pam}") String rServeScriptSource) {
		
		this.rserveService = rserveService;
		this.rServeScriptSource = rServeScriptSource;
	}

	@Override
	public RserveResponse execClusteringMethod(RServeRequest request) {
		
		
		return callRServeService();
	}

}
