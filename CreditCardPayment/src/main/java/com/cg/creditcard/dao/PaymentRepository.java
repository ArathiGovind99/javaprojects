package com.cg.creditcard.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.creditcard.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	@Query(value = " from Payment payment where payment.paymentId=?1")
	public Payment getPaymentById(int paymentId);
}
