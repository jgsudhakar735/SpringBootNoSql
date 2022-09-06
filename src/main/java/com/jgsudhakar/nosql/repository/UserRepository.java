package com.jgsudhakar.nosql.repository;

import com.jgsudhakar.nosql.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*************************************
 * This Class is used to
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.nosql.repository.UserRepository
 * Date    : 05 September 2022
 * Version : 1.0
 **************************************/
@Repository
public interface UserRepository extends MongoRepository<UserDocument,Long> {


    @Query("{userName: '?0'}")
    UserDocument findItemByUserName(String name);

    @Query("{userId: '?0'}")
    UserDocument findItemByUserId(String userId);

    @Override
    List<UserDocument> findAll();

    @Override
    long count();
}
