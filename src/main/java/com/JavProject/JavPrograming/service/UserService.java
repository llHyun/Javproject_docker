package com.JavProject.JavPrograming.service;

import com.JavProject.JavPrograming.model.User;
import com.JavProject.JavPrograming.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// UserService 수정
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원가입
    public User registerUser(User user) {
        return userRepository.save(user); // DB에 사용자 저장
    }

    //중복체크
    public boolean isUserStdNumExists(int stdNumber) {
        return userRepository.existsByStuNumber(stdNumber);
    }

    public int findByStuNumber(int stuNumber){
        return userRepository.findUserIdByStuNumber(stuNumber);
    }

    // 이름과 학번으로 사용자 찾기
    public Optional<User> findByNameAndStuNumber(String name, int stuNumber) {
        return userRepository.findByNameAndStuNumber(name, stuNumber);
    }
}

