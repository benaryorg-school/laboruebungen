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
public class Stadtrad extends Fahrrad
{

	protected boolean licht;

	public boolean getLicht()
	{
		return licht;
	}

	public final void setLicht(boolean licht)
	{
		this.licht=licht;
	}

	public Stadtrad()
	{
		this("N.N.");
	}

	public Stadtrad(String fahrer)
	{
		this(fahrer,"schwarz");
	}

	public Stadtrad(String fahrer,String farbe)
	{
		this(fahrer,farbe,false);
	}

	public Stadtrad(String fahrer,String farbe,boolean licht)
	{
		this(fahrer,farbe,licht,0);
	}

	public Stadtrad(String fahrer,String farbe,boolean licht,double geschwindigkeit)
	{
		this(fahrer,farbe,licht,geschwindigkeit,0);
	}

	public Stadtrad(String fahrer,String farbe,boolean licht,double geschwindigkeit,double richtung)
	{
		super(fahrer,farbe,geschwindigkeit,richtung);
		this.setLicht(licht);
	}

	@Override
	public String toString()
	{
		return super.toString()+", Licht "+(this.licht?"an":"aus");
	}

	public static void main(String args[])
	{
		Fahrrad r=new Stadtrad("Thomas","schwarz",false);
		r.lenken(10);
		r.beschleunigen(0.3,9.8);
		((Stadtrad)r).setLicht(true);
		System.out.println(r);
	}
}
