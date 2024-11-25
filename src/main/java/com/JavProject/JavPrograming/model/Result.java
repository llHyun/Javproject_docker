package com.JavProject.JavPrograming.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Result")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer resultId;  // RESULT_ID와 연결

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)  // USER_ID 외래키 연결
    private User user;

    @Column(nullable = false)
    private LocalDate date = LocalDate.now();  // DATE와 연결

    @Lob
    @Column(name = "SKIN_IMG", columnDefinition = "LONGBLOB")
    private String skinImg;

    @Column(nullable = false)
    private Integer bigResult;  // BIG_RESULT와 연결

    @Column(length = 255)
    private String finalResult;  // FINAL_RESULT와 연결

    // Getters and Setters
    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSkinImg() {
        return skinImg;
    }

    public void setSkinImg(String skinImg) {
        this.skinImg = skinImg;
    }

    public Integer getBigResult() {
        return bigResult;
    }

    public void setBigResult(Integer bigResult) {
        this.bigResult = bigResult;
    }

    public String getFinalResult() {
        return finalResult;
    }

    public void setFinalResult(String finalResult) {
        this.finalResult = finalResult;
    }
}