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
public abstract class Medium
{

	private String bezeichnung;

	public String getBezeichnung()
	{
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung)
	{
		this.bezeichnung=bezeichnung;
	}

	public double getPreis()
	{
		return preis;
	}

	public final void setPreis(double preis)
	{
		if(preis>0)
		{
			this.preis=preis;
		}
	}
	private double preis;

	public Medium(String bezeichnung,double preis)
	{
		this.bezeichnung=bezeichnung;
		this.setPreis(preis);
	}

	public abstract void info();

	public int compareTo(Medium o)
	{
		int x=(int)Math.ceil(this.getPreis()-o.getPreis());
		if(x==0)
		{
			x=this.getBezeichnung().toLowerCase().compareTo(o.getBezeichnung().toLowerCase());
		}
		return x==0?0:x<0?-1:1;
	}

	public static void main(String[] args)
	{
		Medium m1=new AudioCD("test",25);
		Medium m2=new AudioCD("Test",25);
		System.out.println(m1.compareTo(m2));
	}
}

class AudioCD extends Medium
{

	private double laufzeit;

	public double getLaufzeit()
	{
		return laufzeit;
	}

	public final void setLaufzeit(double laufzeit)
	{
		if(laufzeit>0)
		{
			this.laufzeit=laufzeit;
		}
	}

	public AudioCD()
	{
		this("");
	}

	public AudioCD(String bezeichnung)
	{
		this(bezeichnung,5);
	}

	public AudioCD(String bezeichnung,double preis)
	{
		this(bezeichnung,preis,5);
	}

	public AudioCD(String bezeichnung,double preis,double laufzeit)
	{
		super(bezeichnung,preis);
		this.setLaufzeit(laufzeit);
	}

	@Override
	public void info()
	{
		System.out.println("AudioCD: \t"+this.getBezeichnung());
		System.out.println("Preis: \t"+this.getPreis());
		System.out.println("Spielzeit: \t"+this.getLaufzeit());
	}
}
