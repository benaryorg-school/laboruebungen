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
public abstract class Figur implements Transformable,Scalable
{

	protected Origin origin;

	public Figur()
	{
		this(0,0);
	}

	public Figur(double x,double y)
	{
		this(new Origin(x,y));
	}

	public Figur(Origin p)
	{
		this.origin=(Origin)p.clone();
	}
}

class _Kreis extends Figur
{
	private double r;
	@Override
	public void transform(double a,double b)
	{

	}

	@Override
	public void scale(double a)
	{
		this.scale(a,a);
	}

	public void scale(double a,double b)
	{

	}

	@Override
	public String toString()
	{
		return this.origin+"/"+this.r;
	}

}

interface Transformable
{

	void transform(double x,double y);
}

interface Scalable
{

	void scale(double f);
}

class Origin
{

	private double x, y;

	public Origin()
	{
		this(0,0);
	}

	public Origin(double x,double y)
	{
		this.x=x;
		this.y=y;
	}

	@Override
	public Object clone()
	{
		try
		{
			return super.clone();
		}
		catch(CloneNotSupportedException ex)
		{
			return null;
		}
	}

	@Override
	public String toString()
	{
		return this.x+"/"+this.y;
	}
}
