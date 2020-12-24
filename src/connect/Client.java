package connect;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import model.Admin;

public class Client implements mypr{
	ObjectOutputStream oos;
	ObjectInputStream ois;
	public Client() throws UnknownHostException, IOException{
		Socket s = new Socket("localhost",12345);
		oos = new ObjectOutputStream(s.getOutputStream());
	    ois = new ObjectInputStream(s.getInputStream());
	}
	public Admin Alogin(String ID,String pw) throws IOException, ClassNotFoundException{//����Ա��¼
		oos.writeInt(ALOGIN);
		oos.flush();
		oos.writeUTF(ID);
		oos.flush();
		oos.writeUTF(pw);
		oos.flush();
		return (Admin)ois.readObject();
	}
	
	public String Ulogin(String ID,String pw) throws IOException, ClassNotFoundException{//�û���¼
		oos.writeInt(ULOGIN);
		oos.flush();
		oos.writeUTF(ID);
		oos.flush();
		oos.writeUTF(pw);
		oos.flush();
		return ois.readUTF();	
	}
	
	public String Uregister(String uid,String upw,String uname) throws IOException, ClassNotFoundException{//�û�ע��
		oos.writeInt(UREGISTER);
		oos.flush();
		oos.writeUTF(uid);
		oos.flush();
		oos.writeUTF(upw);
		oos.flush();
		oos.writeUTF(uname);
		oos.flush();
		return ois.readUTF();
	}
	
