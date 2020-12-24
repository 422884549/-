package model;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import connect.Client;


public class Admin implements Serializable {
	private String aid;
	private String apw;

	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getApw() {
		return apw;
	}
	public void setApw(String apw) {
		this.apw = apw;
	}
	public Admin(String aid, String apw) {
		super();
		this.aid = aid;
		this.apw = apw;
	}
	public Admin(){}
	public String ALogin(String aid,String apw){
		//登陆
		try {
			if(aid.equals("") ){
				JOptionPane.showMessageDialog(null, "您未输入账号");
				return "no";
				}else
			if(apw.equals("")){
				JOptionPane.showMessageDialog(null, "您未输入密码");
				return "no";
			}
			else{
			Client c = new Client();
		Admin ad = c.Alogin(aid, apw);
		if(ad==null){
			JOptionPane.showMessageDialog(null, "登录失败");
			return "no";
		}
		else{
		JOptionPane.showMessageDialog(null, "登录成功");
		return "ok";
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
		return "no";
	}
	
	public Object[][] showFilm(){
		//查看所有电影
		//根据热度排序后生成一个有序的数组
				try {
					List<Film> flist = new Client().showFilm();
					Object[][] indexfilm = new Object[flist.size()][8];
					for(int i = 0;i<flist.size();i++) {
						indexfilm[i][0] = i+1;
						indexfilm[i][1] = flist.get(i).getFname();
						indexfilm[i][2] = flist.get(i).getDirector();
						indexfilm[i][3] = flist.get(i).getStar();
						indexfilm[i][4] = flist.get(i).getTime();
						indexfilm[i][5] = flist.get(i).getPrice();
						indexfilm[i][6] = flist.get(i).getLanguage();
						indexfilm[i][7] = flist.get(i).getHot();
						
					}
					for(int i = 0;i<indexfilm.length;i++){
						System.out.println("第"+i+"冒泡中");
						for(int j = 0;j< indexfilm.length -1-i;j++){
							System.out.println("冒泡位置"+j);
							 
							if(Integer.parseInt(indexfilm[j][7].toString()) < Integer.parseInt(indexfilm[j+1][7].toString())){
								Object[] o = {indexfilm[j][1],indexfilm[j][2],indexfilm[j][3],indexfilm[j][4],
										indexfilm[j][5],indexfilm[j][6],indexfilm[j][7]};
								indexfilm[j][1] = indexfilm[j+1][1];
								indexfilm[j][2] = indexfilm[j+1][2];
								indexfilm[j][3] = indexfilm[j+1][3];
								indexfilm[j][4] = indexfilm[j+1][4];
								indexfilm[j][5] = indexfilm[j+1][5];
								indexfilm[j][6] = indexfilm[j+1][6];
								indexfilm[j+1][1] = o[0];
								indexfilm[j+1][2] = o[1];
								indexfilm[j+1][3] = o[2];
								indexfilm[j+1][4] = o[3];
								indexfilm[j+1][5] = o[4];
								indexfilm[j+1][6] = o[5];
								indexfilm[j+1][7] = o[6];
					
							}
					}
					}
					for(int i = 0;i<indexfilm.length;i++){
						System.out.print(indexfilm[i][0]+"\t");
						System.out.print(indexfilm[i][1]+"\t");
						System.out.print(indexfilm[i][2]+"\t");
						System.out.print(indexfilm[i][3]+"\t");
						System.out.print(indexfilm[i][4]+"\t");
						System.out.print(indexfilm[i][5]+"\t");
						System.out.print(indexfilm[i][6]+"\t");
						System.out.print(indexfilm[i][7]+"\t\n");
					}
					return indexfilm;
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
	}
	
	public void setNewFilm(String Fname,String dir,String star,float price,String path,String language,String time){
		//添加电影
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmm");
		try {
			new Client().AddFilm("F"+date.format(new Date()), Fname, dir, star, path, price,language,time);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void setLastFilm(String Fname,String dir,String star,float price,String path,String language,String time){
		//电影修改
		try {
			if(path != null) {
			new Client().updateFilm(Fname, dir, star, path, price,language,time);
			}else {
				new Client().updateFilm2(Fname, dir, star, price,language,time);
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public void Deleteflim(String Fname) {//删除电影
		   try {
			new Client().Deleteflim(Fname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	 
	 public Object[][] FilmSearch(String msg){//电影搜索
			try {
				List<Film> flist = new Client().FilmSearch(msg);
				Object[][] indexfilm = new Object[flist.size()][8];
				for(int i = 0;i<flist.size();i++) {
					indexfilm[i][0] = i+1;
					indexfilm[i][1] = flist.get(i).getFname();
					indexfilm[i][2] = flist.get(i).getDirector();
					indexfilm[i][3] = flist.get(i).getStar();
					indexfilm[i][4] = flist.get(i).getTime();
					indexfilm[i][5] = flist.get(i).getPrice();
					indexfilm[i][6] = flist.get(i).getLanguage();
					indexfilm[i][7] = flist.get(i).getHot();
				}
				return indexfilm;
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			
		}
	 
	 public Object[][] showhall(){
			//查看所有大厅
			Object[][] halllist = null;
			try {
				halllist = new Client().showhall();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return halllist;
		}
	 
	 public Object[][] HallSearch(String msg){
		 Object[][] halllist = null;
		 try {
			halllist = new Client().HallSearch(msg);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return halllist;
	 }
	 
	 public void Deletehall(String Hid, String Hname) {//删除电影
		   try {
			new Client().Deletehall(Hid,Hname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	 
	 public void setNewHall(String Hname,String X,String Y){
			//添加大厅
			try {
				new Client().AddHall(Hname, X, Y);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 public void setLastHall(String Hname,String X,String Y){
			//大厅修改
			try {
				new Client().updateHall(Hname, X, Y);
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 public Object[][] SessionsSearch(String msg){
			//显示场次
			Object[][] sessionslist = null;
			
			try {
				sessionslist = new Client().SessionsSearch(msg);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return sessionslist;
		}
	 
	 public Object[][] showsessions(){
			//显示场次
			Object[][] sessionslist = null;
			
			try {
				sessionslist = new Client().showsessions();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return sessionslist;
		}
	 
	 public void deletesessions(String pid) {
			//删除场次
			   try {
				   Client c = new Client();
				c.deletesessions(pid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	 
	 public List<Object[]> findhall(){
		   try {
			return new Client().findHall();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		   
	   }
	 
	 public void manageHall(String Fname,Object[] hall,Date starttime,int playtime){
			//新增场次
			
			try {
				Client c = new Client();
				c.Addsessions(hall, Fname, starttime, playtime);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 public String Amendsessions(String playid,String Fname,Object[] hall,Date starttime,int playtime){
		   //修改场次
		  try {
			String i = new Client().Amendsessions(playid,hall, Fname, starttime, playtime);
			if(i.equals("ok")) {
				JOptionPane.showMessageDialog(null, "修改成功");
			}else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return Fname;  
	   }
	 
	 public Object[][] CommoditySearch(String msg){
			//搜索商品
			Object[][] Comlist = null;
			try {
				Comlist = new Client().CommoditySearch(msg);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Comlist;
		}
	 
	 public Object[][] showCommodity(){
			//查看所有商品
			Object[][] Comlist = null;
			try {
				Comlist = new Client().showCommodity();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Comlist;
		}
	 
	 public void Addcommodity(String Cname,float price,String content,String path) throws UnknownHostException, IOException{
			SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmm");
			//上架新商品
			Client c = new Client();
			c.Addcommodity("C"+date.format(new Date()), Cname, price,content,path);
			JOptionPane.showMessageDialog(null, "增添商品成功");
		}
	 
	 public void AmendCommodity(String Cname,float price,String content,String path) throws IOException{
			//修改商品信息
			try {if(path != null) {
				new Client().Amendcommodity(Cname, price, content, path);
				}else {
					new Client().Amendcommodity2(Cname, price, content);
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 public void deleteCommodity(String Cid){
			//停售某商品
		try {
			Client c;
			c = new Client();
			c.Deletecommodity(Cid);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	 
	 public Object[][] showhistory(){
			//显示购买记录
			Object[][] operationlist = null;
			
			try {
				operationlist = new Client().showhistory();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return operationlist;
		}
	 
	 public Object[][] UserhistorySearch(String msg){
			//搜索购买记录
			Object[][] operationlist = null;
			
			try {
				operationlist = new Client().UserhistorySearch(msg);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return operationlist;
		}
	 
	 public Object[][] UserSearch(String msg){
			//搜索用户
				Object[][] viplist = null;
				try {
					viplist = new Client().UserSearch(msg);
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return viplist;
		}
	 
	 public Object[][] showUser(){
			//查看用户
			
				Object[][] viplist = null;
				try {
					viplist = new Client().showUser();
				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return viplist;
		}
	 
	 public void deleteUser(String id){
			//清除违规及废弃用户
			try {
				new Client().downUser(id);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 
	 public Object[][] showComment(){
			//显示评论
			Object[][] Commlist = null;
			try {
				Commlist = new Client().showComment();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Commlist;
		}
	 public Object[][] commentSearch(String msg){
			//搜索评论
			Object[][] Commlist = null;
			try {
				Commlist = new Client().commentSearch(msg);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Commlist;
		}
	 
	 public void deletecomment(String Commid){
			//删除评论
		try {
			Client c;
			c = new Client();
			c.deletecomment(Commid);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static byte[] writeimg(String path) {
		byte[] bytes = null;
		try {
			FileInputStream fin = new FileInputStream(new File(path));
			bytes = new byte[fin.available()];
			fin.read(bytes);
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return bytes;
	}
	
}
