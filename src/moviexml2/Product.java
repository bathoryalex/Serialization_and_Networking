package moviexml2;

public abstract class Product
{

	private String id;
	String title;
	Person person;

	public Product()
	{
		this.id = IdGenerator.generate(this);
	}

	public String getTitle()
	{
		return title;
	}

	public Person getPerson()
	{
		return person;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}

	public abstract long getInvestment();

}
