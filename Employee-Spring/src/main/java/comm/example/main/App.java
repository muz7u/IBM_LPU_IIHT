package comm.example.main;

import java.util.Collection;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.EmployeeService;
import com.example.service.EmployeeServiceImpl;

import comm.example.model.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service=ctx.getBean("employeeServiceImpl", EmployeeServiceImpl.class);
        
        int key;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("enter your choice");
        System.out.println("1. Insert an employee");
        System.out.println("2.delete an employee");
        System.out.println("3. raise salary of an employee");
        System.out.println("4.List all employees");
        System.out.println("0. Exit Menu");
        key=sc.nextInt();
        
    while(key!=0)
    {
        switch (key) {
		case 1:
	        //create
	        Employee employee =service.createEmployee(new Employee("Nilay", 50000));
	        System.out.println("Data Inserted" + employee);
			break;

		case 2:
		       
	        //remove
	        service.removeEmployee(1);
			break;
		case 3:
	        //raise salary
			Employee employee1 = service.raiseEmployeeSalary(1, 1000);
			if (employee1 == null) {
				System.out.println("no employee with id entered");
			} else {
				System.out.println("Updated Employee: " + employee1);
			}
			break;
		case 4:
			//list all
			Collection<Employee> collection = service.findAllEmployees();
			for (Employee e : collection) {
				System.out.println(e);
			}
			break;
		case 0:
		       
	        //remove
	        System.exit(0);
			break;
			
		default:
			System.out.println("Please enter a valid choice");
			break;
		}
        
    }
        
        
    System.out.println("enter your choice");
    System.out.println("1. Insert an employee");
    System.out.println("2.delete an employee");
    System.out.println("3. raise salary of an employee");
    System.out.println("4.List all employees");
    System.out.println("0. Exit Menu");
    key=sc.nextInt();
       
		
		
    }
}
