package comm.example.project;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoImpl implements DaoInterface {

	@Override
	public Person getContext() {
		// TODO Auto-generated method stub
		
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		return context.getBean("thePerson",Person.class);
		 
	}

}
