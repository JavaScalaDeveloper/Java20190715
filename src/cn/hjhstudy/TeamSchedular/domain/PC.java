package cn.hjhstudy.TeamSchedular.domain;

public class PC implements Equipment {
	private String modal;
	private String display;
	
	public PC(String modal, String display) {
		super();
		this.modal = modal;
		this.display = display;
	}

	public String getModal() {
		return modal;
	}

	public void setModal(String modal) {
		this.modal = modal;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String getDescription() {
		return modal+"("+display+")";
	}

}
