package it.contrader.model;

import java.util.*;

public class User {
	protected int id;

	protected String usertype;
	protected String nome;
	protected String cognome;
	protected String username;
	protected String password;
	protected Date birthdate;
	protected String telnumber;

	public User() {
	}

	public User (String username, String password, String usertype) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
	}
	
	public User (int id, String username, String password, String usertype) {
		this.username = username;
		this.password = password;
		this.usertype = usertype;
		this.id = id;
	}

	public int getUserId() {
		return id;
	}
	public void setUserId(int userId) {
		this.id = userId;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}



	@Override
	public String toString() {
		return  id + "\t"  + username +"\t\t" +   password + "\t\t" + usertype;
	}


	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthdate == null) {
			if (other.birthdate != null)
				return false;
		} else if (!birthdate.equals(other.birthdate))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (telnumber == null) {
			if (other.telnumber != null)
				return false;
		} else if (!telnumber.equals(other.telnumber))
			return false;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}




}
