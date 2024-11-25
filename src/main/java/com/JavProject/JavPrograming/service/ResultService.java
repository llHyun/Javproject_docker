package com.JavProject.JavPrograming.service;


import com.JavProject.JavPrograming.model.Result;
import com.JavProject.JavPrograming.model.ResultDTO;
import com.JavProject.JavPrograming.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public Result createResult(Result result) {
        return resultRepository.save(result);
    }

    public List<ResultDTO> getResultsByUserId(int userId) {
        return resultRepository.findResultsByUserId(userId);
    }
}