package co.edu.ucatolica.clustering.microservice.api.service;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;

public interface IRserveService {
	
	public void connectToRserve();
	
	public REXP createDataFrame(RList list, String[] rownames);
	
	public String executeRMethod(REXP dataframe);

}
