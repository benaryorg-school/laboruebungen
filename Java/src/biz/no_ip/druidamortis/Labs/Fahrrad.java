/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.no_ip.druidamortis.Labs;

/**
 *
 * @author michael
 */
public class Fahrrad
{

	private String fahrer;
	private String farbe;
	private int richtung;
	private double geschwindigkeit;

	public Fahrrad(String fahrer,String farbe,int richtung,double geschwindigkeit)
	{
		this.setFahrer(fahrer);
		this.setFarbe(farbe);
		this.setRichtung(richtung);
		this.setGeschwindigkeit(geschwindigkeit);
	}

	public Fahrrad(String fahrer,String farbe)
	{
		this(fahrer,farbe,0,0);
	}

	public Fahrrad()
	{
		this("N.N","orange");
	}

	public String getFahrer()
	{
		return this.fahrer;
	}

	public String getFarbe()
	{
		return this.farbe;
	}

	public int getRichtung()
	{
		return this.richtung;
	}

	public double getGeschwindigkeit()
	{
		return this.geschwindigkeit;
	}

	public void setFahrer(String fahrerNeu)
	{
		if(!fahrerNeu.isEmpty())
		{
			this.fahrer=fahrerNeu;
		}
	}

	public void setFarbe(String farbeNeu)
	{
		if(!farbeNeu.isEmpty())
		{
			this.farbe=farbeNeu;
		}
	}

	public void setRichtung(int richtungNeu)
	{
		if(richtungNeu>=-45&&richtungNeu<=45)
		{
			this.richtung=richtungNeu;
		}
	}

	public void setGeschwindigkeit(double geschwindigkeitNeu)
	{
		if(geschwindigkeitNeu>=0)
		{
			this.geschwindigkeit=geschwindigkeitNeu;
		}
	}

	public void lenken(int deltaR)
	{
		if(this.richtung+deltaR>=-45&&this.richtung+deltaR<=45)
		{
			this.richtung+=deltaR;
		}
	}

	public void beschleunigen(double a,double sec)
	{
		if(sec<=0)
		{
			return;
		}
		this.geschwindigkeit+=a*sec;
		if(this.geschwindigkeit<0)
		{
			this.geschwindigkeit=0;
		}
	}

	public double getKmh()
	{
		return this.geschwindigkeit*3.6;
	}

	@Override
	public String toString()
	{
		return "Fahrer: "+this.getFahrer()+", Farbe: "+this.getFarbe()+", Richtung: "+this.getRichtung()+", km/h: "+this.getKmh();
	}

	public static void main(String args[])
	{
		Fahrrad r=new Fahrrad("Strampler","blau");
		r.lenken(10);
		r.beschleunigen(0.3,9.8); // v = v + 0.3*9.8
		System.out.println(r);
	}

}
