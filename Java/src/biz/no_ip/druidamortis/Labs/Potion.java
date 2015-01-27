package biz.no_ip.druidamortis.Labs;

public class Potion
{

	Ingredient ingr1=null;
	Ingredient ingr2=null;
	Ingredient ingr3=null;
	int stirCount;

	Potion(Ingredient ingr1,Ingredient ingr2,Ingredient ingr3)
	{
		this.ingr1=ingr1;
		this.ingr2=ingr2;
		this.ingr3=ingr3;
	}

	public void stir()
	{
		this.stirCount++;
	}

	public boolean ready()
	{
		return (ingr1!=null&&ingr2!=null&&ingr3!=null&&this.stirCount>=5);
	}

	public int power()
	{
		if(ready())
		{
			return (ingr1.power()+ingr2.power()+ingr3.power())*2;
		}
		return ingr1.power()+ingr2.power()+ingr3.power();
	}

	@Override
	public String toString()
	{
		String a="ingr1: "+ingr1.toString()+" ingr2: "+ingr2.toString()+" ingr3: "+ingr3.toString();
		String b;
		if(this.ready())
		{
			b=a+", finished, power = ";
		}
		else
		{
			b=a+", not finished, power = ";
		}
		return b+this.power();
	}
}
