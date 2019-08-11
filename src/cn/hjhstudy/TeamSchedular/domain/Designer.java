package cn.hjhstudy.TeamSchedular.domain;

public class Designer extends Programmer {
	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public Designer(int iD, String name, int age, double salary, Equipment equipment, double bonus) {
		super(iD, name, age, salary, equipment);
		this.setPosition("设计师");
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return getInfo()+"\t"+getState()+"\t"+getPosition()+"\t"+bonus+"\t\t"+getEquipment().getDescription();
	}

	@Override
	public String getDetails() {
		return super.getDetails()+"\t"+bonus;
	}
}
