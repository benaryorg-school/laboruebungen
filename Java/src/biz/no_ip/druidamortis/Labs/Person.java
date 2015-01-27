/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.no_ip.druidamortis.Labs;

/**
 *
 * @author michael
 */
public class Person
{

	private String name;
	private String vorname;

	public String getName()
	{
		return this.name;
	}

	public String getVorname()
	{
		return this.vorname;
	}

	public void setName(String name)
	{
		this.name=name;
	}

	public void setVorname(String vorname)
	{
		this.vorname=vorname;
	}

	public Person(String name,String vorname)
	{
		this.setName(name);
		this.setVorname(vorname);
	}

	public Person(String name)
	{
		this(name,"N.N");
	}

	public Person()
	{
		this("N.N");
	}

	@Override
	public String toString()
	{
		return this.getName()+" "+this.getVorname();
	}

	public static void main(String[] args)
	{
		Person p1;
		p1=new Person();
		p1.setName("Schoettle");
		p1.setVorname("Lothar");
		System.out.println("Vorname : "+p1.getVorname());
		System.out.println("Name : "+p1.getName());
		Person p2=new Person("Klammer","Franz");
		System.out.println(p2); // Ausgabe: "Klammer Franz"
	}
}
