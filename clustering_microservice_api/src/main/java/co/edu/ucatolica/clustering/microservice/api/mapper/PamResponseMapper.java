package co.edu.ucatolica.clustering.microservice.api.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.edu.ucatolica.clustering.microservice.api.model.ClusteringExecData;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringPAMResponse;

@Component
public class PamResponseMapper implements Converter<ClusteringExecData, ClusteringPAMResponse> {

	@Override
	public ClusteringPAMResponse convert(ClusteringExecData source) {
		// TODO Auto-generated method stub
		return null;
	}

}
