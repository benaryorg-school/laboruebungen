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
public interface Speaker
{

	public abstract String speak() throws DumbException;

}

class SpeakerClass
{

	public static void main(String... args)
	{
		Speaker arr[]=new Speaker[10];
		for(int i=0;i<arr.length;i++)
		{
			switch((int)((Math.random()-0.01)*3))
			{
				case 0:
				{
					arr[i]=new Human();
				}
				break;
				case 1:
				{
					arr[i]=new Dog();
				}
				break;
				case 2:
				{
					arr[i]=new Cat();
				}
				break;
			}
		}
		int anz=0;
		for(Speaker s:arr)
		{
			if(SpeakerClass.isHuman(s))
			{
				anz++;
			}
			try
			{
				System.out.println(s.speak());
			}
			catch(DumbException ex)
			{
				System.out.println("Human is dumb!");
			}
		}
		System.out.printf("%02d Humans!\n",anz);
	}

	public static boolean isHuman(Speaker s)
	{
		return s instanceof Human;
	}
}

class Human implements Speaker
{

	private final boolean dumb;

	public Human()
	{
		this.dumb=(Math.random()<=0.1); //10%
	}

	@Override
	public String speak() throws DumbException
	{
		if(this.dumb)
		{
			throw new DumbException();
		}
		return "Hallo";
	}

}

class Dog implements Speaker
{

	@Override
	public String speak()
	{
		return "Wau Wau";
	}

}

class Cat implements Speaker
{

	@Override
	public String speak()
	{
		return "Meow";
	}

}
