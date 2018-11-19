/**
 * Universidad Catolica de Colombia - Copyright (c) 2018
 * https://www.ucatolica.edu.co/
 * Date: 09/11/2018
 */
package co.edu.ucatolica.clustering.microservice.api.service.delegate;

import org.springframework.beans.factory.annotation.Autowired;

import co.edu.ucatolica.clustering.microservice.api.mapper.ClaraResponseMapper;
import co.edu.ucatolica.clustering.microservice.api.mapper.HierarchicalResponseMapper;
import co.edu.ucatolica.clustering.microservice.api.mapper.KmeansResponseMapper;
import co.edu.ucatolica.clustering.microservice.api.mapper.PamResponseMapper;
import co.edu.ucatolica.clustering.microservice.api.repository.ClusterMethodConfigRepository;
import co.edu.ucatolica.clustering.microservice.api.repository.ClusteringDataRepository;
import co.edu.ucatolica.clustering.microservice.api.repository.ClusteringExecutionRepository;
import co.edu.ucatolica.clustering.microservice.api.util.RServeRequestBuilder;

/**
 * Delegado abstracto que actua  que contiene todos los servicios comunes y relacionados al Clustering
 * 
 * @author <a href="mailto:jarubio67@ucatolica.edu.co"> Joseph Alexander Rubio Tapias</a>
 * @version 1.0
 * 
 */
public abstract class AbstractClusteringServiceDelegate {
	
	/**
	 * Repositorio de ClusteringData
	 */
	@Autowired
	protected ClusteringDataRepository dataRepository;
	
	/**
	 * Repositorio de ClusteringExecData
	 */
	@Autowired
	protected ClusteringExecutionRepository excutionRepository;
	
	/**
	 * Repositorio de ClusterMethodConfig
	 */
	@Autowired
	protected ClusterMethodConfigRepository methodConfigRepository;
	
	/**
	 * Servicio para construir la peticion para Rserve
	 */
	@Autowired
	protected RServeRequestBuilder rserveRequestBuilder;
	
	/**
	 * El mapper para el modelo de respuesta de clara
	 */
	@Autowired
	protected ClaraResponseMapper claraResponseMapper;
	
	/**
	 * El mapper para el modelo de respuesta de hierarchical
	 */
	@Autowired
	protected HierarchicalResponseMapper hierarchicalResponseMapper;
	
	/**
	 * El mapper para el modelo de respuesta de kmeans
	 */
	@Autowired
	protected KmeansResponseMapper kmeansResponseMapper;
	
	/**
	 * El mapper para el modelo de respuesta de pam
	 */
	@Autowired
	protected PamResponseMapper pamResponseMapper;

}
