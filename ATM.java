package atm;

import java.io.*;
public class ATM {
	Account act;
	public ATM() {
		act = new Account("000","test","123",5000);
	}
	/******欢迎界面******/
	protected void Welcome() {
		String str = "------------------------------";
		System.out.print(str+"\n");
		System.out.print("-----------请选择你的操作----------：\n");
		System.out.print("1.取款"+"\n"+
			           	 "2.查询"+"\n"+
			           	 "3.存款"+"\n"+
			           	 "4.退出系统"+"\n");
		System.out.print(str+"\n");
	}
	
	protected void Load_Sys() throws Exception{
		String card,pwd;
		int counter = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("请输入您的卡号：");
			card = br.readLine();
			System.out.println("请输入您的密码：");
			pwd = br.readLine();
			if(!isRight(card,pwd)) {
				System.out.print("您输入的卡号或密码有误，请重新输入。\n");
				counter++;
			}
			else {
				SysOpter();
			}
		}while(counter<3);
		System.exit(1);
	}
	
	/**********系统操作提示**********/
	protected void SysOpter() throws Exception{
		int num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请选择您要操作的项目（1-4）：");
		num = br.read();
		switch(num) {
		case 49: GetBalance();      //num为Unicode码转换的整数
		case 50: Inqu_Info();
		case 51: AddBalance();
		case 52: Exit_Sys();
		default:
			SysOpter();
		}
		System.exit(1);
	}
	
	/**********信息查询**********/
	protected void Inqu_Info() throws Exception {
		System.out.print("-------------------\n"+
	                    "账号："+act.get_Number()+"\n"+
	                    "姓名："+act.get_Name()+"\n"+
	                    "余额："+act.get_Money()+"\n"+
	                    "-------------------\n");
		SysOpter();
	}
	
	/**********取款**********/
	protected void GetBalance() throws Exception{
		String str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("请输入取款金额：\n");
			str = br.readLine();
			double qu = Double.valueOf(str).doubleValue();
			if(qu>act.get_Money()) {
				System.out.println("余额不足，请重新输入取款金额.\n");	
			}
			else {
				act.sub_Balance(qu);
				System.out.println("取款成功，您的账户余额为："+act.get_Money());
				Welcome();
				SysOpter();
			}
		}while(true);
	}
	
	/**********存款**********/
	protected void AddBalance() throws Exception{
		String str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("请输入存款金额：\n");
			str = br.readLine();
			double cun = Double.valueOf(str).doubleValue();
			act.add_Balance(cun);
			System.out.println("存款成功，您的账户余额为："+act.get_Money());
			Welcome();
			SysOpter();
		}while(true);
	}
	
	/**********判断卡内是否有钱**********/
	protected boolean IsBalance() {
		if(act.get_Money()<0) {
			return false;
		}
		return true;
	}
	
	/**********判断卡号密码是否正确**********/
	protected boolean isRight(String card, String pwd) {
		if(act.get_Number().equals(card) && act.get_Password().equals(pwd)) {
			return true;
		}
		return false;
	}
	
	/**********退出系统**********/
	protected void Exit_Sys() {
		System.out.println("感谢您使用本系统，再见！");
		System.exit(1);
	}
}
