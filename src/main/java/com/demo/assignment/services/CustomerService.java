/**
 * 
 */
package com.demo.assignment.services;

import java.util.List;

import com.demo.assignment.modal.Customer;

/**
 * @author RAHUL
 *
 */
public interface CustomerService {

	public List<Customer> listOfAllCustomer();

	public Customer getCustomer(Long customerId);

	public Customer saveCustomer(Customer customer);

	public void deleteCustomer(Long customerId);

	public void updateCustomer(Customer customer);

	public Long countCustomer();
}
