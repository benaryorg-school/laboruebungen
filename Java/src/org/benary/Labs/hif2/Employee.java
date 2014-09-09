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
public abstract class Employee implements Payable
{

	private String firstname;
	private String lastname;

	public Employee()
	{
		this("N.N.");
	}

	public Employee(String lastname)
	{
		this("N.N.",lastname);
	}

	public Employee(String firstname,String lastname)
	{
		this.setFirstname(firstname);
		this.setLastname(lastname);
	}

	public String getFirstname()
	{
		return firstname;
	}

	public final void setFirstname(String firstname)
	{
		this.firstname=firstname;
	}

	public String getLastname()
	{
		return lastname;
	}

	public final void setLastname(String lastname)
	{
		this.lastname=lastname;
	}

	@Override
	public String toString()
	{
		return "Type: \""+this.getClass().getSimpleName().substring(0,this.getClass().getSimpleName().indexOf("Employee")).trim()+"\", Firstname: \""+firstname+"\", Lastname: \""+lastname+"\"";
	}

	public static void main(String... args)
	{
		Employee[] f=new Employee[3];
		f[0]=new PermanentEmployee("Franz","Schuster",15000.0);
		f[1]=new ContractEmployee("Hans","Huber",100.0);
		f[2]=new TemporaryEmployee("Barbara","Schmidt",7.5);
		String hourlyRate;
		java.text.NumberFormat nf=java.text.NumberFormat.getCurrencyInstance();
		for(Employee e:f)
		{
			System.out.print(e);
			hourlyRate=nf.format(e.calculateHourlyRate());
			System.out.println("Hourly rate: "+hourlyRate);
		}
	}
}

class ContractEmployee extends Employee
{

	double[] dailyRate=
	{
		0
	}; //EntlohnungsFELD

	public ContractEmployee()
	{
	}

	public ContractEmployee(String lastname)
	{
		super(lastname);
	}

	public ContractEmployee(String firstname,String lastname)
	{
		super(firstname,lastname);
	}

	public ContractEmployee(String firstname,String lastname,double dailyRate)
	{
		super(firstname,lastname);
		this.setDailyRate(dailyRate);
	}

	public double getDailyRate()
	{
		return dailyRate[0];
	}

	public final void setDailyRate(double dailyRate)
	{
		this.dailyRate[0]=dailyRate;
	}

	@Override
	public String toString()
	{
		return super.toString()+", Daily Rate: "+java.text.NumberFormat.getCurrencyInstance().format(this.getDailyRate());
	}

	@Override
	public double calculateHourlyRate()
	{
		return this.getDailyRate()/DEFAULT_WORK_HOURS_PER_DAY;
	}
}

class PermanentEmployee extends Employee
{

	double[] yearlyRate=
	{
		0
	}; //EntlohnungsFELD

	public PermanentEmployee()
	{
	}

	public PermanentEmployee(String lastname)
	{
		super(lastname);
	}

	public PermanentEmployee(String firstname,String lastname)
	{
		super(firstname,lastname);
	}

	public PermanentEmployee(String firstname,String lastname,double yearlyRate)
	{
		super(firstname,lastname);
		this.setYearlyRate(yearlyRate);
	}

	public double getYearyRate()
	{
		return yearlyRate[0];
	}

	public final void setYearlyRate(double yearlyRate)
	{
		this.yearlyRate[0]=yearlyRate;
	}

	@Override
	public String toString()
	{
		return super.toString()+", Yearly Rate: "+java.text.NumberFormat.getCurrencyInstance().format(this.getYearyRate());
	}

	@Override
	public double calculateHourlyRate()
	{
		return this.getYearyRate()/(DEFAULT_WORK_HOURS_PER_DAY*DEFAULT_WORK_DAYS_PER_YEAR);
	}
}

class TemporaryEmployee extends Employee
{

	double[] hourlyRate=
	{
		0
	}; //EntlohnungsFELD

	public TemporaryEmployee()
	{
	}

	public TemporaryEmployee(String lastname)
	{
		super(lastname);
	}

	public TemporaryEmployee(String firstname,String lastname)
	{
		super(firstname,lastname);
	}

	public TemporaryEmployee(String firstname,String lastname,double hourlyRate)
	{
		super(firstname,lastname);
		this.setHourlyRate(hourlyRate);
	}

	public double getHourlyRate()
	{
		return hourlyRate[0];
	}

	public final void setHourlyRate(double hourlyRate)
	{
		this.hourlyRate[0]=hourlyRate;
	}

	@Override
	public String toString()
	{
		return super.toString()+", Hourly Rate: "+java.text.NumberFormat.getCurrencyInstance().format(this.getHourlyRate());
	}

	@Override
	public double calculateHourlyRate()
	{
		return this.getHourlyRate();
	}
}

interface Payable
{

	double calculateHourlyRate();
	int DEFAULT_WORK_HOURS_PER_DAY=8;
	int DEFAULT_WORK_DAYS_PER_YEAR=250;
}
