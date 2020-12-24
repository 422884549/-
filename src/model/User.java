package model;




import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import connect.Client;



public class User implements Serializable{
	public static String uid;
	private String upw;
	public static String uname;
	public User(String uid,String upw,String uname) {
		// TODO Auto-generated constructor stub
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
	}
	public static String getUname() {
		return uname;
	}
	public static void setUname(String uname) {
		User.uname = uname;
	}
	public User(){}
	
	public int ULogin(String id,String pw){
		//�û���¼
		try {
			
			if(id.equals("") || pw.equals("")){
				JOptionPane.showMessageDialog(null, "��δ�����˺Ż�����");	
				}
			else{
		Client c = new Client();
		String name = c.Ulogin(id, pw);
		if(name.equals("")){
			JOptionPane.showMessageDialog(null, "��¼ʧ��");
		}
		else{
			this.uname =name;
			this.uid = id;
		JOptionPane.showMessageDialog(null, "��¼�ɹ�");
		return 1;
		}
			}
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int Uregister(String uid,String upw,String uname){
		//�û�ע��
		try {
			if(uid.equals("") || upw.equals("")){
				JOptionPane.showMessageDialog(null, "��δ�����˺Ż�����");	
			}else{
			String ok = new Client().Uregister(uid, upw, uname);
			if(ok.equals("ok")){
				JOptionPane.showMessageDialog(null, "ע��ɹ�");
				return 1;
			}
			if(ok.equals("idno")){
				JOptionPane.showMessageDialog(null, "�����˺ţ�ע��ʧ��");
				return 2;
			}
			if(ok.equals("nameno")){
				JOptionPane.showMessageDialog(null, "�û�����ͬ��ע��ʧ��");
				return 3;
			}
		  }
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public float addMoney(String name,float addmoney) throws UnknownHostException, IOException{
		//��ֵ
		float money = new Client().addMoney(name, addmoney);
		if(money == -1){
			JOptionPane.showMessageDialog(null, "�˺Ų�����");
		}else{
			JOptionPane.showMessageDialog(null, "��ֵ�ɹ�");
			
		}
		return money;
	}
	public float checkUSER(JTextField text) throws ClassNotFoundException, UnknownHostException, IOException{
		//����ID
		float money = new Client().getUser(text.getText());
		return money;//���ؿ������
	}
	public String getFilmcover(String fname) throws UnknownHostException, IOException {
		return new Client().getFilmcover(fname);
	}
	
	public List showFilm(){
		try {
			List list = new Client().showFilm();
			return list;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	public List managerHall(){
		try {
			List list = new Client().managerHall();
			return list;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
	}
	
	public float getTicket(String pid,String hid,String fname,int hot,String starttime,int[][] waitsize,float free,String username,float money) {
		// TODO Auto-generated method stub
		//��Ʊ����Ʊ��hot����+1 �ڷ���˸��ģ�
		int index = 0;
		for(int i = 0;i<5;i++){
			if(waitsize[i][0]==1){
				index = index + 1;
				//���ÿͻ���-Fname,Hname,statttime(�ͻ���ÿ����һ�����󣬾ͷ��͸������һ��hot+1������)
				try {
					System.out.println(i);
					hot = new Client().getTicket(pid,hid,fname, hot,waitsize[i][1] , waitsize[i][2]);
					if(hot == -1) {
						System.out.println("���ʧ��");
						JOptionPane.showMessageDialog(null, "��"+index+"���ύʧ��   ��λ��Ϊ����-"+(waitsize[i][1]+1)+"��-"+(waitsize[i][2]+1));
						
					}else {
						JOptionPane.showMessageDialog(null, "��"+index+"���ύ�ɹ�   ��λ��Ϊ����-"+(waitsize[i][1]+1)+"��-"+(waitsize[i][2]+1));
						new User().saveWorknote("��Ӱ"+fname+" ����"+hid+"  ��λ��Ϊ����-"+(waitsize[i][1]+1)+"��-"+(waitsize[i][2]+1));
						money = new Client().consume(free,username,money);
						
						if(money < free && waitsize[i+1][0]==1) {
							JOptionPane.showMessageDialog(null, "����");
							break;
						}
					}
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		if(index == 0){
			JOptionPane.showMessageDialog(null, "����û��ѡ����λ");
		}else {
			JOptionPane.showMessageDialog(null, "��Ʊ�ɹ����������Ϊ:"+money+"��ף���������");
		}
		System.out.println(index);
		return money;
	}
	
	public void saveWorknote(String operation) {
		//��¼�û���Ʊ�͹����¼
		try {
			System.out.println("id:"+User.uid);
			String b = new Client().MakeOperationNote(User.uid, User.uname,operation);
			System.out.println("��ӽ�������¼");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	
	public int[][] chooseSeat(int x,int y,String pid){
		//�˿͹�Ʊǰ��ѡ����λ
		//��ȡӰ����λ��С
		//��ȡ��ǰ�ѱ��������λ��1Ϊ�ѱ�����0Ϊ����
		int[][] seat = new int[x][y];
		
		if(!pid.equals("")) {	
			try {
				int[][] selectedlist = new Client().getSelectedSeat(pid);
				for(int i = 0;i<selectedlist.length;i++) {
					seat[selectedlist[i][0]][selectedlist[i][1]] = 1;
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return seat;
	}
	
	public String getCommcover(String cid) throws UnknownHostException, IOException {
		return new Client().getCommcover(cid);
	}
	
	public float getCommodity(String Cname,String Cid,float price,int num,String username,float money){
		//������ʳ����Ʒ
		try {
			new User().saveWorknote("����"+Cname+" ����"+num+" ");
			new Client().getCommodity(Cname,Cid,price,num);
			money = new Client().consume1(price,username,money,num);
			JOptionPane.showMessageDialog(null, "�������Ϊ:"+money+"��ף���������");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
		
		}
	
	public Object[][] showcomment(String fname){
		//��ʾ����
		Object[][] commentlist = null;
		
		try {
			commentlist = new Client().Usercomment(fname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return commentlist;
	}
	
	public void setcomment(String Fname,String uname,String comm){
		//�������
		try {
			new Client().Addcomment(Fname, uname, comm);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Object[][] myComment(String uname){
		//�ҵ�����
		Object[][] mycommentlist = null;
		
		try {
			mycommentlist = new Client().myComment(uname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mycommentlist;
	}
	
	public void updatecomment(String commid,String comm){
		   //�޸�����
		  try {
			new Client().updatecomment(commid,comm);
			
		  } catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
}
