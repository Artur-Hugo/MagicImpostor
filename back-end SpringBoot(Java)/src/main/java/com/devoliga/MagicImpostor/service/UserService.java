package com.devoliga.MagicImpostor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devoliga.MagicImpostor.model.User;
import com.devoliga.MagicImpostor.repository.UserRepository;

@Service 
public class UserService {

	@Autowired
    private UserRepository ur;
	
	public User getUserByLogin(String login, String pwd)
    {
        User user = ur.getUserByLogin(login);
        
        if(user != null){
            if(!user.getSenha().equals(pwd)){
                user = null;
            }
        }
        //caso a senha e login existir vai retornar o nome e senha naa variavel user
        return user;

    }
	
}
