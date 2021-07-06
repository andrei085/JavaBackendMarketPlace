package com.doctor.appointment.controller;

import com.doctor.appointment.dto.*;
import com.doctor.appointment.exception.CustomEntityNotFoundException;
import com.doctor.appointment.model.User;
import com.doctor.appointment.repository.UserRepository;
import com.doctor.appointment.security.UserPrinciple;
import com.doctor.appointment.service.UserService;
import com.doctor.appointment.service.MediaService;
import com.doctor.appointment.util.HttpStatusHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.doctor.appointment.util.HttpStatusHelper.success;

//controller => service => repository

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private MediaService mediaService;

    @Autowired
    HttpStatusHelper httpStatusHelper;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/getProfile")
    public UserInfoDto getProfile(OAuth2Authentication auth2Authentication) throws CustomEntityNotFoundException {
        UserPrinciple userPrinciple = (UserPrinciple) auth2Authentication.getPrincipal();

        String email = userPrinciple.getUsername();
        User user = userRepository.findByEmail(email).orElseThrow(() -> new CustomEntityNotFoundException(User.class));

        UserInfoDto infoDto = new UserInfoDto();
        infoDto.setEmail(user.getEmail());
        infoDto.setAge(user.getAge());
        infoDto.setName(user.getName());
        return infoDto;
    }

    @PreAuthorize("hasRole('ROLE_DEFAULT')")
    @GetMapping("/userAccess")
    public String getUserAccess() {
        return "user";
    }

//    ROLE_ADMIN > ROLE_DEFAULT

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/adminAccess")
    public String getAdminAccess() {
        return "admin";
    }

    @PostMapping("/addPicture")
    public ResponseEntity<Object> addPictureToEmployee(@RequestParam String fileName,
                                       @RequestParam Long userId,
                                       @RequestParam String type) {
        try {
            return success("ok", mediaService.addMediaToUser(fileName, userId, type));
        } catch (Exception e) {
            return httpStatusHelper.commonErrorMethod(e);
        }
    }


    @GetMapping("/publicEndpoint")
    public String getPublicEndpoint() {
        return "public";
    }


    @GetMapping("/getAll")
    public List<UserDto> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/register")
    public String addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);

    }

    @PostMapping("/get-users")
    public UserResponseDto getPaginatedUsers(@RequestBody PagingDto pagingDto) {
        int page = pagingDto.getPage();
        int size = pagingDto.getSize();

        int firstResults = page * size;
        int maxResults = firstResults + size;

        List<User> users = userRepository.getPaginatedUsers(firstResults, maxResults);
        long totalUsers = userRepository.getTotalUsers();

        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setUsers(users);
        responseDto.setFrom(firstResults);
        responseDto.setTo(maxResults);
        responseDto.setTotalUsers(totalUsers);

        return responseDto;
    }


    @GetMapping("/add")
    public String addMethod(@RequestParam String value) {

        return value;
    }

    @GetMapping("/user/{id}")
    public int sendUser(@PathVariable int id) {
        return id;
    }

    @PostMapping("/catalog")
    public String addToCatalog(@RequestBody UserDto userDto) {
        System.out.println(userDto.getName());
        System.out.println(userDto.getAge());

        return "Ok";
    }

}
