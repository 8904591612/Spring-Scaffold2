package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.example.model.Payment_reg;
import com.example.repository.Payment_regRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class Payment_regService {

	@Autowired
	private Payment_regRepository payment_regRepository;

	public List<Payment_reg> findAll() {
		return payment_regRepository.findAll();
	}

	public Payment_reg findOne(Integer id) {
		return payment_regRepository.findOne(id);
	}
	
	@Transactional(readOnly = false)
	public Payment_reg save(Payment_reg entity) {
		return payment_regRepository.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete(Payment_reg entity) {
		payment_regRepository.delete(entity);
	}

}
	
