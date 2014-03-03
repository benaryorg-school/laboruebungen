/*
 * The MIT License
 *
 * Copyright 2014 benaryorg.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.benary.Labs;

/**
 *
 * @author benaryorg
 */
public class Person
{

	protected String zuname;
	protected String vorname;
	protected int geb;

	public static boolean gleichAlt(Person p1,Person p2)
	{
		return p1.geb==p2.geb;
	}

	public Person()
	{
		this(1970);
	}

	public Person(int geb)
	{
		this("N.N.",geb);
	}

	public Person(String name,int geb)
	{
		this(name,"N.N.",geb);
	}

	public Person(String name,String vorname,int geb)
	{
		this.setZuname(name);
		this.setVorname(vorname);
		this.setGeb(geb);
	}

	public final void setZuname(String zuname)
	{
		this.zuname=zuname;
	}

	public final void setVorname(String vorname)
	{
		this.vorname=vorname;
	}

	public final void setGeb(int geb)
	{
		if(geb>=1900&&geb<=java.util.Calendar.getInstance().get(java.util.Calendar.YEAR))
		{
			this.geb=geb;
		}

	}

	public String getZuname()
	{
		return zuname;
	}

	public String getVorname()
	{
		return vorname;
	}

	public int getGeb()
	{
		return geb;
	}

	public boolean gleichAlt(Person p)
	{
		return Person.gleichAlt(this,p);
	}

	public int getAlter()
	{
		return java.util.Calendar.getInstance().get(java.util.Calendar.YEAR)-this.geb;
	}

	@Override
	public String toString()
	{
		return this.zuname+" "+this.vorname;
	}

	public static void main(String[] args)
	{
		Person p=new Person();
		Person p1=new Person(1978);
		Person p2=new Person("Maier",1967);
		Person p3=new Person("Schmidt","Franz",1967);
		p1.setZuname("Bauer");
		p1.setVorname("Hans");
		p2.setVorname("Eva");
		System.out.println(p1+" ist "+p1.getAlter()+" Jahre alt.");
		if(p2.gleichAlt(p3))
		{
			System.out.println(p2+" und "+p3+" sind gleich alt.");
		}
		if(Person.gleichAlt(p2,p3))
		{
			System.out.println(p2+" und "+p3+" sind gleich alt.");
		}
	}
}
