package connect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Admin;
import model.Film;
import model.Sessions;

public class Server implements mypr{
	Socket s;
	ObjectInputStream ois ;
	ObjectOutputStream oos ;
	public Server()throws IOException, SQLException, ClassNotFoundException{
	ServerSocket ss = new ServerSocket(12345);
	while(true){
	    s = ss.accept();
		ois = new ObjectInputStream(s.getInputStream());
		oos = new ObjectOutputStream(s.getOutputStream());
		int command=ois.readInt();
		if(command==ALOGIN){
			ALogin();
		}
		if(command==ULOGIN){
			ULogin();
		}
		if(command==UREGISTER){
			URegister();
		}
		if(command==SHOWFILM){
			showFilm();
		}
		if(command==ADDFILM){
			addFilm();
		}
		if(command==UPDFILM){
			updFilm();
		}
		if(command==DELETEFLIM){
			Deleteflim();
		}
		if(command==SEARCHUSERHISTORY){
			UserhistorySearch();
		}
		if(command==SEARCHFILM){
			FilmSearch();
		}
		if(command==SEARCHHall){
			HallSearch();
		}
		if(command==SEARHSESSIONS){
			SessionsSearch();
		}
		if(command==SEARCHCOMMODITY){
			CommoditySearch();
		}
		if(command==SEARCHUSER){
			UserSearch();
		}
		if(command==SHOWHALL){
			showhall();
		}
		if(command==DELETEHALL){
			Deletehall();
		}
		if(command==ADDHALL){
			addHall();
		}
		if(command==UPDHALL){
			updHall();
		}
		if(command==SHOWSESSIONS){
			showsessions();
		}
		if(command==DELETESESSIONS){
			deletesessions();
		}
		if(command==FINDHALL){
			findhall();
		}
		if(command==ADDSESSIONS){
			Addsessions();
		}
		if(command==AMENDSESSIONS){
			Amendsessions();
		}
		if(command==SHOWCOMMODITY){
			showCommodity();
		}
		if(command==ADDCOMMODITY){
			Addcommodity();
		}
		if(command==AMENDCOMMODITY){
			Amendcommodity();
		}
		if(command==DELETECOMMODITY){
			Deletecommodity();
		}
		if(command==SHOWUSER){
			showuser();
		}
		if(command==DOWNUSER){
			downuser();
		}
		if(command==SHOWHISTORY){
			showhistory();
		}
		if(command==SHOWCOMMENT){
			showComment();
		}
		if(command==SEARCHCOMMENT){
			commentSearch();
		}
		if(command==DELETECOMMENT){
			deletecomment();
		}
		////
		if(command==ADDMON){
			addmoney();
		}
		if(command==GETUSER){
			getUser();
		}
		if(command==GETFILMCOVER){
			getFilmcover();
		}
		if(command==MANAGEHALL){
			managerHall();
		}
		if(command==GETSELECTEDSEAT){
			getSelectedSeat();
		}
		if(command==GETTICKET){
			getTicket();
		}
		if(command==COMSUME){
			comsume();
		}
		if(command==NOTE){
			MakeOpreationNote();
		}
		if(command==GETCOMMCOVER){
			getCommcover();
		}
		if(command==GETCOMMODITY){
			getCommodity();
		}
		if(command==COMSUME1){
			comsume1();
		}
		if(command==USERCOMMENT){
			Usercomment();
		}
		if(command==ADDCOMMENT){
			Addcomment();
		}
		if(command==MYCOMMENT){
			myComment();
		}
		if(command==UPDATECOMMENT){
			updatecomment();
		}
	  }
	}
	
