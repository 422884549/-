package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

public class Film implements Serializable{
	private String Fid;//��Ӱ���
	private String Fname;//��Ӱ��
	private String director;//����
	private String cover;//����
	private int Hot;//�ȶ�
	private float price;//�۸�
	private String star;//����
	private String language;//����
	private String time;
	public void buff2img(String path){
		//���ֽ���תΪͼƬ,����ڱ���
		new Admin().writeimg(path);
	}

	public String getFid() {
		return Fid;
	}

	public void setFid(String fid) {
		Fid = fid;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getHot() {
		return Hot;
	}

	public void setHot(int hot) {
		Hot = hot;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	}

