package com.jgsudhakar.nosql.service.impl;

import com.jgsudhakar.nosql.api.req.UserReqDto;
import com.jgsudhakar.nosql.api.res.UserResDto;
import com.jgsudhakar.nosql.document.UserDocument;
import com.jgsudhakar.nosql.repository.UserRepository;
import com.jgsudhakar.nosql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*************************************
 * This Class is used to
 * Author  : Sudhakar Tangellapalli
 * File    : com.jgsudhakar.nosql.service.impl.UserServiceImpl
 * Date    : 05 September 2022
 * Version : 1.0
 **************************************/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResDto> findAll() {
        return Optional.ofNullable(userRepository.findAll()).
                orElse(Collections.emptyList()).
                stream().
                map(data -> new UserResDto(data.getId(), data.getUserId(), data.getUserName(), data
                        .getUserEmail())).
                collect(Collectors.toList());
    }

    @Override
    public UserResDto fetchUserByName(String userName) {
        UserDocument data = userRepository.findItemByUserName(userName);
        return new UserResDto(data.getId(), data.getUserId(), data.getUserName(), data
                .getUserEmail());
    }

    @Override
    public UserResDto fetchUserById(String userId) {
        UserDocument data = userRepository.findItemByUserId(userId);
        return new UserResDto(data.getId(), data.getUserId(), data.getUserName(), data
                .getUserEmail());
    }

    @Override
    public UserResDto save(UserReqDto reqDto) {
        UserDocument data = userRepository.save(new UserDocument(reqDto.getId(), reqDto.getUserId(), reqDto.getUserName(), reqDto.getUserEmail()));
        return new UserResDto(data.getId(), data.getUserId(), data.getUserName(), data
                .getUserEmail());
    }

    @Override
    public UserResDto update(UserReqDto reqDto) {
        UserDocument data = userRepository.save(new UserDocument(reqDto.getId(), reqDto.getUserId(), reqDto.getUserName(), reqDto.getUserEmail()));
        return new UserResDto(data.getId(), data.getUserId(), data.getUserName(), data
                .getUserEmail());
    }

    @Override
    public UserResDto delete(String userId) {
        UserDocument UserDocument = new UserDocument();
        UserDocument.setUserId(userId);
        Optional<com.jgsudhakar.nosql.document.UserDocument> one = userRepository.findOne(Example.of(UserDocument));
        one.ifPresent(userDocument -> userRepository.delete(userDocument));
        UserDocument data = one.get();
         return new UserResDto(data.getId(), data.getUserId(), data.getUserName(), data
                .getUserEmail());
    }
}
