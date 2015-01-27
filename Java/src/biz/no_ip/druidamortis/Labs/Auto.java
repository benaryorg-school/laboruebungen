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
public class Auto
{

	String typ;
	boolean motorAn;

	public void starten()
	{
		motorAn=true;
	}

	public void abstellen()
	{
		motorAn=false;
	}

	public Auto(String marke,boolean motor)
	{
		this.typ=marke;
		this.motorAn=motor;
	}

	public Auto(String marke)
	{
		this(marke,false);
	}

	public Auto()
	{
		this(null);
	}

	@Override
	public String toString()
	{
		if(this.motorAn)
		{
			return this.typ+", Motor an";
		}
		return this.typ+", Motor aus";
	}

	public static void main(String[] args)
	{
		Auto a1=new Auto("BMW");
		Auto a2=new Auto("Porsche",true);

		System.out.println(a1);
		a1.starten();
		System.out.println(a1);
		System.out.println(a2);
		a2.abstellen();
		System.out.println(a2);
	}
}
