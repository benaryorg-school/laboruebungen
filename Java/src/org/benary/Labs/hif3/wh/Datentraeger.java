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
package org.benary.Labs.hif3.wh;

/**
 *
 * @author benaryorg
 */
public abstract class Datentraeger
{

	private String titel;
	private double preis;
	private int megaByteGroesse;
	private static int gesamtAnzahl=0;

	public Datentraeger(String titel,double preis) throws WertNegativException
	{
		this(titel,preis,700);
	}

	public Datentraeger(String titel,double preis,int megaByteGroesse) throws WertNegativException
	{
		this.setTitel(titel);
		this.setPreis(preis);
		this.setMegaByteGroesse(megaByteGroesse);
		Datentraeger.gesamtAnzahl++;
	}

	public final String getTitel()
	{
		return titel;
	}

	public final void setTitel(String titel)
	{
		this.titel=titel;
	}

	public final double getPreis()
	{
		return preis;
	}

	public final void setPreis(double preis) throws WertNegativException
	{
		if(preis<0)
		{
			throw new WertNegativException("preis");
		}
		this.preis=preis;
	}

	private final void setMegaByteGroesse(int megaByteGroesse) throws WertNegativException
	{
		if(megaByteGroesse<0)
		{
			throw new WertNegativException("megaByteGroesse");
		}
		this.megaByteGroesse=megaByteGroesse;
	}

	public int getMegaByteGroesse()
	{
		return this.megaByteGroesse;
	}

	public static int getGesamtAnzahl()
	{
		return Datentraeger.gesamtAnzahl;
	}

	public final void drop()
	{
		Datentraeger.gesamtAnzahl--;
	}
	
	@Override
	public String toString()
	{
		return (new StringBuilder(this.getClass().getSimpleName()).append(": ").append(this.titel).append(':').append(this.preis).append(':').append(this.megaByteGroesse)).toString();
	}

	public static void main(String... args)
	{
		try
		{
			Datentraeger cd=new CD("DIIIIIIE CD",-6.66,1,false);
			System.out.println(cd);
			System.out.printf("%d Instanzen\n",Datentraeger.getGesamtAnzahl());
			cd.drop();
			System.out.printf("%d Instanzen\n",Datentraeger.getGesamtAnzahl());
		}
		catch(WertNegativException ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
		try
		{
			Datentraeger dvd=new DVD("DIIIIIIE DVD",-6.66,1,false,'~');
			System.out.println(dvd);
			System.out.printf("%d Instanzen\n",Datentraeger.getGesamtAnzahl());
			dvd.drop();
			System.out.printf("%d Instanzen\n",Datentraeger.getGesamtAnzahl());
		}
		catch(WertNegativException ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
		try
		{
			Datentraeger cd=new CD("DIIIIIIE CD",6.66,1,false);
			System.out.println(cd);
			cd.setPreis(-1);
			System.out.println(cd);
			System.out.printf("%d Instanzen\n",Datentraeger.getGesamtAnzahl());
			cd.drop();
			System.out.printf("%d Instanzen\n",Datentraeger.getGesamtAnzahl());
		}
		catch(WertNegativException ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
		try
		{
			Datentraeger dvd=new DVD("DIIIIIIE DVD",6.66,1,false,'~');
			System.out.println(dvd);
			dvd.setTitel("Meow");
			System.out.println(dvd);
			System.out.printf("%d Instanzen\n",Datentraeger.getGesamtAnzahl());
			dvd.drop();
			System.out.printf("%d Instanzen\n",Datentraeger.getGesamtAnzahl());
		}
		catch(WertNegativException ex)
		{
			ex.printStackTrace();
			System.out.println(ex);
		}
	}
}
