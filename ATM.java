package atm;

import java.io.*;
public class ATM {
	Account act;
	public ATM() {
		act = new Account("000","test","123",5000);
	}
	/******��ӭ����******/
	protected void Welcome() {
		String str = "------------------------------";
		System.out.print(str+"\n");
		System.out.print("-----------��ѡ����Ĳ���----------��\n");
		System.out.print("1.ȡ��"+"\n"+
			           	 "2.��ѯ"+"\n"+
			           	 "3.���"+"\n"+
			           	 "4.�˳�ϵͳ"+"\n");
		System.out.print(str+"\n");
	}
	
	protected void Load_Sys() throws Exception{
		String card,pwd;
		int counter = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.println("���������Ŀ��ţ�");
			card = br.readLine();
			System.out.println("�������������룺");
			pwd = br.readLine();
			if(!isRight(card,pwd)) {
				System.out.print("������Ŀ��Ż������������������롣\n");
				counter++;
			}
			else {
				SysOpter();
			}
		}while(counter<3);
		System.exit(1);
	}
	
	/**********ϵͳ������ʾ**********/
	protected void SysOpter() throws Exception{
		int num;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("��ѡ����Ҫ��������Ŀ��1-4����");
		num = br.read();
		switch(num) {
		case 49: GetBalance();      //numΪUnicode��ת��������
		case 50: Inqu_Info();
		case 51: AddBalance();
		case 52: Exit_Sys();
		default:
			SysOpter();
		}
		System.exit(1);
	}
	
	/**********��Ϣ��ѯ**********/
	protected void Inqu_Info() throws Exception {
		System.out.print("-------------------\n"+
	                    "�˺ţ�"+act.get_Number()+"\n"+
	                    "������"+act.get_Name()+"\n"+
	                    "��"+act.get_Money()+"\n"+
	                    "-------------------\n");
		SysOpter();
	}
	
	/**********ȡ��**********/
	protected void GetBalance() throws Exception{
		String str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("������ȡ���\n");
			str = br.readLine();
			double qu = Double.valueOf(str).doubleValue();
			if(qu>act.get_Money()) {
				System.out.println("���㣬����������ȡ����.\n");	
			}
			else {
				act.sub_Balance(qu);
				System.out.println("ȡ��ɹ��������˻����Ϊ��"+act.get_Money());
				Welcome();
				SysOpter();
			}
		}while(true);
	}
	
	/**********���**********/
	protected void AddBalance() throws Exception{
		String str = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			System.out.print("���������\n");
			str = br.readLine();
			double cun = Double.valueOf(str).doubleValue();
			act.add_Balance(cun);
			System.out.println("���ɹ��������˻����Ϊ��"+act.get_Money());
			Welcome();
			SysOpter();
		}while(true);
	}
	
	/**********�жϿ����Ƿ���Ǯ**********/
	protected boolean IsBalance() {
		if(act.get_Money()<0) {
			return false;
		}
		return true;
	}
	
	/**********�жϿ��������Ƿ���ȷ**********/
	protected boolean isRight(String card, String pwd) {
		if(act.get_Number().equals(card) && act.get_Password().equals(pwd)) {
			return true;
		}
		return false;
	}
	
	/**********�˳�ϵͳ**********/
	protected void Exit_Sys() {
		System.out.println("��л��ʹ�ñ�ϵͳ���ټ���");
		System.exit(1);
	}
}
