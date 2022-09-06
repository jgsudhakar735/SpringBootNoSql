package com.jgsudhakar.nosql.api.req;

import lombok.Data;

import java.io.Serializable;

/*************************************
 * This Class is used to
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.nosql.api.req.UserDto
 * Date    : 05 September 2022
 * Version : 1.0
 **************************************/
@Data
public class UserReqDto implements Serializable {

    private String id;

    private String userId;

    private String userName;

    private String userEmail;
}
