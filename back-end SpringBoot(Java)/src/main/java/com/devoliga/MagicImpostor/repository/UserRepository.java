package com.devoliga.MagicImpostor.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.devoliga.MagicImpostor.model.User;

@Repository
public class UserRepository {

	public HashMap<String, User> hm = new HashMap<String, User>();
	
	public UserRepository() 
	{
		///Colocando a senha e usuario na variavel hm
		hm.put("john",new User("john","John da Silva","123"));
	}
	
	public User getUserByLogin(String login)
    {
        return hm.get(login);
    }
}
