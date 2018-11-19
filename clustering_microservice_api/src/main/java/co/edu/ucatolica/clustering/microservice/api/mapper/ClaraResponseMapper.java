package co.edu.ucatolica.clustering.microservice.api.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.edu.ucatolica.clustering.microservice.api.model.ClusteringCLARAResponse;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringExecData;

@Component
public class ClaraResponseMapper implements Converter<ClusteringExecData, ClusteringCLARAResponse> {

	@Override
	public ClusteringCLARAResponse convert(ClusteringExecData source) {
		// TODO Auto-generated method stub
		return null;
	}

}
