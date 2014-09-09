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
public class Auto
{

	protected String name;

	public void setName(String name)
	{
		this.name=name;
	}

	public void setMotor(boolean motor)
	{
		this.motor=motor;
	}

	public String getName()
	{
		return name;
	}

	public boolean isMotor()
	{
		return motor;
	}
	protected boolean motor;

	public Auto()
	{
		this("No Name",false);
	}

	public Auto(String name)
	{
		this(name,false);
	}

	public Auto(String name,boolean motor)
	{
		this.name=name;
		this.motor=motor;
	}

	public void starten()
	{
		this.motor=true;
	}

	public void abstellen()
	{
		this.motor=false;
	}

	@Override
	public String toString()
	{
		return this.name+", Motor an";
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
