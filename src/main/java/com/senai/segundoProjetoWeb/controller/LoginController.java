package com.senai.segundoProjetoWeb.controller;

import com.senai.segundoProjetoWeb.model.UserModel;
import com.senai.segundoProjetoWeb.service.CookieService;
import com.senai.segundoProjetoWeb.service.LoginService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping(value = "/login")
    public String formLogin(UserModel userModel, Model model){
        UserModel user = loginService.logar(userModel);
        if(user != null){
            return "redirect:/";
        } else {
            return "login/login";
        }
    }
    @PostMapping(value = "/logar")
    public String logar(UserModel userModel, Model model, HttpServletResponse response, String lembrar){
        UserModel user = loginService.logar(userModel);
        int tempoCookie;
        if(user != null){
            if(lembrar != null){
                tempoCookie = 60*60*24*360;
            } else{
                tempoCookie = 60*60;
            }
            CookieService.setCookie(response, "usuarioId", String.valueOf(user.getId()), tempoCookie);
            CookieService.setCookie(response,"nome", user.getNome(), tempoCookie);
            return "redirect:/";
        }else {
            model.addAttribute("erro", "Usuario e/ou senha inválidos!");
            return "login/login";
        }
    }
    @GetMapping(value = "/sair")
    public String logout(HttpServletResponse response){
        CookieService.setCookie(response, "usuarioId", "", 0);
        return "redirect:/login";

    }
}