	public List showFilm(){//չʾ���е�Ӱ
		try {
			oos.writeInt(SHOWFILM);
			oos.flush();
			return (List)ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void AddFilm(String Fid,String Fname,String director,
			String star,String path,float price,String language,String time) throws IOException{//���ӵ�Ӱ
		oos.writeInt(ADDFILM);
		oos.flush();
		oos.writeUTF(Fid);
		oos.flush();
		oos.writeUTF(Fname);
		oos.flush();
		oos.writeUTF(director);
		oos.flush();
		oos.writeUTF(star);
		oos.flush();
		byte[] b = writeimg(path);
		oos.writeObject(b);
		oos.flush();
		oos.writeFloat(price);
		oos.flush();
		oos.writeUTF(language);
		oos.flush();
		oos.writeUTF(time);
		oos.flush();
		String i ;
		i = ois.readUTF();
		if(i!="ok"){
			JOptionPane.showMessageDialog(null, "��ӳɹ�");
		}
		else{
			JOptionPane.showMessageDialog(null, "���ʧ��");
		}
	}
	
	public void updateFilm(String Fname,String director,String star,String path,float price,String time,String language) throws IOException{//�޸ĵ�Ӱ
		oos.writeInt(UPDFILM);
		oos.flush();
		oos.writeUTF(Fname);
		oos.flush();
		oos.writeUTF(director);
		oos.flush();
		oos.writeUTF(star);
		oos.flush();
		byte[] b = writeimg(path);
		oos.writeObject(b);
		oos.flush();
		oos.writeFloat(price);
		oos.flush();
		oos.writeUTF(time);
		oos.flush();
		oos.writeUTF(language);
		oos.flush();
		String i ;
		i = ois.readUTF();
		if(i!="ok"){
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
		}
		else{
			JOptionPane.showMessageDialog(null, "�޸�ʧ��");
		}
	}
	
	public void updateFilm2(String Fname,String director,String star,float price,String time,String language) throws IOException{//�޸ĵ�Ӱ
		oos.writeInt(UPDFILM);
		oos.flush();
		oos.writeUTF(Fname);
		oos.flush();
		oos.writeUTF(director);
		oos.flush();
		oos.writeUTF(star);
		oos.flush();
		oos.writeObject(null);
		oos.flush();
		oos.writeFloat(price);
		oos.flush();
		oos.writeUTF(time);
		oos.flush();
		oos.writeUTF(language);
		oos.flush();
		String i ;
		i = ois.readUTF();
		if(i!="ok"){
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
		}
		else{
			JOptionPane.showMessageDialog(null, "�޸�ʧ��");
		}
	}
	
	public void Deleteflim(String Fname) throws IOException {//ɾ����Ӱ
		 oos.writeInt(DELETEFLIM);
		 oos.flush();
		 oos.writeUTF(Fname);
		 oos.flush();
		 String i ;
		 i = ois.readUTF();
		 if(i!="ok") {
			 JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
		 }
	 }
	
	public List FilmSearch(String msg){//��Ӱ����
		 try {
			oos.writeInt(SEARCHFILM);
			oos.flush();
			oos.writeUTF(msg);
			oos.flush();
			 return (List)ois.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	public Object[][] showhall(){//չʾ���д���
		Object[][] hall = null;
		try {
			oos.writeInt(SHOWHALL);
			oos.flush();
			List halllist = (List) ois.readObject();
			hall = new Object[halllist.size()][5];
			for(int i = 0;i<halllist.size();i++){
				Object[] strs = (Object[]) halllist.get(i);
				hall[i][0] = strs[0];
				hall[i][1] = strs[1];
				hall[i][2] = strs[2];
				hall[i][3] = strs[3];
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hall;
	}	
	
	public Object[][] HallSearch(String msg){//��������
		Object[][] hall = null;
		try {
			oos.writeInt(SEARCHHall);
			oos.flush();
			oos.writeUTF(msg);
			oos.flush();
			List halllist = (List) ois.readObject();
			hall = new Object[halllist.size()][5];
			for(int i = 0;i<halllist.size();i++){
				Object[] strs = (Object[]) halllist.get(i);
				hall[i][0] = strs[0];
				hall[i][1] = strs[1];
				hall[i][2] = strs[2];
				hall[i][3] = strs[3];
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hall;
	}	
	
	public void Deletehall(String Hid,String Hname) throws IOException {//ɾ������
		 oos.writeInt(DELETEHALL);
		 oos.flush();
		 oos.writeUTF(Hid);
		 oos.flush();
		 oos.writeUTF(Hname);
		 oos.flush();
		 String i ;
		 i = ois.readUTF();
		 if(i!="ok") {
			 JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
		 }
		 else {
			 JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
		 }
	 }
	
	public void AddHall(String Hname,String X,String Y) throws IOException{//���Ӵ���
		oos.writeInt(ADDHALL);
		oos.flush();
		oos.writeUTF(Hname);
		oos.flush();
		oos.writeUTF(X);
		oos.flush();
		oos.writeUTF(Y);
		oos.flush();
		String i ;
		i = ois.readUTF();
		if(i!="ok"){
			JOptionPane.showMessageDialog(null, "��ӳɹ�");
		}
		else{
			JOptionPane.showMessageDialog(null, "���ʧ��");
		}
	}
	
	public void updateHall(String Hname,String X,String Y) throws IOException{//�޸Ĵ���
		oos.writeInt(UPDHALL);
		oos.flush();
		oos.writeUTF(Hname);
		oos.flush();
		oos.writeUTF(X);
		oos.flush();
		oos.writeUTF(Y);
		oos.flush();
		String i ;
		i = ois.readUTF();
		if(i!="ok"){
			JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
		}
		else{
			JOptionPane.showMessageDialog(null, "�޸�ʧ��");
		}
	}
	
	public Object[][] SessionsSearch(String msg) {//��������
		Object[][] sessions = null;
		try {
			oos.writeInt(SEARHSESSIONS);
			oos.flush();
			oos.writeUTF(msg);
			oos.flush();
			List sessionslist = (List) ois.readObject();
			sessions = new Object[sessionslist.size()][6];
			for(int i = 0;i<sessionslist.size();i++){
				Object[] strs = (Object[]) sessionslist.get(i);
				sessions[i][0] = strs[0];
				sessions[i][1] = strs[1];
				sessions[i][2] = strs[2];
				sessions[i][3] = strs[3];
				sessions[i][4] = strs[4];
				sessions[i][5] = strs[5];
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessions;
	}	
	
	 public Object[][] showsessions() {//��ʾ���г���
			Object[][] sessions = null;
			try {
				oos.writeInt(SHOWSESSIONS);
				oos.flush();
				List sessionslist = (List) ois.readObject();
				sessions = new Object[sessionslist.size()][6];
				for(int i = 0;i<sessionslist.size();i++){
					Object[] strs = (Object[]) sessionslist.get(i);
					sessions[i][0] = strs[0];
					sessions[i][1] = strs[1];
					sessions[i][2] = strs[2];
					sessions[i][3] = strs[3];
					sessions[i][4] = strs[4];
					sessions[i][5] = strs[5];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sessions;
		}	
	 
	 public void deletesessions(String pid) throws IOException{//ɾ��Ӱ��
			oos.writeInt(DELETESESSIONS);
			oos.flush();
			oos.writeUTF(pid);
			oos.flush();
			String i;
			i=ois.readUTF();
			if(i!="ok"){
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			}
			else{
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			}	
		}
	 
	 public List findHall() {
			
			try {
				oos.writeInt(FINDHALL);
				oos.flush();
				return (List) ois.readObject();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	 
	 public void Addsessions(Object[] Hname,String Fname,Date starttime,int playtime) throws IOException{//���ӳ���
			oos.writeInt(ADDSESSIONS);
			oos.flush();
			oos.writeObject(Hname);
			oos.flush();
			oos.writeUTF(Fname);
			oos.flush();
			oos.writeObject(starttime);
			oos.flush();
			oos.writeInt(playtime);
			oos.flush();
			String i ;
			i = ois.readUTF();
			if(i!="ok"){
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
			}
			else{
				JOptionPane.showMessageDialog(null, "���ʧ��");
			}
		}
	 
	 public String Amendsessions(String playid,Object[] Hname,String Fname,Date starttime,int playtime) throws IOException {//�޸ĳ���
			oos.writeInt(AMENDSESSIONS);
			oos.flush();
			oos.writeUTF(playid);
			oos.flush();
			oos.writeObject(Hname);
			oos.flush();
			oos.writeUTF(Fname);
			oos.flush();
			oos.writeObject(starttime);
			oos.flush();
			oos.writeInt(playtime);
			oos.flush();
			String i;
			i = ois.readUTF();
			return i;
		}
	 
	 public Object[][] CommoditySearch(String msg){//������Ʒ
			Object[][] Commodity = null;
			try {
				oos.writeInt(SEARCHCOMMODITY);
				oos.flush();
				oos.writeUTF(msg);
				oos.flush();
				List Comlist = (List) ois.readObject();
				Commodity = new Object[Comlist.size()][5];
				for(int i = 0;i<Comlist.size();i++){
					Object[] strs = (Object[]) Comlist.get(i);
					Commodity[i][0] = strs[0];
					Commodity[i][1] = strs[1];
					Commodity[i][2] = strs[2];
					Commodity[i][3] = strs[3];
					Commodity[i][4] = strs[4];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Commodity;
		}
	 
	 public Object[][] showCommodity(){//չʾ������Ʒ
			Object[][] Commodity = null;
			try {
				oos.writeInt(SHOWCOMMODITY);
				oos.flush();
				List Comlist = (List) ois.readObject();
				Commodity = new Object[Comlist.size()][5];
				for(int i = 0;i<Comlist.size();i++){
					Object[] strs = (Object[]) Comlist.get(i);
					Commodity[i][0] = strs[0];
					Commodity[i][1] = strs[1];
					Commodity[i][2] = strs[2];
					Commodity[i][3] = strs[3];
					Commodity[i][4] = strs[4];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Commodity;
		}	
	 
	 public String Addcommodity(String Cid,String Cname,float price,String content,String path) throws IOException{//�����Ʒ
			oos.writeInt(ADDCOMMODITY);
			oos.flush();
			oos.writeUTF(Cid);
			oos.flush();
			oos.writeUTF(Cname);
			oos.flush();
			oos.writeFloat(price);
			oos.writeUTF(content);
			oos.flush();
			oos.writeObject(writeimg(path));
			oos.flush();
			return ois.readUTF();
			
		}
	 
	 public void Amendcommodity(String Cname,float price,String content,String path ) throws IOException{//�޸���Ʒ
			oos.writeInt(AMENDCOMMODITY);
			oos.flush();
			oos.writeUTF(Cname);
			oos.flush();
			oos.writeFloat(price);
			oos.flush();
			oos.writeUTF(content);
			oos.flush();
			oos.writeObject(writeimg(path));
			oos.flush();
			String i;
			i=ois.readUTF();
			if(i!="ok") {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			}
			else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
		}
	 
	 public void Amendcommodity2(String Cname,float price,String content) throws IOException{//�޸���Ʒ
			oos.writeInt(AMENDCOMMODITY);
			oos.flush();
			oos.writeUTF(Cname);
			oos.flush();
			oos.writeFloat(price);
			oos.flush();
			oos.writeUTF(content);
			oos.flush();
			oos.writeObject(null);
			oos.flush();
			String i;
			i=ois.readUTF();
			if(i!="ok") {
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			}
			else {
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
		}
	 
	 public void Deletecommodity(String Cid) throws IOException{//ɾ����Ʒ
			oos.writeInt(DELETECOMMODITY);
			oos.flush();
			oos.writeUTF(Cid);
			oos.flush();
			String i= ois.readUTF();
			if(i=="ok"){
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
			}
			else{
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
			}
		}
	 
	 public Object[][] showhistory() {//��ʾ���й����¼
			Object[][] history = null;
			try {
				oos.writeInt(SHOWHISTORY);
				oos.flush();
				List historylist = (List) ois.readObject();
				history = new Object[historylist.size()][4];
				for(int i = 0;i<historylist.size();i++){
					Object[] strs = (Object[]) historylist.get(i);
					history[i][0] = strs[0];
					history[i][1] = strs[1];
					history[i][2] = strs[2];
					history[i][3] = strs[3];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return history;
	 }
	 
	 public Object[][] UserhistorySearch(String msg) {//���������¼
			Object[][] history = null;
			try {
				oos.writeInt(SEARCHUSERHISTORY);
				oos.flush();
				oos.writeUTF(msg);
				oos.flush();
				List historylist = (List) ois.readObject();
				history = new Object[historylist.size()][4];
				for(int i = 0;i<historylist.size();i++){
					Object[] strs = (Object[]) historylist.get(i);
					history[i][0] = strs[0];
					history[i][1] = strs[1];
					history[i][2] = strs[2];
					history[i][3] = strs[3];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return history;
	 }
	 
	 public Object[][] UserSearch(String msg){//�����û�
			Object[][] user = null;
			try {
				oos.writeInt(SEARCHUSER);
				oos.flush();
				oos.writeUTF(msg);
				oos.flush();
				List userlist = (List) ois.readObject();
				user = new Object[userlist.size()][3];
				for(int i = 0;i<userlist.size();i++){
					Object[] strs = (Object[]) userlist.get(i);
					user[i][0] = strs[0];
					user[i][1] = strs[1];
					user[i][2] = strs[2];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
	 
	 public Object[][] showUser(){//չʾ�����û�
			Object[][] user = null;
			try {
				oos.writeInt(SHOWUSER);
				oos.flush();
				List userlist = (List) ois.readObject();
				user = new Object[userlist.size()][3];
				for(int i = 0;i<userlist.size();i++){
					Object[] strs = (Object[]) userlist.get(i);
					user[i][0] = strs[0];
					user[i][1] = strs[1];
					user[i][2] = strs[2];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
	 
		public void downUser(String id){//ɾ���û�
			try {
				oos.writeInt(DOWNUSER);
				oos.flush();
				oos.writeUTF(id);
				oos.flush();
				String mind = ois.readUTF();
				if(mind.equals("OK")){
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				}else{
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Object[][] showComment(){//չʾ����
			Object[][] Comment = null;
			try {
				oos.writeInt(SHOWCOMMENT);
				oos.flush();
				List Commlist = (List) ois.readObject();
				Comment = new Object[Commlist.size()][4];
				for(int i = 0;i<Commlist.size();i++){
					Object[] strs = (Object[]) Commlist.get(i);
					Comment[i][0] = strs[0];
					Comment[i][1] = strs[1];
					Comment[i][2] = strs[2];
					Comment[i][3] = strs[3];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Comment;
		}
		
		public Object[][] commentSearch(String msg){//��������
			Object[][] comment = null;
			try {
				oos.writeInt(SEARCHCOMMENT);
				oos.flush();
				oos.writeUTF(msg);
				oos.flush();
				List Commlist = (List) ois.readObject();
				comment = new Object[Commlist.size()][4];
				for(int i = 0;i<Commlist.size();i++){
					Object[] strs = (Object[]) Commlist.get(i);
					comment[i][0] = strs[0];
					comment[i][1] = strs[1];
					comment[i][2] = strs[2];
					comment[i][3] = strs[3];
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return comment;
		}
		
	static void buff2Image(byte[] b,String tagSrc) throws Exception
    {
		if(b != null) {
        FileOutputStream fout = new FileOutputStream(tagSrc);
        //���ֽ�д���ļ�
        fout.write(b);
        fout.close();
		}else {
			JOptionPane.showMessageDialog(null, "û�з���");
		}
    }
	
	public void deletecomment(String Commid) throws IOException{//ɾ����Ʒ
		oos.writeInt(DELETECOMMENT);
		oos.flush();
		oos.writeUTF(Commid);
		oos.flush();
		String i= ois.readUTF();
		if(i=="ok"){
			JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
		}
		else{
			JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
		}
	}
	
	/////////////
    ////////////
		public float addMoney(String name,float addmoney) throws IOException{//��ֵ
			oos.writeInt(ADDMON);
			oos.flush();
			oos.writeUTF(name);
			oos.flush();
			oos.writeFloat(addmoney);
			oos.flush();
			return ois.readFloat();
			
		}
		
		public float getUser(String name)throws IOException{//�����û�
			oos.writeInt(GETUSER);
			oos.writeUTF(name);
			oos.flush();
			return ois.readFloat();
		}
		
		public String getFilmcover(String fname) {
			String path = "filmimg.jpg";
			try {
				oos.writeInt(GETFILMCOVER);
				oos.flush();
				oos.writeUTF(fname);
				oos.flush();
				byte[] img = (byte[]) ois.readObject();
				buff2Image(img, path);
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
			return path;
		}
		
		public List managerHall(){
			try {
				oos.writeInt(MANAGEHALL);
				oos.flush();
				return (List)ois.readObject();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public int[][] getSelectedSeat(String pid) {
			try {
				oos.writeInt(GETSELECTEDSEAT);
				oos.flush();
				oos.writeUTF(pid);
				oos.flush();
				return (int[][])ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		
		public int getTicket(String pid,String hid,String fname,int hot,int x,int y){//��Ʊ
			try {
				oos.writeInt(GETTICKET);
				oos.flush();
				oos.writeUTF(pid);
				oos.flush();
				oos.writeUTF(hid);
				oos.flush();
				oos.writeUTF(fname);
				oos.flush();
				oos.writeInt(hot);
				oos.flush();
				oos.writeInt(x);
				oos.flush();
				oos.writeInt(y);
				oos.flush();
				return ois.readInt();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return -1;
			
		}
		
		public float consume(float free,String username,float money) throws IOException {
			 oos.writeInt(COMSUME);
			 oos.flush();
			 oos.writeFloat(free);
			 oos.flush();
			 oos.writeUTF(username);
			 oos.flush();
			 oos.writeFloat(money);
			 oos.flush();
			 return ois.readFloat();
		 }
		
		public String MakeOperationNote(String ID, String name, 
				String operation) throws IOException {//�����¼
			// TODO Auto-generated method stub
			oos.writeInt(NOTE);
			oos.flush();
			oos.writeUTF(ID);
			oos.flush();
			oos.writeUTF(name);
			oos.flush();
			oos.writeUTF(operation);
			oos.flush();
			return ois.readUTF();
		}
	
		public String getCommcover(String cid) {
			String path = "commimg.jpg";
			try {
				oos.writeInt(GETCOMMCOVER);
				oos.flush();
				oos.writeUTF(cid);
				oos.flush();
				byte[] img = (byte[]) ois.readObject();
				buff2Image(img, path);
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
			return path;
		}
		
		public void getCommodity(String Cname,String Cid,float Price,int num) throws IOException{//������Ʒ
			oos.writeInt(GETCOMMODITY);
			oos.flush();
			oos.writeUTF(Cid);
			oos.flush();
			oos.writeFloat(Price);
			oos.flush();
			oos.writeInt(num);
			oos.flush();
			if(ois.readUTF().equals("ok")) {
				JOptionPane.showMessageDialog(null,"������Ʒ:"+Cname+"�ɹ�");
			}
		    
		}
		
		public float consume1(float price,String username,float money,int num) throws IOException {
			 oos.writeInt(COMSUME1);
			 oos.flush();
			 oos.writeFloat(price);
			 oos.flush();
			 oos.writeUTF(username);
			 oos.flush();
			 oos.writeFloat(money);
			 oos.flush();
			 oos.writeInt(num);
			 oos.flush();
			 return ois.readFloat();
		 }
		
		public Object[][] Usercomment(String fname) {//��ʾ����
			Object[][] comment = null;
			try {
				oos.writeInt(USERCOMMENT);
				oos.flush();
				oos.writeUTF(fname);
				oos.flush();
				List commentlist = (List) ois.readObject();
				comment = new Object[commentlist.size()][2];
				for(int i = 0;i<commentlist.size();i++){
					Object[] strs = (Object[]) commentlist.get(i);
					comment[i][0] = strs[0];
					comment[i][1] = strs[1];
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return comment;
	 }
	
		public void Addcomment(String Fname,String uname,String comm) throws IOException{//��������
			oos.writeInt(ADDCOMMENT);
			oos.flush();
			oos.writeUTF(Fname);
			oos.flush();
			oos.writeUTF(uname);
			oos.flush();
			oos.writeUTF(comm);
			oos.flush();
			String i ;
			i = ois.readUTF();
			if(i!="ok"){
				JOptionPane.showMessageDialog(null, "��ӳɹ�");
			}
			else{
				JOptionPane.showMessageDialog(null, "���ʧ��");
			}
		}
		
		public Object[][] myComment(String uname) {//�ҵ�����
			Object[][] mycomment = null;
			try {
				oos.writeInt(MYCOMMENT);
				oos.flush();
				oos.writeUTF(uname);
				oos.flush();
				List mycommentlist = (List) ois.readObject();
				mycomment = new Object[mycommentlist.size()][3];
				for(int i = 0;i<mycommentlist.size();i++){
					Object[] strs = (Object[]) mycommentlist.get(i);
					mycomment[i][0] = strs[0];
					mycomment[i][1] = strs[1];
					mycomment[i][2] = strs[2];
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return mycomment;
	 }
	
		public void updatecomment(String commid,String comm) throws IOException{//�޸�����
			oos.writeInt(UPDATECOMMENT);
			oos.flush();
			oos.writeUTF(commid);
			oos.flush();
			oos.writeUTF(comm);
			oos.flush();
			String i ;
			i = ois.readUTF();
			if(i!="ok"){
				JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
			}
			else{
				JOptionPane.showMessageDialog(null, "�޸�ʧ��");
			}
		}
		
	 private static byte[] writeimg(String path) {
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
