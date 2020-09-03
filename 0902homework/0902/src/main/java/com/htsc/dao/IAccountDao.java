package com.htsc.dao;
import com.htsc.domain.AccountUser;
import com.htsc.domain.QueryVo;
import com.htsc.domain.QueryVoIds;
import com.htsc.domain.User;

import java.util.List;

public interface IAccountDao {

    List<AccountUser> findAll();

}

