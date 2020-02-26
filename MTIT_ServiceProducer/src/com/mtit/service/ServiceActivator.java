package com.mtit.service;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class ServiceActivator implements BundleActivator {

	ServiceRegistration produceServiceRegistration;


	public void start(BundleContext context) throws Exception {
		System.out.println("Producer Start");
		ServiceProduce produceService = new ServiceProduceImpl();
		produceServiceRegistration = context.registerService(ServiceProduce.class.getName(), produceService, null);
		
		
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Producer Stop");
		produceServiceRegistration.unregister();
		
	}

}