	public void ALogin() throws IOException, SQLException, ClassNotFoundException{//管理员登录
		String ID = ois.readUTF();
		String pw =ois.readUTF();
		String sql = "select * from admin where aid ='"+ID+"' and apw ='"+pw+"'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		Admin ad=null;
		if(rs.next()){
			ad =new Admin(rs.getString(1),rs.getString(2));
			
	} 
		oos.writeObject(ad);
	    oos.flush();
	}
	public static void main(String[]arg){
		try {
			new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void  ULogin() throws IOException, SQLException, ClassNotFoundException{//用户登录
		String ID = ois.readUTF();
		String pw = ois.readUTF();
		String sql = "select * from user where uid ='"+ID+"' and upw ='"+pw+"'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		String name =null;
		if(rs.next()){
			name= rs.getString(3);
			oos.writeUTF(name);
	} 
		oos.writeUTF("");
		oos.flush();
}
	
	public void URegister() throws SQLException, ClassNotFoundException, IOException{//用户注册
		try {
			String uid = ois.readUTF();
			String upw = ois.readUTF();
			String uname = ois.readUTF();
			String sql = "select * from user where uid='"+uid+"'";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			if(rs.next()){
				oos.writeUTF("idno");
    		}else{
    			sql = "select * from user where Name='"+uname+"'";
    			ResultSet rs1 = Datahandle.getStatement().executeQuery(sql);
    		    if(rs1.next()){
    				oos.writeUTF("nameno");
        		}else{
        		sql = "insert into user values('"+uid+"','"+upw+"','"+uname+"',0)";
        		Datahandle.getStatement().executeUpdate(sql);
    			oos.writeUTF("ok");
    			}
    			}
			
			oos.flush();
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showFilm(){//显示所有电影
		try {
			String sql = "select * from film";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			List flist = new ArrayList<Film>();
			while(rs.next()){
				Film f = new Film();
				f.setFid(rs.getString(1));
				f.setFname(rs.getString(2));
				f.setDirector(rs.getString(3));
				f.setStar(rs.getString(4));
				f.setCover(rs.getString(5));
				f.setHot(rs.getInt(6));
				f.setPrice(rs.getFloat(7));
				f.setLanguage(rs.getString(8));
				f.setTime(rs.getString(9));
				flist.add(f);
			}
			oos.writeObject(flist);
			oos.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addFilm() {//添加电影
		try {
			String fid = ois.readUTF();
			String fname = ois.readUTF();
			String dirctor = ois.readUTF();
			String star = ois.readUTF();
			byte[] b = (byte[]) ois.readObject();
			String path = "img0/"+fname+".jpg";
			buff2Image(b, path);
			float price = ois.readFloat();
			String language= ois.readUTF();
			String time= ois.readUTF();
			String sql = "insert into film values('"+fid+"','"+fname+"','"+dirctor+"'," +
					"'"+star+"','"+path+"',0,"+price+",'"+language+"','"+time+"')";
			Datahandle.getStatement().executeUpdate(sql);
			oos.writeUTF("ok");
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updFilm() {//更新电影
		try {
			String fname = ois.readUTF();
			String dirctor = ois.readUTF();
			String star = ois.readUTF();
			String path = "img0/"+fname+".jpg";
			byte[] b = (byte[]) ois.readObject();
			if(b != null) {
				buff2Image(b, path);
			}
			float price = ois.readFloat();
			String time = ois.readUTF();
			String language = ois.readUTF();
			String sql = "update film set director = '"+dirctor+"', star = '"+star+"', price = '"+price+"'" +
					", time = '"+time+"', language = '"+language+"' where fname='"+fname+"'  ";
			Datahandle.getStatement().executeUpdate(sql);
			oos.writeUTF("ok");
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Deleteflim() throws IOException, ClassNotFoundException, SQLException {//删除电影
		String Fname = ois.readUTF();
		String sql = "delete from film  where Fname='"+Fname+"'";
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
		
	}
	
	public void FilmSearch() throws SQLException, ClassNotFoundException{//搜索电影
		try {
			String msg = ois.readUTF();
			String sql="select * from film where Fname like '%"+ msg+"%'";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			List flist = new ArrayList<Film>();
			while(rs.next()){
				Film f = new Film();
				f.setFid(rs.getString(1));
				f.setFname(rs.getString(2));
				f.setDirector(rs.getString(3));
				f.setStar(rs.getString(4));
				f.setCover(rs.getString(5));
				f.setHot(rs.getInt(6));
				f.setPrice(rs.getFloat(7));
				f.setLanguage(rs.getString(8));
				f.setTime(rs.getString(9));
				flist.add(f);
			}
			oos.writeObject(flist);
			oos.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void HallSearch() throws SQLException, ClassNotFoundException, IOException{//搜索大厅
		String msg = ois.readUTF();
		String sql="select * from hall where Hname like '%"+ msg+"%'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List halllist = new ArrayList();
		while(rs.next()){
			String Hid = rs.getString(1);
			String Hname = rs.getString(2);
			String X = rs.getString(3);
			String Y = rs.getString(4);
			Object[] hall = {Hid,Hname,X,Y};
			halllist.add(hall);
		}
		
		oos.writeObject(halllist);
		oos.flush();
	}
	public void showhall() throws SQLException, ClassNotFoundException, IOException{//显示大厅
		String sql = "select * from hall";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List halllist = new ArrayList();
		while(rs.next()){
			String Hid = rs.getString(1);
			String Hname = rs.getString(2);
			String X = rs.getString(3);
			String Y = rs.getString(4);
			Object[] hall = {Hid,Hname,X,Y};
			halllist.add(hall);
		}
		
		oos.writeObject(halllist);
		oos.flush();
	}
	
	public void Deletehall() throws IOException, ClassNotFoundException, SQLException {//删除大厅
		String Hid = ois.readUTF();
		String Hname = ois.readUTF();
		String sql = "delete from hall  where Hid='"+Hid+"'";	
		Datahandle.getStatement().executeUpdate(sql);
		 sql = "delete from sessions  where Hname='"+Hname+"'";	
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
		
	}
	
	private void addHall() {//添加大厅
		try {
			String Hname = ois.readUTF();
			String X = ois.readUTF();
			String Y = ois.readUTF();
			String sql = "insert into hall(Hname,X,Y) values('"+Hname+"','"+X+"','"+Y+"')";
			Datahandle.getStatement().executeUpdate(sql);
			oos.writeUTF("ok");
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void updHall() {//更新大厅
		try {
			String Hname = ois.readUTF();
			String X = ois.readUTF();
			String Y = ois.readUTF();
			String sql1 = "update sessions set X = '"+X+"', Y = '"+Y+"' where Hname='"+Hname+"'";
			Datahandle.getStatement().executeUpdate(sql1);
			String sql = "update hall set X = '"+X+"', Y = '"+Y+"' where Hname='"+Hname+"'";
			Datahandle.getStatement().executeUpdate(sql);
			oos.writeUTF("ok");
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SessionsSearch() throws SQLException, ClassNotFoundException, IOException{//搜索场次
		String msg = ois.readUTF();
		String sql="select * from sessions where Fname like '%"+ msg+"%'or Hname like '%"+ msg+"%'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List sessionslist = new ArrayList();
		while(rs.next()){
			String Hname= rs.getString(1);
			String Fname = rs.getString(2);
			Timestamp time = rs.getTimestamp(3);
			SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String starttime = simpledate.format(time);
			int playtime = rs.getInt(4);
			int x = rs.getInt(5);
			int y = rs.getInt(6);
			int a =(x)*(y); 
			String playid = rs.getString(7);
			Object[] hallmanage = {playid,Hname,Fname,starttime,a,playtime};
			sessionslist.add(hallmanage);
		}
		
		oos.writeObject(sessionslist);
		oos.flush();
	}
	
	public void showsessions() throws SQLException, ClassNotFoundException, IOException{//显示场次
		String sql = "select * from sessions";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List sessionslist = new ArrayList();
		while(rs.next()){
			String Hname= rs.getString(1);
			String Fname = rs.getString(2);
			Timestamp time = rs.getTimestamp(3);
			SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String starttime = simpledate.format(time);
			int playtime = rs.getInt(4);
			int x = rs.getInt(5);
			int y = rs.getInt(6);
			int a =(x)*(y); 
			String playid = rs.getString(7);
			Object[] hallmanage = {playid,Hname,Fname,starttime,a,playtime};
			sessionslist.add(hallmanage);
		}
		
		oos.writeObject(sessionslist);
		oos.flush();
	}
	
	private void findhall() {
		try {
			String sql = "select * from hall";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			List halllist = new ArrayList();
			while(rs.next()){
				String Hname= rs.getString(2);
				int x = rs.getInt(3);
				int y = rs.getInt(4);
				Object[] hall = {Hname,x,y};
				halllist.add(hall);
			}
			
			oos.writeObject(halllist);
			oos.flush();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletesessions() throws IOException, SQLException, ClassNotFoundException{//删除场次
		String pid = ois.readUTF();
		String sql = "delete from sessions where PlayID='"+pid+"'";
		String sql1 = "delete from Seat where PlayID='"+pid+"'";
		System.out.println(sql);
		System.out.println(sql1);
		Datahandle.getStatement().executeUpdate(sql);
		Datahandle.getStatement().executeUpdate(sql1);
		oos.writeUTF("ok");
		oos.flush();
	}
	
	public void Addsessions() throws IOException, SQLException, ClassNotFoundException{//增加场次
		Object[] Hall = (Object[]) ois.readObject();
		String Fname = ois.readUTF();
		Date starttime = (Date) ois.readObject();
		int playtime = ois.readInt();
		Timestamp time = new Timestamp(starttime.getTime());
		SimpleDateFormat setdate = new SimpleDateFormat(Hall[0]+"yyyyMMddHHmm");
		String sql = "insert into sessions values('"+Hall[0]+"','"+Fname+"','"+time+"','"+playtime+"',"+Hall[1]+","+Hall[2]+",'"+setdate.format(starttime)+"')";
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
	}
	
	public void Amendsessions() throws ClassNotFoundException, IOException, SQLException {//修改场次
		String playid = ois.readUTF();
		Object[] Hall = (Object[]) ois.readObject();
		String Fname = ois.readUTF();
		Date starttime = (Date)ois.readObject();
		int playtime = ois.readInt();
		Timestamp time = new Timestamp(starttime.getTime());
		String sql = "update sessions set Fname = '"+Fname+"', starttime = '"+time+"'" +
				", playtime = '"+playtime+"'where PlayID = '"+playid+"' " ;
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
		
	}
	
	public void CommoditySearch() throws SQLException, ClassNotFoundException, IOException{//搜索商品
		String msg = ois.readUTF();
		String sql="select * from commodity where Cname like '%"+ msg+"%'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List Comlist = new ArrayList();
		while(rs.next()){
			String Cid = rs.getString(1);
			String Cname = rs.getString(2);
			String content = rs.getString(4);
			float price = rs.getFloat(5);
			String hot = rs.getString(6);
			Object[] commodity = {Cid,Cname,content,price,hot};
			Comlist.add(commodity);
		}
		
		oos.writeObject(Comlist);
		oos.flush();
	}
	
	public void showCommodity() throws SQLException, ClassNotFoundException, IOException{//显示所有商品
		String sql = "select * from commodity";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List Comlist = new ArrayList();
		while(rs.next()){
			String Cid = rs.getString(1);
			String Cname = rs.getString(2);
			String content = rs.getString(4);
			float price = rs.getFloat(5);
			String hot = rs.getString(6);
			Object[] commodity = {Cid,Cname,content,price,hot};
			Comlist.add(commodity);
		}
		
		oos.writeObject(Comlist);
		oos.flush();
	}
	
	public void Addcommodity() throws IOException, SQLException, ClassNotFoundException{//添加商品
		String Cid = ois.readUTF();
		String Cname = ois.readUTF();
		float price = ois.readFloat();
		String content = ois.readUTF();
		byte[] img = (byte[]) ois.readObject();
		String path = "img0/"+Cname+".jpg";
		try {
			buff2Image(img,path );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="insert into commodity values('"+Cid+"','"+Cname+"','"+path+"','"+content+"',"+price+",0)";
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
	}
	
	public void Amendcommodity() throws IOException, ClassNotFoundException, SQLException {//修改商品
		String Cname = ois.readUTF();
		float price = ois.readFloat();
		String content = ois.readUTF();
		byte[] img = (byte[]) ois.readObject();
		String path = "img0/"+Cname+".jpg";
		if(img != null) {
			try {
				buff2Image(img, path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String sql = "update commodity set Price = "+price+", content ='"+content+"' where Cname = '"+Cname+"'" ;
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
	}
	
	public void Deletecommodity() throws IOException, SQLException, ClassNotFoundException{//删除商品
		String Cid = ois.readUTF();
		String sql = "delete from commodity where Cid='"+Cid+"'";
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
	}
	static void buff2Image(byte[] b,String tagSrc) throws Exception
    {
        FileOutputStream fout = new FileOutputStream(tagSrc);
        //将字节写入文件
        fout.write(b);
        fout.close();
    }
	 
	public void showuser(){//展示所有用户
		try {
			String sql = "select * from user";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			List userlist = new ArrayList();
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(3);
				float money = rs.getFloat(4);
				Object[] user = {id,name,money};
				userlist.add(user);
			}
			oos.writeObject(userlist);
			oos.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void UserSearch(){//搜索用户
		try {
			String msg = ois.readUTF();
			String sql="select * from user where uid like '%"+ msg+"%'or Name like '%"+ msg+"%'";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			List userlist = new ArrayList();
			while(rs.next()){
				String id = rs.getString(1);
				String name = rs.getString(3);
				float money = rs.getFloat(4);
				Object[] user = {id,name,money};
				userlist.add(user);
			}
			oos.writeObject(userlist);
			oos.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	public void downuser(){//删除用户
		try {
			String uid = ois.readUTF();
			String sql ="delete from user where uid='"+uid+"'";
			Datahandle.getStatement().executeUpdate(sql);
			oos.writeUTF("OK");
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UserhistorySearch() throws SQLException, ClassNotFoundException, IOException{//搜索购买记录
		String msg = ois.readUTF();
		String sql="select * from history where id like '%"+ msg+"%'or name like '%"+ msg+"%'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List historylist = new ArrayList();
		while(rs.next()){
			String ID= rs.getString(1);
			String name = rs.getString(2);
			Timestamp time = rs.getTimestamp(3);
			SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String history = rs.getString(4);
			Object[] history1 = {ID,name,time,history};
			historylist.add(history1);
		}
		
		oos.writeObject(historylist);
		oos.flush();
	}
	
	public void showhistory() throws SQLException, ClassNotFoundException, IOException{//购买记录
		String sql = "select * from history";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List historylist = new ArrayList();
		while(rs.next()){
			String ID= rs.getString(1);
			String name = rs.getString(2);
			Timestamp time = rs.getTimestamp(3);
			SimpleDateFormat simpledate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			String history = rs.getString(4);
			Object[] history1 = {ID,name,time,history};
			historylist.add(history1);
		}
		
		oos.writeObject(historylist);
		oos.flush();
	}
	
	public void showComment() throws SQLException, ClassNotFoundException, IOException{//显示所有评论
		String sql = "select * from comment";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List Commlist = new ArrayList();
		while(rs.next()){
			String commid = rs.getString(1);
			String fame = rs.getString(2);
			String uname = rs.getString(3);
			String comm = rs.getString(4);
			Object[] Comment = {commid,fame,uname,comm};
			Commlist.add(Comment);
		}
		
		oos.writeObject(Commlist);
		oos.flush();
	}
	
	public void commentSearch() throws SQLException, ClassNotFoundException, IOException{//搜索评论
		String msg = ois.readUTF();
		String sql="select * from comment where fname like '%"+ msg+"%'or uname like '%"+ msg+"%'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List Commlist = new ArrayList();
		while(rs.next()){
			String commid = rs.getString(1);
			String fame = rs.getString(2);
			String uname = rs.getString(3);
			String comm = rs.getString(4);
			Object[] comment = {commid,fame,uname,comm};
			Commlist.add(comment);
		}
		
		oos.writeObject(Commlist);
		oos.flush();
	}
	
	public void deletecomment() throws IOException, SQLException, ClassNotFoundException{//删除评论
		String Commid = ois.readUTF();
		String sql = "delete from comment where Commid='"+Commid+"'";
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
	}
	/////////
	//////////
	public void addmoney(){//充值
		try {
			String name = ois.readUTF();
			float addmon = ois.readFloat();
			String sql1="select Money from user where Name ='"+name+"'";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql1);
			if(rs.next()){
				addmon = addmon + rs.getFloat("money");
				String sql2="update user set money='"+addmon+"'where Name ='"+name+"'";
				Datahandle.getStatement().executeUpdate(sql2);
			}else{
				addmon = -1;
			}
			oos.writeFloat(addmon);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getUser() throws IOException, SQLException, ClassNotFoundException{//查找用户
		String id = ois.readUTF();
		String sql = "select money from user where Name='"+id+"'";
		ResultSet rs =Datahandle.getStatement().executeQuery(sql);
		if(rs.next()){
			oos.writeFloat(rs.getFloat("money"));
			oos.flush();
		}
	}
	
	public void getFilmcover() {
		try {
			String fname = ois.readUTF();
			String sql = "select cover from film where Fname='"+fname+"'";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			rs.next();
			String path = rs.getString("cover");
			byte[] img = writeimg(path);
			oos.writeObject(img);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void managerHall(){
		try {
			//获取影厅安排数据
			String sql = "select * from sessions";
			ResultSet rs =Datahandle.getStatement().executeQuery(sql);
			List managerhall = new ArrayList();
			while(rs.next()){
				Sessions m = new Sessions();
				m.setFname(rs.getString(2));
				m.setHname(rs.getString(1));
				m.setStarttime(rs.getDate(3));
				m.setPlaytime(rs.getInt(4));
				m.setX(rs.getInt(5));
				m.setY(rs.getInt(6));
				m.setPlayID(rs.getString(7));
				managerhall.add(m);
			}
			oos.writeObject(managerhall);
			oos.flush();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getSelectedSeat() {
		try {
			String pid = ois.readUTF();
			String sql = "select * from Seat where PlayID='"+pid+"'";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			List l = new ArrayList();
			while(rs.next()) {
				int[] i = new int[2];
				i[0] = rs.getInt(3);
				i[1] = rs.getInt(4);
				l.add(i);
			}
			int[][] ii = new int[l.size()][2];
			for(int i=0;i<ii.length;i++) {
				int[] now = (int[])l.get(i);
				ii[i][0] = now[0];
				ii[i][1] = now[1];
			}
			oos.writeObject(ii);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getTicket(){//买票
		try {
			String pid = ois.readUTF();
			String hid = ois.readUTF();
			String Fname = ois.readUTF();
			int hot=ois.readInt();
			int x = ois.readInt();
			int y = ois.readInt();
			String sql1 = "select * from Seat where PlayID='"+pid+"'";
			try {
				ResultSet rs = Datahandle.getStatement().executeQuery(sql1);
				while(rs.next()) {
					if((x==rs.getInt("x")) && (y==rs.getInt("y"))) {
						hot = -1;
						oos.writeInt(hot);
						oos.flush();
						break;
					}
				}
				if(hot != -1) {
					String sql2 = "insert into Seat values('"+hid+"','"+pid+"',"+x+","+y+")";
					String sql3 = "update film set Hot='"+(hot+1)+"'where Fname ='"+Fname+"'";
					Datahandle.getStatement().executeUpdate(sql2);
					Datahandle.getStatement().executeUpdate(sql3);
					oos.writeInt(hot+1);
					oos.flush();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void comsume() {//购票消费
		try {
			float free = ois.readFloat();
			String username = ois.readUTF();
			float money = ois.readFloat();
			try {
				System.out.println(username);
				String sql = "select money from user where Name='"+username+"'";
				ResultSet rs= Datahandle.getStatement().executeQuery(sql);
				if(rs.next()) {
				money = rs.getFloat("money");
				money = money-free;
				}
				String sql1 = "update user set money = '"+money+"'where Name='"+username+"'";
				 Datahandle.getStatement().executeUpdate(sql1);
				 oos.writeFloat(money);
				 oos.flush();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void MakeOpreationNote() throws IOException, SQLException, ClassNotFoundException{//购买记录
		String id = ois.readUTF();
		String name = ois.readUTF();
		Timestamp time = new Timestamp(System.currentTimeMillis());
		System.out.println(time);
		String operation = ois.readUTF();
		String sql = "insert into history values('"+id+"','"+name+"','"+time+"','"+operation+"')";
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("okay");
		oos.flush();
		s.close();
	}
	
	public void getCommcover() {
		try {
			String cid = ois.readUTF();
			String sql = "select cover from commodity where Cid='"+cid+"'";
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			rs.next();
			String path = rs.getString("cover");
			byte[] img = writeimg(path);
			oos.writeObject(img);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void getCommodity()throws IOException {//购买商品
		// TODO Auto-generated method stub
		String Cid = ois.readUTF();
		float Price = ois.readFloat();
		int num = ois.readInt();
		int hot = -1;
		String sql = "select hot from commodity where Cid='"+Cid+"'";		
		try {
			ResultSet rs = Datahandle.getStatement().executeQuery(sql);
			rs.next();
			hot = rs.getInt("hot");
			String sql1 =  "update commodity set hot='"+(hot+num)+"' where Cid='"+Cid+"'";
			Datahandle.getStatement().executeUpdate(sql1);
			oos.writeUTF("ok");
			oos.flush();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void comsume1() {//购物消费
		try {
			float price = ois.readFloat();
			String username = ois.readUTF();
			float money = ois.readFloat();
			int num = ois.readInt();
			try {
				System.out.println(username);
				String sql = "select money from user where Name='"+username+"'";
				ResultSet rs= Datahandle.getStatement().executeQuery(sql);
				if(rs.next()) {
				money = rs.getFloat("money");
				money = money-price*num;
				}
				String sql1 = "update user set money = '"+money+"'where Name='"+username+"'";
				 Datahandle.getStatement().executeUpdate(sql1);
				 oos.writeFloat(money);
				 oos.flush();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Usercomment() throws SQLException, ClassNotFoundException, IOException{//评论
		String fname = ois.readUTF();
		String sql="select * from comment where fname like '%"+ fname+"%'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List commentlist = new ArrayList();
		while(rs.next()){
			
			String uname = rs.getString(3);
			String comm = rs.getString(4);
			
			Object[] Ucomment = {uname,comm};
			commentlist.add(Ucomment);
		}
		
		oos.writeObject(commentlist);
		oos.flush();
	}
	
	private void Addcomment() {//添加评论
		try {
			String fname = ois.readUTF();
			String uname = ois.readUTF();
			String comm = ois.readUTF();
			String sql = "insert into comment(fname,uname,comm) values('"+fname+"','"+uname+"','"+comm+"')";
			Datahandle.getStatement().executeUpdate(sql);
			oos.writeUTF("ok");
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void myComment() throws SQLException, ClassNotFoundException, IOException{//我的评论
		String uname = ois.readUTF();
		String sql="select * from comment where uname like '%"+ uname+"%'";
		ResultSet rs = Datahandle.getStatement().executeQuery(sql);
		List mycommentlist = new ArrayList();
		while(rs.next()){
			String commid = rs.getString(1);
			String fname = rs.getString(2);
			String comm = rs.getString(4);
			
			Object[] MYcomment = {commid,fname,comm};
			mycommentlist.add(MYcomment);
		}
		
		oos.writeObject(mycommentlist);
		oos.flush();
	}
	
	public void updatecomment() throws IOException, ClassNotFoundException, SQLException {//修改评论
		String commid = ois.readUTF();
		String comm = ois.readUTF();
		String sql = "update comment set comm = '"+comm+"'where commid='"+commid+"'";
		Datahandle.getStatement().executeUpdate(sql);
		oos.writeUTF("ok");
		oos.flush();
	}
	
	 private byte[] writeimg(String path) {
			byte[] bytes = null;
			try {
				System.out.println(path);
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
