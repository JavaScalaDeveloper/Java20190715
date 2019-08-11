package cn.hjhstudy.TeamSchedular.domain;

public class Programmer extends Employee {
	private Status state;
	private String position;
	private Equipment equipment;
	private int tid;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getDetails() {
		return tid+"/"+getInfo()+"\t"+position;
	}
	public String toString(){
		return getInfo()+"\t"+state+"\t"+position+"\t\t\t"+equipment.getDescription();
	}
	
	public Programmer(int iD, String name, int age, double salary, Equipment equipment) {
		super(iD, name, age, salary);
		this.state = Status.FREE;
		this.position = "程序员";
		this.equipment = equipment;
	}
	public Status getState() {
		return state;
	}
	public void setState(Status state) {
		this.state = state;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	
	

}
