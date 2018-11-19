/**
 * Universidad Catolica de Colombia - Copyright (c) 2018
 * https://www.ucatolica.edu.co/
 * Date: 09/11/2018
 */
package co.edu.ucatolica.clustering.microservice.api.service.delegate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.edu.ucatolica.clustering.microservice.api.model.ClusterMethodConfig;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringCLARAResponse;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringData;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringExecData;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringHIERARCHICALResponse;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringKMEANSResponse;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringPAMResponse;
import co.edu.ucatolica.clustering.microservice.api.model.RserveResponse;
import co.edu.ucatolica.clustering.microservice.api.util.ClusteringAlgorithmStrategyBuilder;

/**
 * Delegado que actua como fachada que contiene todos los servicios relacionados al Clustering
 * 
 * @author <a href="mailto:jarubio67@ucatolica.edu.co"> Joseph Alexander Rubio Tapias</a>
 * @version 1.0
 * 
 */
@Service
public class ClusteringServiceDelegate extends AbstractClusteringServiceDelegate {
	
	/**
	 * Separador para el Id de retorno
	 */
	private static final String SEPARATOR="_";
	
	/**
	 * La fábrica de algoritmos de clustering
	 */
	@Autowired
	private ClusteringAlgorithmStrategyBuilder algorithmStrategyFactory;

	/**
	 * Obtiene todos los metodos de clustering
	 * @return la lista con los metodos de clustering
	 */
	public List<ClusterMethodConfig> getClusteringMethods(){
		
		return methodConfigRepository.findAll();
		
	}
	
	/**
	 * Ejecuta el algortimo de clustering seleccionado
	 * @param data los Datos de la ejecucion 
	 * @return el Id de la colleccion donde se guardan las ejecuciones
	 */
	public String exceClustering(ClusteringData data) {
		
		ClusteringExecData execData = new ClusteringExecData();
		ClusteringData savedData=dataRepository.save(data);
		execData.setDataId(savedData.getId().toString());
		execData = excutionRepository.save(execData);
		asyncExecClusteringAlgorithm(data, execData);
		
		return data.getClusteringType()+SEPARATOR+execData.getId().toString();
		
		
	}
	
	/**
	 * Retorna el modelo correspondiente a la respuesta de la ejecucion de Kmeans
	 * @param Id el id de la ejecucion
	 * @return ClusteringKMEANSResponse
	 */
	public ClusteringKMEANSResponse getKmeansExecution(String Id) {
		return kmeansResponseMapper.convert(excutionRepository.findById(Id).map(x -> x).orElse(null));
	}
	
	/**
	 * Retorna el modelo correspondiente a la respuesta de la ejecucion de Pam
	 * @param Id el id de la ejecucion
	 * @return ClusteringPAMResponse
	 */
	public ClusteringPAMResponse getPamExecution(String Id) {
		return pamResponseMapper.convert(excutionRepository.findById(Id).map(x -> x).orElse(null));
	}
	
	/**
	 * Retorna el modelo correspondiente a la respuesta de la ejecucion de Hierarchical
	 * @param Id el id de la ejecucion
	 * @return ClusteringHIERARCHICALResponse
	 */
	public ClusteringHIERARCHICALResponse getHierarchicalExecution(String Id) {
		return hierarchicalResponseMapper.convert(excutionRepository.findById(Id).map(x -> x).orElse(null));
	}
	
	/**
	 * Retorna el modelo correspondiente a la respuesta de la ejecucion de Clara
	 * @param Id el id de la ejecucion
	 * @return ClusteringCLARAResponse
	 */
	public ClusteringCLARAResponse getClaraExecution(String Id) {
		return claraResponseMapper.convert(excutionRepository.findById(Id).map(x -> x).orElse(null));
	}
	
	/**
	 * Metodo Asincrono que ejecuta el algoritmo de clustering 
	 * selecciona, actualiza la colleccion de ejecuciones
	 * @param data los Datos de la ejecucion 
	 * @param execData los datos de la colleccion de ejecuciones
	 */
	@Async
	private void asyncExecClusteringAlgorithm(ClusteringData data, ClusteringExecData execData) {
		
		RserveResponse response = new RserveResponse();
		
		try {
			response = algorithmStrategyFactory.getClusteringAlgorithmFactory()
					.get(data.getClusteringType())
					.runAlgorithm(rserveRequestBuilder.buildRequest(data));
		} catch (Exception e) {
			response.setDescription("Error en la ejecución");
		}
		
		execData.setResponse(response);
		excutionRepository.save(execData);
	}
	
	
}
