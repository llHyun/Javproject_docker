package com.JavProject.JavPrograming.repository;

import com.JavProject.JavPrograming.model.Result;
import com.JavProject.JavPrograming.model.ResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Integer> {


    @Query("SELECT new com.JavProject.JavPrograming.model.ResultDTO(r.date, r.skinImg, r.bigResult, r.finalResult) " +
            "FROM Result r WHERE r.user.userId = :userId")
    List<ResultDTO> findResultsByUserId(@Param("userId") int userId);




}

