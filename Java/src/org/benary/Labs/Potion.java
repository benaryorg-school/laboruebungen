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
public class Potion
{

	protected Ingredient[] ings=new Ingredient[3];

	public Potion()
	{
		this(new Ingredient());
	}

	public Potion(Ingredient in1)
	{
		this(in1,new Ingredient());
	}

	public Potion(Ingredient in1,Ingredient in2)
	{
		this(in1,in2,new Ingredient());
	}

	public Potion(Ingredient in1,Ingredient in2,Ingredient in3)
	{
		ings[0]=in1;
		ings[1]=in2;
		ings[2]=in3;
	}

	public void setIngs(Ingredient[] ings)
	{
		this.ings=ings;
	}
	protected int stired=0;

	public Ingredient[] getIngs()
	{
		return ings;
	}

	public int getStired()
	{
		return stired;
	}

	public void stir()
	{
		this.stired++;
	}

	public boolean ready()
	{
		return this.stired>=5;
	}

	public int power()
	{
		int s=0;
		for(Ingredient i:this.ings)
		{
			s+=i.power();
		}
		return this.ready()?s*2:s;
	}

	@Override
	public String toString()
	{
		return String.format("%s, %s, %s, %s, %d, %d",ings[0],ings[1],ings[2],new Boolean(this.ready()).toString(),this.power(),this.getStired());
	}

	public static void main(String[] args)
	{
		Ingredient in1=new Ingredient("Toad");
		Ingredient in2=new Ingredient("Spider");
		Ingredient in3=new Ingredient("Lizard");
		Potion p=new Potion(in1,in2,in3);
		System.out.println(p);
		for(int i=0;i<5;i++)
		{
			p.stir();
			System.out.println(p);
		}
	}
}
