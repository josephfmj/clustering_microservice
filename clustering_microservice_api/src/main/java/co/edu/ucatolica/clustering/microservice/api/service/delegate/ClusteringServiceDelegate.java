/**
 * Universidad Catolica de Colombia - Copyright (c) 2018
 * https://www.ucatolica.edu.co/
 * Date: 09/11/2018
 */
package co.edu.ucatolica.clustering.microservice.api.service.delegate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import co.edu.ucatolica.clustering.microservice.api.model.ClusterMethodConfig;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringData;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringExecData;
import co.edu.ucatolica.clustering.microservice.api.model.ClusteringExecutionRequest;
import co.edu.ucatolica.clustering.microservice.api.model.RserveResponse;
import co.edu.ucatolica.clustering.microservice.api.util.ClusteringAlgorithmStrategyProvider;

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
	
	private ClusteringExecutionRequest requestData;
	
	private ClusteringExecData execData;
	
	/**
	 * La fábrica de algoritmos de clustering
	 */
	@Autowired
	private ClusteringAlgorithmStrategyProvider algorithmStrategyProvider;

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
	public String prepareClusteringExec(ClusteringExecutionRequest request) {
		
		this.requestData=request;
		execData = new ClusteringExecData();
		ClusteringData data = new ClusteringData();
		data.setDate_data(new Date());
		data.setData_frame(request.getData_frame());
		ClusteringData savedData=dataRepository.save(data);
		execData.setDataId(savedData.getId().toString());
		execData = excutionRepository.save(execData);
		
		return request.getName()+SEPARATOR+execData.getId().toString();
		
		
	}
	
	/**
	 * Retorna los datos de una ejecucion previa
	 * @param Id el id de la ejecucion
	 * @return ClusteringExecData
	 */
	public ClusteringExecData getKmeansExecution(String Id) {
		
		return excutionRepository.findById(Id)
				.map(x -> x)
				.orElse(null);
	}	
	
	@Async
	public void asyncExecClusteringAlgorithm() {
		
		RserveResponse response = algorithmStrategyProvider.getProvider()
				.get(requestData.getName())
				.runAlgorithm(rserveRequestBuilder.buildRequest(requestData));
		
		execData.setResponse(response);
		excutionRepository.save(execData);
	}
	
	
}
