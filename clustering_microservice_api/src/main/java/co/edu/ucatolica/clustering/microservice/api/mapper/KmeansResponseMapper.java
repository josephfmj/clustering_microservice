package co.edu.ucatolica.clustering.microservice.api.mapper;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import co.edu.ucatolica.clustering.microservice.api.model.ClusteringExecData;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringKMEANSResponse;
@Component
public class KmeansResponseMapper implements Converter<ClusteringExecData, ClusteringKMEANSResponse>{

	@Override
	public ClusteringKMEANSResponse convert(ClusteringExecData source) {
		// TODO Auto-generated method stub
		return null;
	}

}
