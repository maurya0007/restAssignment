package com.demo.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.assignment.modal.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
