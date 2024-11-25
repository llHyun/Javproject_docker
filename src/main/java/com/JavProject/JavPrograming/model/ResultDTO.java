package com.JavProject.JavPrograming.model;

import java.time.LocalDate;

public class ResultDTO {
    private LocalDate date;
    private String skinImg;
    private Integer bigResult;
    private String finalResult;

    // 생성자
    public ResultDTO(LocalDate date, String skinImg, Integer bigResult, String finalResult) {
        this.date = date;
        this.skinImg = skinImg;
        this.bigResult = bigResult;
        this.finalResult = finalResult;
    }

    // Getter 메소드 추가
    public LocalDate getDate() {
        return date;
    }

    public String getSkinImg() {
        return skinImg;
    }

    public Integer getBigResult() {
        return bigResult;
    }


    public String getFinalResult() {
        return finalResult;
    }
}
