package comm.example.bean;

public class Address implements AddressInterface{

	@Override
	public String getFirstAddress()
	{
		return "Ranchi,";
	}
	
	@Override
	public String getSecondAddress()
	{
		return "Jharkhand";
	}
}
