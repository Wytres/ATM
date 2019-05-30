package atm;

/*Account ���װ������Ϣ�����ֹ���*/
import java.io.*;
public class Account {
	private String number = null;
	private String name = null;
	private String password = null;
	private double money = 0.0;
	
	public Account (String number, String name, String password, double money) {
		this.number = number;
		this.name = name;
		this.password = password;
		this.money = money;
	}
	protected String get_Number() {
		return number;
	}
	protected String get_Name() {
		return name;
	}
	protected String get_Password() {
		return password;
	}
	protected double get_Money() {
		return money;
	}
	protected void sub_Balance(double mon) {    //������
		money -= mon;
	}
	protected void add_Balance(double mon) {    //�������
		money += mon;
	}
}
