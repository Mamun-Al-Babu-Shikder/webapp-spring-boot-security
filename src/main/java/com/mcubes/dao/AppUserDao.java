package com.mcubes.dao;

import com.mcubes.entity.AppUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by A.A.MAMUN on 12/15/2019.
 */
public interface AppUserDao extends CrudRepository<AppUser, Long> {

    AppUser findAppUserByEmail(String email);

}
