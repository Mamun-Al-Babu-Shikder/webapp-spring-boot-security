package com.mcubes.controller;

import com.mcubes.dao.AppUserDao;
import com.mcubes.entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by A.A.MAMUN on 12/15/2019.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private AppUserDao appUserDao;

    @GetMapping("/profile")
    private String loadUserProfile(Principal principal, Model model){
        AppUser appUser = appUserDao.findAppUserByEmail(principal.getName());
        model.addAttribute("user_name", appUser.getName());
        return "user";
    }
}
