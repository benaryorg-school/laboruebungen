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
public class Rectangle
{

	private double width;
	private double length;

	public Rectangle()
	{
		this(1,1);
	}

	public Rectangle(double width,double length)
	{
		this.setWidth(width);
		this.setLength(length);
	}

	public static double correct(double s)
	{
		return s<1?1:s>20?20:s;
	}

	public double getLength()
	{
		return length;
	}

	public final void setLength(double length)
	{
		this.length=Rectangle.correct(length);
	}

	public double getWidth()
	{
		return width;
	}

	public final void setWidth(double width)
	{
		this.width=Rectangle.correct(width);
	}

	public double umfang()
	{
		return (this.length+this.width)*2;
	}
	
	public double flaeche()
	{
		return this.length*this.width;
	}
	
	@Override
	public String toString()
	{
		return this.width+";"+this.length;
	}
}
