package cn.hjhstudy.TeamSchedular.domain;

public class NoteBook implements Equipment {
	private String modal;
	private double price;
	
	
	
	public NoteBook(String modal, double price) {
		super();
		this.modal = modal;
		this.price = price;
	}



	public String getModal() {
		return modal;
	}



	public void setModal(String modal) {
		this.modal = modal;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	@Override
	public String getDescription() {
		return modal+"("+price+")";
	}

}
