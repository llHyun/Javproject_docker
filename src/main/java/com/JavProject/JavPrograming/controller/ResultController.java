package com.JavProject.JavPrograming.controller;

import com.JavProject.JavPrograming.model.Result;
import com.JavProject.JavPrograming.model.ResultDTO;
import com.JavProject.JavPrograming.model.User;
import com.JavProject.JavPrograming.service.ResultService;
import com.JavProject.JavPrograming.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;
    @Autowired
    private UserService userService;

    @PostMapping
    public Result createResult(@RequestBody Map<String, Object> requestData) {
        // stuNumber를 받음
        int stuNumber = (int) requestData.get("stuNumber");
        int user_Id = userService.findByStuNumber(stuNumber);

        User user = new User();
        user.setUserId(user_Id);

        // Result 객체 생성
        Result result = new Result();
        result.setUser(user);
        result.setSkinImg((String) requestData.get("skinImg"));
        result.setBigResult((Integer) requestData.get("bigResult"));


        // Result 생성 후 반환
        return resultService.createResult(result);
    }


    @GetMapping("/user/{stdNum}")
    public List<ResultDTO> getResultsByUserId(@PathVariable("stdNum") int stdNum) {
        int user_Id = userService.findByStuNumber(stdNum);

        return resultService.getResultsByUserId(user_Id);
    }


}
