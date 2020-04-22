package comm.example.dao;

import java.util.List;

import comm.example.entity.Customer;

public interface CustomerDAO {

	
	  public List<Customer> getCustomers();
	  public Customer getCustomerById(int theId);
	  public void saveCustomer(Customer theCustomer);
	  public void deleteCustomer(int theId);
	  public void updateCustomer(Customer theCustomer);
}
