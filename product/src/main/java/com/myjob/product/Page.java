package com.myjob.product;

import lombok.Data;

@Data
public class Page {
    int nowPage=1;
    int startNo;
    int endNo;
    int totSize; // 게시물의 전체 개수
    int listSize=4; // 한페이지에 표시될 정보의 개수
    String findStr;
    
    public void compute(){
        endNo = nowPage*listSize;
        startNo = endNo-listSize;

    }
}
