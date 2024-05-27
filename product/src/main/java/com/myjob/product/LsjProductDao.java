package com.myjob.product;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.myjob.product.mybatis.MyFactory;
@Component
public class LsjProductDao {
    SqlSession session;

    public String registerR(CodeVo vo){
        String msg = "";
        session = new MyFactory().getSession();
        int cnt = session.insert("productcode.register", vo);
        if(cnt>0){
            msg="정상등록";
            session.commit();
        }else{
            msg="등록오류";
            session.rollback();
        }
        System.out.println(msg);
        session.close();
        return msg;

    }

    public List<CodeVo> select(String findStr){
        List<CodeVo> list = new ArrayList<>();
        session = new MyFactory().getSession();
        list = session.selectList("productcode.select", findStr);
        return list;
    }
    public CodeVo update(String code){
        CodeVo vo= null;
       
        session = new MyFactory().getSession();
        vo = session.selectOne("productcode.selectone", code);
        
        session.close();
        return vo;
    }
    public String updateR(CodeVo vo){
        session = new MyFactory().getSession();
        String msg = "";
        int cnt = session.update("productcode.update", vo);
        if(cnt>0){
            msg ="정상 수정";
            session.commit();
        }else{
            msg="수정 오류";
            session.rollback();
        }
        System.out.println(msg);
        session.close();
        return msg;
    }
}
