package comm.example.bean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import comm.example.project.DaoImpl;
import comm.example.project.DaoInterface;
import comm.example.project.Person;

public class App {

	public static void main(String[] args) {
		
	//	ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		//Coach theCoach=context.getBean("myCoach",Coach.class);
//		System.out.println(theCoach.getDailyFortune());
//		System.out.println(theCoach.getDailyWorkout());
		System.out.println();

		
//		NameInterface refName=context.getBean("myDetails",NameInterface.class);
//		System.out.println(refName.getFirstName());
//		System.out.println(refName.getLastName());
//		System.out.println(refName.getAddress());
//		
		
//		Customer customer=context.getBean("theCustomer",Customer.class);
//		customer.setCustomerID(UUID.randomUUID().toString());
//		System.out.println(customer);
		
		DaoImpl refDaoImpl=new DaoImpl();
		
		Person refPerson= refDaoImpl.getContext();
	
		System.out.println(getPersonInfo(refPerson));
	}
		public static String getPersonInfo(Person refPerson)
		{
			return (refPerson.getName()+"\n"+ refPerson.getAge()+"\n"+refPerson.getHeight()+"\n"+refPerson.getAddress().getStreetNumber()+", "+refPerson.getAddress().getStreetName()+", "+refPerson.getAddress().getCity()+", "+refPerson.getAddress().getCountry());
		}
		
}

