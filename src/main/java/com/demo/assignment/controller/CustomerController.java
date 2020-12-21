/**
 * 
 */
package com.demo.assignment.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.assignment.exception.ResourceNotFoundException;
import com.demo.assignment.modal.Customer;
import com.demo.assignment.services.CustomerService;

/**
 * @author RAHUL
 *
 */
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired(required = true)
	private CustomerService customerService;

	@GetMapping("/allCustomers")
	public List<Customer> list() {
		List<Customer> customers = customerService.listOfAllCustomer();
		return customers;
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> getEmployee(@PathVariable(value = "customerId") long customerId)
			throws ResourceNotFoundException {
		Customer coustomerEntity = customerService.getCustomer(customerId);
		return new ResponseEntity<Customer>(coustomerEntity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> save(@RequestBody Customer customer) throws ResourceNotFoundException {
		Customer addCustomer = customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(addCustomer, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<?> update(@PathVariable(value = "id") long id, @RequestBody Customer customer) {
		try {
			Customer existCustomer = customerService.getCustomer(id);
			if (existCustomer.getCustomerId().equals(id)) {
				customerService.saveCustomer(customer);
			}
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/customerCount")
	public Long countCustomer() {
		return customerService.countCustomer();
	}

	@DeleteMapping("/{customerId}")
	public void delete(@PathVariable long customerId) {
		customerService.deleteCustomer(customerId);
	}

}
