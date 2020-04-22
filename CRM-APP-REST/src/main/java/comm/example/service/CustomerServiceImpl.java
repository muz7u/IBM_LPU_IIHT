package comm.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import comm.example.dao.CustomerDAO;
import comm.example.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	public Customer getCustomerById(int theId)
	{
		return customerDAO.getCustomerById(theId);
	}
	
	@Override
	public void saveCustomer(Customer theCustomer)
	{
		customerDAO.saveCustomer(theCustomer);
	}
	
	@Override
	public void updateCustomer(Customer theCustomer)
	{
		customerDAO.updateCustomer(theCustomer);
	}
	
	@Override
	public void deleteCustomer(int theId)
	{
		customerDAO.deleteCustomer(theId);
	}
}





