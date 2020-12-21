package com.demo.assignment.SampleAssignment;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.assignment.controller.CustomerController;
import com.demo.assignment.modal.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleAssignmentApplicationTests {

	@Autowired
	private CustomerController customerController;

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	int randomServerPort;

	@Test
	public void contextLoads() throws Exception {

		assertThat(customerController).isNotNull();
	}

	@Test
	public void testGetCustomerListSuccess() throws URISyntaxException {

		final String baseUrl = "http://localhost:" + randomServerPort + "/api/allCustomers";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());

	}

	@Test
	public void testForCreateCustomer() throws URISyntaxException {
		Customer customer = new Customer();
		customer.setCustomerId(1l);
		customer.setCustomerFirstName("kumar");
		customer.setCustomerLastName("Jai");

		final String baseUrl = "http://localhost:" + randomServerPort + "/api/customers";
		URI uri = new URI(baseUrl);

		ResponseEntity<Customer> result = restTemplate.postForEntity(uri, customer, Customer.class);

		Assertions.assertEquals(200, result.getStatusCodeValue());
		Assertions.assertEquals(Customer.class, result.getBody().getClass());

	}

	@Test
	public void testForGetCustomerById() throws URISyntaxException {

		final String baseUrl = "http://localhost:" + randomServerPort + "/api/customers/1";
		URI uri = new URI(baseUrl);

		ResponseEntity<Customer> result = restTemplate.getForEntity(uri, Customer.class);

		// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());

	}

	@Test
	public void testForTotalCount() throws URISyntaxException {

		final String baseUrl = "http://localhost:" + randomServerPort + "/api/customerCount";
		URI uri = new URI(baseUrl);

		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		// Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());

	}

}
