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
public abstract class Shape2D
{

	abstract double umfang();

	abstract double flaeche();

	abstract void info();

	public static void main(String[] args)
	{
		Shape2D f[]=new Shape2D[10];
		for(int i=0;i<f.length;i++)
		{
			f[i]=Math.random()>0.5?new Kreis(Math.random()*10):new Quadrat(Math.random()*10);
		}
		for(Shape2D s:f)
		{
			s.info();
		}
	}
}

class Kreis extends Shape2D
{

	private double radius;

	public Kreis()
	{
		this(5);
	}

	public Kreis(double radius)
	{
		this.setRadius(radius);
	}

	public double getRadius()
	{
		return radius;
	}

	public final void setRadius(double radius)
	{
		if(radius>0)
		{
			this.radius=radius;
		}
	}

	@Override
	public double umfang()
	{
		return 2*this.radius*Math.PI;
	}

	@Override
	public double flaeche()
	{
		return this.radius*this.radius*Math.PI;
	}

	@Override
	public void info()
	{
		System.out.printf("Kreis mit Radius %g\n",this.radius);
	}
}

class Quadrat extends Shape2D
{

	private double seite;

	public Quadrat()
	{
		this(5);
	}

	public Quadrat(double seite)
	{
		this.setSeite(seite);
	}

	public double getSeite()
	{
		return seite;
	}

	public final void setSeite(double seite)
	{
		if(seite>0)
		{
			this.seite=seite;
		}
	}

	@Override
	public double umfang()
	{
		return this.seite*4;
	}

	@Override
	public double flaeche()
	{
		return this.seite*this.seite;
	}

	@Override
	public void info()
	{
		System.out.printf("Quatrad mit Seite %g\n",this.seite);
	}
}
