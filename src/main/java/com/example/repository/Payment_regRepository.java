package com.example.repository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.model.Payment_reg;

@Repository
public interface Payment_regRepository extends JpaRepository<Payment_reg, Integer> {


	
	
	
}