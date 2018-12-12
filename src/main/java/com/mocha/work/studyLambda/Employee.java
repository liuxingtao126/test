package com.mocha.work.studyLambda;

public class Employee {

	private String name;
    private int salary;
    private String office;
    
    public Employee()
    {
    	
    }
	public Employee(final String name, final int salary, final String office) {
		this.name = name;
		this.salary = salary;
		this.office = office;
	}
	public String getName() {
		return name;
	}
	public void setName(final String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(final int salary) {
		this.salary = salary;
	}
	public String getOffice() {
		return office;
	}
	public void setOffice(final String office) {
		this.office = office;
	}

	
	

}
