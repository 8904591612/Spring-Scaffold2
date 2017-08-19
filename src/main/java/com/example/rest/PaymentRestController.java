package com.example.rest;
import com.example.model.Payment_reg;
import com.example.repository.Payment_regRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentRestController {
	
	@Autowired
	private Payment_regRepository payment_regRepository;
	
	@RequestMapping(value="/rest/payment_reg/index",method = RequestMethod.GET)
	public List<Payment_reg> getData(@RequestParam(value="endlessScrollingIndex",required=true) int endlessScrollingIndex ){
		
		int to =endlessScrollingIndex+10;
		if(to>payment_regRepository.findAll().size()){
			
			to=payment_regRepository.findAll().size();
		}else{
			
			to =endlessScrollingIndex+10;
			
		}
		
		List<Payment_reg> all = payment_regRepository.findAll().subList(endlessScrollingIndex, to);
		
		
		return all;
	}

}
