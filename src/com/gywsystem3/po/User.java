package com.gywsystem3.po;

public class User {
	private String userid;
	private String password;
	private String nickname;
	private String tele;
	private String wechat;
	private String parentUserId;
	
	public String getUserid(){
		return userid;
	}
	public String getPassword(){
		return password;
	}
	public String getNickname(){
		return nickname;
	}
	public String getTele(){
		return tele;
	}
	public String getWechat(){
		return wechat;
	}
	public String getParentUserId(){
		return parentUserId;
	}
	public void setUserid(String userid){
		this.userid=userid;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setNickname(String nickname){
		this.nickname=nickname;
	}
	public void setTele(String tele){
		this.tele=tele;
	}
	public void setWechat(String wechat){
		this.wechat=wechat;
	}
	public void setParentUserId(String parentUserId){
		this.parentUserId=parentUserId;
	}
	
}
