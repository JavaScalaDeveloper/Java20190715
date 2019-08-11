package cn.hjhstudy.TeamSchedular.domain;

public class Employee {

	private int ID;
	private String name;
	private int age;
	private double salary;
	
	public String getInfo(){
		return ID+"\t"+name+"\t"+age+"\t"+salary;
	}
	public String toString(){
		return getInfo();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(int iD, String name, int age, double salary) {
		super();
		ID = iD;
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	
}
