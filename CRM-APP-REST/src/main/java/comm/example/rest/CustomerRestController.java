package comm.example.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import comm.example.entity.Customer;
import comm.example.exception.CustomerNotFoundException;
import comm.example.exception.CustomerResponseEntity;
import comm.example.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	

	@GetMapping("/customers")
	public List<Customer> getCustomers() {
		
		return customerService.getCustomers();
		
	}
		
	@GetMapping("/customers/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException
	{
		if ( customerService.getCustomerById(customerId)==null)
		{
			throw new CustomerNotFoundException("Customer id not found - " + customerId);
		}
		return customerService.getCustomerById(customerId);
	}
	
	@PostMapping("/customers")
	public void saveCustomer(@RequestBody Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
	}
	
	@PutMapping("/customers")
	public void updateCustomer(@RequestBody Customer theCustomer)
	{
		customerService.updateCustomer(theCustomer);
	}
	
	
		
	@DeleteMapping("/customers/{id}")
	public void deleteCustomer(@PathVariable int id) throws CustomerNotFoundException
	{
		if ( customerService.getCustomerById(id)==null)
		{
			throw new CustomerNotFoundException("Customer id not found - " + id);
		}
		else
		{
			customerService.deleteCustomer(id);
		}
	}
		
	
}









