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

/**
 *
 * @author benaryorg
 */
public class Fahrrad
{

	protected String fahrer;
	protected String farbe;
	protected double geschwindigkeit;
	protected double richtung;

	public Fahrrad()
	{
		this("N.N.");
	}

	public Fahrrad(String fahrer)
	{
		this(fahrer,"schwarz");
	}

	public Fahrrad(String fahrer,String farbe)
	{
		this(fahrer,farbe,0);
	}

	public Fahrrad(String fahrer,String farbe,double geschwindigkeit)
	{
		this(fahrer,farbe,geschwindigkeit,0);
	}

	public Fahrrad(String fahrer,String farbe,double geschwindigkeit,double richtung)
	{
		this.setFahrer(fahrer);
		this.setFarbe(farbe);
		this.setRichtung(richtung);
		this.setGeschwindigkeit(geschwindigkeit);
	}

	public String getFahrer()
	{
		return fahrer;
	}

	public final void setFahrer(String fahrer)
	{
		this.fahrer=fahrer;
	}

	public String getFarbe()
	{
		return farbe;
	}

	public final void setFarbe(String farbe)
	{
		this.farbe=farbe;
	}

	public double getGeschwindigkeit()
	{
		return geschwindigkeit;
	}

	public double getKmh()
	{
		return 3.6*this.getGeschwindigkeit();
	}

	public final void setGeschwindigkeit(double geschwindigkeit)
	{
		if(geschwindigkeit<0)
		{
			geschwindigkeit=0;
		}
		this.geschwindigkeit=geschwindigkeit;
	}

	public double getRichtung()
	{
		return richtung;
	}

	public final void setRichtung(double richtung)
	{
		if(richtung<-45)
		{
			richtung=-45;
		}
		if(richtung>45)
		{
			richtung=45;
		}
		this.richtung=richtung;
	}

	public void lenken(double grad)
	{
		this.setRichtung(this.richtung+grad);
	}

	public void beschleunigen(double a,double t)
	{
		this.setGeschwindigkeit(this.geschwindigkeit+a*t);
	}

	@Override
	public String toString()
	{
		return String.format("Fahrer: %s, Farbe: %s, Geschwindigkeit: %.2f, Richtung: %.2f",this.fahrer,this.farbe,this.getKmh(),this.richtung);
	}

	public static void main(String[] args)
	{
		Fahrrad r=new Fahrrad("Strampler","blau");
		r.lenken(10);
		r.beschleunigen(0.3,9.8);
		System.out.println(r);
	}
}
