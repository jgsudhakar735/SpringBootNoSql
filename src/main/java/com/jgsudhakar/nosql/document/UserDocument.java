package com.jgsudhakar.nosql.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/*************************************
 * This Class is used to
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.nosql.document.UserDocument
 * Date    : 05 September 2022
 * Version : 1.0
 **************************************/
@Document("Users")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDocument implements Serializable {

    @Id
    private String id;

    private String userId;

    private String userName;

    private String userEmail;
}
