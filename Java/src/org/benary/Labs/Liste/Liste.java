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
package org.benary.Labs.Liste;

/**
 *
 * @author benaryorg
 */
public class Liste
{

	private Knoten anfang;
	private Knoten ende;
	private int laenge;

	public Liste()
	{

	}

	public Liste(Object data)
	{
		this.anfang=this.ende=new Knoten(data);
		this.laenge++;
	}

	public Knoten getAnfang()
	{
		return anfang;
	}

	public Knoten getEnde()
	{
		return ende;
	}

	public int getLaenge()
	{
		return laenge;
	}

	public void fuegeAmAnfangHinzu(Object data)
	{
		Knoten tmp=new Knoten(data);
		tmp.next=this.anfang;
		this.anfang=tmp;
		if(this.laenge<=0)
		{
			this.ende=tmp;
		}
		this.laenge++;
	}

	public void fuegeAmEndeHinzu(Object data)
	{
		if(this.laenge<=0)
		{
			this.fuegeAmAnfangHinzu(data);
		}
		else
		{
			Knoten tmp=new Knoten(data);
			this.ende.next=tmp;
			this.ende=tmp;
			this.laenge++;
		}
	}

	public void fuegeMittenDrinnenHinzu(int index,Object data) throws ListeOutOfBoundsException
	{
		if(index<0||index>this.laenge)
		{
			throw new ListeOutOfBoundsException("Index \""+index+"\" is out of bounds");
		}
		if(index==0)
		{
			this.fuegeAmAnfangHinzu(data);
		}
		else
		{
			if(index==this.laenge)
			{
				this.fuegeAmEndeHinzu(data);
			}
			else
			{
				Knoten tmp=this.anfang;
				while(index-->1)
				{
					tmp=tmp.next;
				}
				Knoten neu=new Knoten(data);
				neu.next=tmp.next;
				tmp.next=neu;
				this.laenge++;
			}
		}
	}

	public Knoten getKnotenAnStelle(int index)
	{
		if(index<0||index>this.laenge)
		{
			throw new ListeOutOfBoundsException("Index \""+index+"\" is out of bounds");
		}
		Knoten tmp=this.anfang;
		while(index-->0)
		{
			tmp=tmp.next;
		}
		return tmp;
	}

	public Object getDatenAnStelle(int index)
	{
		return this.getKnotenAnStelle(index).data;
	}

	public void setDatenAnStelle(int index,Object data)
	{
		this.getKnotenAnStelle(index).data=data;
	}

	@Override
	public String toString()
	{
		StringBuilder sb=new StringBuilder("[");
		Knoten tmp=this.anfang;
		while(tmp!=null)
		{
			sb.append(" ").append(tmp.data).append(" ");
			tmp=tmp.next;
			if(tmp!=null)
			{
				sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}

	public static void main(String... args)
	{
		Liste lst=new Liste();
		lst.fuegeAmAnfangHinzu(1);
		lst.fuegeAmAnfangHinzu(0);
		lst.fuegeAmEndeHinzu(3);
		lst.fuegeMittenDrinnenHinzu(2,2);
		System.out.println(lst);
	}
}
