package com.devoliga.MagicImpostor.model;

public class User {

	private String login;
	private String name;
	private String senha;
	
	public User(String login, String name, String senha) {
		
		this.login = login;
		this.name = name;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	
	
}
