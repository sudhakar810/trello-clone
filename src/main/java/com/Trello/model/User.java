package com.Trello.model;

import java.util.List;

public class User {
	
	private String userId;
	private String userName;
	private List<Card> cardList;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Card> getCardList() {
		return cardList;
	}
	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
	public User(String userId, String userName, List<Card> cardList) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.cardList = cardList;
	}
	

}
