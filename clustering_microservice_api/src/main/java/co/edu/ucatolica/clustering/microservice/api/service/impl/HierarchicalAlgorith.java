package co.edu.ucatolica.clustering.microservice.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.edu.ucatolica.clustering.microservice.api.constants.ClusteringAlgorithmsConstants;
import co.edu.ucatolica.clustering.microservice.api.constants.ClusteringDIANAParams;
import co.edu.ucatolica.clustering.microservice.api.model.RServeRequest;
import co.edu.ucatolica.clustering.microservice.api.model.RserveResponse;
import co.edu.ucatolica.clustering.microservice.api.service.IClusteringAlgorithm;
import co.edu.ucatolica.clustering.microservice.api.service.IRserveService;

@Service("hierarchical")
public class HierarchicalAlgorith extends AbstractClusteringAlgorithm implements IClusteringAlgorithm {

	private String optionalSource;

	@Autowired
	public HierarchicalAlgorith(IRserveService rserveService,
			@Value("${clustering.rserve.source.agnes}") String rServeDefaultScriptSource,
			@Value("${clustering.rserve.source.diana}") String rServeScriptSource) {

		this.rserveService = rserveService;
		this.rServeScriptSource = rServeDefaultScriptSource;
		this.optionalSource = rServeScriptSource;

	}

	@Override
	public RserveResponse execClusteringMethod(RServeRequest request) {

		if (request.getParams().get(ClusteringAlgorithmsConstants.TYPE.name())
				.equals(ClusteringDIANAParams.DIANA.name())) {
			this.rServeScriptSource = optionalSource;
		}
		
		return callRServeService();
	}

}
