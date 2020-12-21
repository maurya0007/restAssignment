/**
 * 
 */
package com.demo.assignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.assignment.modal.Customer;
import com.demo.assignment.repository.CustomerRepository;

/**
 * @author RAHUL
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	public void setCustomerRepo(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}

	@Override
	public List<Customer> listOfAllCustomer() {

		List<Customer> customers = customerRepo.findAll();
		return customers;
	}

	@Override
	public Customer getCustomer(Long customerId) {
		Optional<Customer> optionalCustomer = customerRepo.findById(customerId);
		return optionalCustomer.get();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}

	@Override
	public void deleteCustomer(Long customerId) {
		customerRepo.deleteById(customerId);

	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepo.save(customer);
	}

	@Override
	public Long countCustomer() {

		return customerRepo.count();
	}

}
