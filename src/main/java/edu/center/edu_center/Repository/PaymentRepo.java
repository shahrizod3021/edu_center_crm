package edu.center.edu_center.Repository;

import edu.center.edu_center.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PaymentRepo extends JpaRepository<Payment, Integer> {
}
