package cn.hjhstudy.TeamSchedular.domain;

public class Architect extends Designer {

	
	private double stock;
	@Override
	public String toString() {
		return getInfo()+"\t"+getState()+"\t"+getPosition()+"\t"+getBonus()+"\t"+stock+"\t"+getEquipment().getDescription();
	}
	
	public Architect(int iD, String name, int age, double salary, Equipment equipment, double bonus, double stock) {
		super(iD, name, age, salary, equipment, bonus);
		this.setPosition("架构师");
		this.stock = stock;
	}

	public double getStock() {
		return stock;
	}

	public void setStock(double stock) {
		this.stock = stock;
	}

	@Override
	public String getDetails() {
		return super.getDetails()+"\t"+stock;
	}
}
