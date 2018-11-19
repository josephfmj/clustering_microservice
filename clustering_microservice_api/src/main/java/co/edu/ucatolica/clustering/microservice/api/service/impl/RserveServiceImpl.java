package co.edu.ucatolica.clustering.microservice.api.service.impl;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.RList;
import org.springframework.stereotype.Service;

import co.edu.ucatolica.clustering.microservice.api.service.IRserveService;

@Service
public class RserveServiceImpl implements IRserveService {

	@Override
	public void connectToRserve() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public REXP createDataFrame(RList list, String[] rownames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String executeRMethod(REXP dataframe) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
