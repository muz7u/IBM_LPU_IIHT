package comm.example.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import comm.example.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public Customer getCustomerById(int theId);
	public void saveCustomer(Customer theCustomer);
	public void deleteCustomer(int theId);
	public void updateCustomer(Customer theCustomer);

}
