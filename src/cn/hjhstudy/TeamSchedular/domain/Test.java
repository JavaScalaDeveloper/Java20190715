package cn.hjhstudy.TeamSchedular.domain;

public class Test {
	
	public static void main(String[] args) {
		Architect a = new Architect(1, "张三", 12, 10000, new PC("联想","14寸"), 100000, 300000);
		System.out.println(a);
	}

}
