package com.mcubes.controller;

import com.mcubes.dao.AppUserDao;
import com.mcubes.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by A.A.MAMUN on 12/15/2019.
 */
@Controller
public class AppController {

    @Autowired
    private AppUserDao appUserDao;

    @RequestMapping({"/","/home"})
    private String loadHomePage(){
        return "home";
    }

    @RequestMapping("/login")
    private String loadLoginPage() {
        return "login";
    }

    @RequestMapping("/registration")
    private String loadRegistrationPage(Model model, @ModelAttribute AppUser appUser){
        if(appUser.getEmail()!=null && appUser.getPassword()!=null){
            try{
                appUserDao.save(appUser);
                model.addAttribute("isRegistrationSuccess", true);
            }catch (Exception e){
                model.addAttribute("isRegistrationSuccess", false);
            }
        }
        return "registration";
    }

}
