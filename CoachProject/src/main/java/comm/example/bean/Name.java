package comm.example.bean;

import lombok.Setter;

@Setter
public class Name implements NameInterface
{

	private AddressInterface refAddressInterface;
	
	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return "Ghulam";
	}
	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return "Mozammil";
	}
	
	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		String a=refAddressInterface.getFirstAddress();
		String b=refAddressInterface.getSecondAddress();
		
		return a+b;
	}

	
	
}
