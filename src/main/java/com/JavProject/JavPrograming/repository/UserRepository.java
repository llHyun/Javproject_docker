package com.JavProject.JavPrograming.repository;

import com.JavProject.JavPrograming.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // 이름으로 사용자 존재 여부 확인
    boolean existsByStuNumber(int stuNumber);
    Optional<User> findByNameAndStuNumber(String name, int stuNumber);

    @Query("SELECT u.userId FROM User u WHERE u.stuNumber = :stuNumber")
    int findUserIdByStuNumber(@Param("stuNumber") int stuNumber);
}
