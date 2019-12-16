package com.mcubes.service;

import com.mcubes.dao.AppUserDao;
import com.mcubes.entity.AppUser;
import com.mcubes.model.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by A.A.MAMUN on 12/15/2019.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private AppUserDao appUserDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AppUser appUser = appUserDao.findAppUserByEmail(s);
        if(appUser==null)
            throw new UsernameNotFoundException("App User Not Found!");
        return new MyUserDetails(appUser);
    }
}
