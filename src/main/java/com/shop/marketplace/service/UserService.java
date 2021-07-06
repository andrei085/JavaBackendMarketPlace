package com.shop.marketplace.service;

import com.shop.marketplace.dto.UserDto;
import com.shop.marketplace.model.User;
import com.shop.marketplace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {

        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = new UserDto(user);
            userDtoList.add(userDto);
        }

        return userDtoList;
    }

    public String addUser(UserDto userDto) {
        User user = new User(userDto);
        userRepository.save(user);
        return "Ok";
    }
}
