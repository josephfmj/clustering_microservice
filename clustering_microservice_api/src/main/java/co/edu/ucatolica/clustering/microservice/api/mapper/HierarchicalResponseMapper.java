package co.edu.ucatolica.clustering.microservice.api.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.edu.ucatolica.clustering.microservice.api.model.ClusteringExecData;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringHIERARCHICALResponse;

@Component
public class HierarchicalResponseMapper implements Converter<ClusteringExecData, ClusteringHIERARCHICALResponse> {

	@Override
	public ClusteringHIERARCHICALResponse convert(ClusteringExecData source) {
		// TODO Auto-generated method stub
		return null;
	}

}
