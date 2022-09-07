package com.jgsudhakar.nosql.service;

import com.jgsudhakar.nosql.api.req.UserReqDto;
import com.jgsudhakar.nosql.api.res.UserResDto;

import java.util.List;

/*************************************
 * This Class is used to
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.nosql.service.impl.UserService
 * Date    : 05 September 2022
 * Version : 1.0
 **************************************/
public  interface UserService {
    public List<UserResDto> findAll();

    public UserResDto fetchUserByName(String userName);

    public UserResDto fetchUserById(String userId);

    public UserResDto save(UserReqDto reqDto);

    public UserResDto update(UserReqDto reqDto);

    public UserResDto delete(String userId);
}
