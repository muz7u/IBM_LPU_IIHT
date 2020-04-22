package comm.example.dao;

import java.util.List;
import javax.annotation.PostConstruct;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import comm.example.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


	@Autowired
	private SessionFactory sessionFactory;
	
	private Session currentSession;
	
	@PostConstruct
	public void init()
	{
		currentSession = sessionFactory.openSession();
	}
		
	@Transactional
	@Override
	public List<Customer> getCustomers() {
	
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by lastName",Customer.class);
		

		List<Customer> customers = theQuery.getResultList();	
		return customers;
	}
	@Transactional
	@Override
	public Customer getCustomerById(int theId)
	{
		Customer customer=currentSession.get(Customer.class, theId);
		return customer;
		
	}

	@Override
	public void saveCustomer(Customer theCustomer)
	{
		currentSession.getTransaction().begin();
		currentSession.saveOrUpdate(theCustomer);
		currentSession.getTransaction().commit();
	}



	@Override
	public void updateCustomer(Customer theCustomer)
	{
		currentSession.getTransaction().begin();
		currentSession.saveOrUpdate(theCustomer);
		currentSession.getTransaction().commit();
	}
	
	@Override
	public void deleteCustomer(int theId)
	{
		Customer customer=getCustomerById(theId);
		
		currentSession.getTransaction().begin();
		currentSession.remove(customer);
		currentSession.getTransaction().commit();
	}

}


