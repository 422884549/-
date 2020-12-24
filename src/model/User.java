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
		//用户登录
		try {
			
			if(id.equals("") || pw.equals("")){
				JOptionPane.showMessageDialog(null, "您未输入账号或密码");	
				}
			else{
		Client c = new Client();
		String name = c.Ulogin(id, pw);
		if(name.equals("")){
			JOptionPane.showMessageDialog(null, "登录失败");
		}
		else{
			this.uname =name;
			this.uid = id;
		JOptionPane.showMessageDialog(null, "登录成功");
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
		//用户注册
		try {
			if(uid.equals("") || upw.equals("")){
				JOptionPane.showMessageDialog(null, "您未输入账号或密码");	
			}else{
			String ok = new Client().Uregister(uid, upw, uname);
			if(ok.equals("ok")){
				JOptionPane.showMessageDialog(null, "注册成功");
				return 1;
			}
			if(ok.equals("idno")){
				JOptionPane.showMessageDialog(null, "已有账号，注册失败");
				return 2;
			}
			if(ok.equals("nameno")){
				JOptionPane.showMessageDialog(null, "用户名相同，注册失败");
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
		//充值
		float money = new Client().addMoney(name, addmoney);
		if(money == -1){
			JOptionPane.showMessageDialog(null, "账号不存在");
		}else{
			JOptionPane.showMessageDialog(null, "充值成功");
			
		}
		return money;
	}
	public float checkUSER(JTextField text) throws ClassNotFoundException, UnknownHostException, IOException{
		//查找ID
		float money = new Client().getUser(text.getText());
		return money;//返回卡号余额
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
		//购票（购票后hot属性+1 在服务端更改）
		int index = 0;
		for(int i = 0;i<5;i++){
			if(waitsize[i][0]==1){
				index = index + 1;
				//调用客户端-Fname,Hname,statttime(客户端每接受一次请求，就发送给服务端一次hot+1的请求)
				try {
					System.out.println(i);
					hot = new Client().getTicket(pid,hid,fname, hot,waitsize[i][1] , waitsize[i][2]);
					if(hot == -1) {
						System.out.println("添加失败");
						JOptionPane.showMessageDialog(null, "第"+index+"个提交失败   座位号为：列-"+(waitsize[i][1]+1)+"排-"+(waitsize[i][2]+1));
						
					}else {
						JOptionPane.showMessageDialog(null, "第"+index+"个提交成功   座位号为：列-"+(waitsize[i][1]+1)+"排-"+(waitsize[i][2]+1));
						new User().saveWorknote("电影"+fname+" 大厅"+hid+"  座位号为：列-"+(waitsize[i][1]+1)+"排-"+(waitsize[i][2]+1));
						money = new Client().consume(free,username,money);
						
						if(money < free && waitsize[i+1][0]==1) {
							JOptionPane.showMessageDialog(null, "余额不足");
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
			JOptionPane.showMessageDialog(null, "您还没有选择座位");
		}else {
			JOptionPane.showMessageDialog(null, "购票成功，您的余额为:"+money+"，祝您生活愉快");
		}
		System.out.println(index);
		return money;
	}
	
	public void saveWorknote(String operation) {
		//记录用户购票和购物记录
		try {
			System.out.println("id:"+User.uid);
			String b = new Client().MakeOperationNote(User.uid, User.uname,operation);
			System.out.println("添加进操作记录");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    
	}
	
	public int[][] chooseSeat(int x,int y,String pid){
		//顾客购票前可选择座位
		//获取影厅座位大小
		//获取当前已被购买的座位，1为已被购买，0为空座
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
		//购买零食等商品
		try {
			new User().saveWorknote("购买"+Cname+" 数量"+num+" ");
			new Client().getCommodity(Cname,Cid,price,num);
			money = new Client().consume1(price,username,money,num);
			JOptionPane.showMessageDialog(null, "您的余额为:"+money+"，祝您生活愉快");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
		
		}
	
	public Object[][] showcomment(String fname){
		//显示评论
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
		//添加评论
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
		//我的评论
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
		   //修改评论
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
