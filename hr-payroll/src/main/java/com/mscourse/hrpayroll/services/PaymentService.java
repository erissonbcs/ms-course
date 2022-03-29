package com.mscourse.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mscourse.hrpayroll.entities.Payment;
import com.mscourse.hrpayroll.entities.Worker;
import com.mscourse.hrpayroll.feignclients.WorkerFeignCliente;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignCliente workerFeignCliente;
	
	public Payment getPayment(long workerId, int days) {
		Worker worker = workerFeignCliente.findById(workerId).getBody();
		return new Payment(worker.getNome(), worker.getDailyIncome(), days);
	}
	
	//RestTemplate
	/*public Payment getPayment(long workerId, int days) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId);
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getNome(), worker.getDailyIncome(), days);
	}*/

}
