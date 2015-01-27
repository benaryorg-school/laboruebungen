package biz.no_ip.druidamortis.Labs;

public class Ingredient
{

	private String name;

	Ingredient()
	{
		this("");
	}

	Ingredient(String name)
	{
		this.name=name;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public int power()
	{
		return this.name.length();
	}

	@Override
	public String toString()
	{
		return this.name;
	}
}
