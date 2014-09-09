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
package org.benary.Labs.hif2;

import java.util.Arrays;

/**
 *
 * @author benaryorg
 */
public abstract class Medium implements Comparable
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

	@Override
	public int compareTo(Object obj)
	{
		if(!(obj instanceof Medium))
		{
			return 1;
		}
		Medium o=(Medium)obj;
		int x=(int)Math.ceil(this.getPreis()-o.getPreis());
		if(x==0)
		{
			x=this.getBezeichnung().toLowerCase().compareTo(o.getBezeichnung().toLowerCase());
		}
		return x==0?0:x<0?-1:1;
	}

	public static void main(String[] args)
	{
		Medium ms[]=
		{
			new Buch("Java ist auch eine Insel",55555555,2),
			new Buch("Python ist besser",25,499),
			new AudioCD("Java ist keine Insel",55555555,2),
			new AudioCD("Python ist besser",26,40)
		};
		Arrays.sort(ms);
		for(Medium m:ms)
		{
			m.info();
		}
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
		System.out.println("Preis: \t\t"+this.getPreis());
		System.out.println("Spielzeit: \t"+this.getLaufzeit());
	}
}

class Buch extends Medium
{

	private int seiten;

	public int getSeiten()
	{
		return seiten;
	}

	public final void setSeiten(int seiten)
	{
		this.seiten=seiten;
	}

	public double getLaufzeit()
	{
		return seiten;
	}

	public final void setLaufzeit(int seiten)
	{
		if(seiten>0)
		{
			this.seiten=seiten;
		}
	}

	public Buch()
	{
		this("");
	}

	public Buch(String bezeichnung)
	{
		this(bezeichnung,5);
	}

	public Buch(String bezeichnung,double preis)
	{
		this(bezeichnung,preis,5);
	}

	public Buch(String bezeichnung,double preis,int seiten)
	{
		super(bezeichnung,preis);
		this.setSeiten(seiten);
	}

	@Override
	public void info()
	{
		System.out.println("AudioCD: \t"+this.getBezeichnung());
		System.out.println("Preis: \t\t"+this.getPreis());
		System.out.println("Seiten: \t"+this.getSeiten());
	}
}
