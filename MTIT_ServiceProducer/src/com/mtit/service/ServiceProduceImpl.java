package com.mtit.service;

public class ServiceProduceImpl implements ServiceProduce {

	@Override
	public String produceService() {
		// TODO Auto-generated method stub
		return "Execute the produce service of ServiceProducer";
	}

	@Override
	public int calculateTotal(int price, int qty) {
		int amount = price * qty;
		return amount;
	}












	

}
