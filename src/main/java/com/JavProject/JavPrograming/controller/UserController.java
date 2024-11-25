package com.JavProject.JavPrograming.controller;

import com.JavProject.JavPrograming.model.User;
import com.JavProject.JavPrograming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    // 회원가입
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        boolean isDuplicate = userService.isUserStdNumExists(user.getStuNumber());
        if (isDuplicate) {
            return ResponseEntity.badRequest().body("중복된 사용자입니다.");
        }

        userService.registerUser(user);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        Optional<User> existingUser = userService.findByNameAndStuNumber(user.getName(), user.getStuNumber());
        if (existingUser.isPresent()) {
            return ResponseEntity.ok("로그인 성공");
        } else {
            return ResponseEntity.status(404).body("사용자를 찾을 수 없습니다.");
        }
    }

}
