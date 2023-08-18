package com.senai.segundoProjetoWeb.service;

import com.senai.segundoProjetoWeb.model.UserModel;
import com.senai.segundoProjetoWeb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private UserRepository userRepository;
    public UserModel logar(UserModel userModel){
        return userRepository.login(userModel.getEmail(), userModel.getSenha());
    }
}
