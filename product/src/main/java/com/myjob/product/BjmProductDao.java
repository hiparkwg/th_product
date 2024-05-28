package com.myjob.product;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.myjob.product.mybatis.MyFactory;

@Component
public class BjmProductDao {

    SqlSession session;

    public boolean bjmRegister(CodeVo vo){
        session = new MyFactory().getSession();
        boolean b = false;
        int cnt = session.insert("bjm_product.register", vo);
        if(cnt > 0){
            b=true;
            session.commit();
        }else{
            session.rollback();
        }
        session.close();
        return b;
    }

}
