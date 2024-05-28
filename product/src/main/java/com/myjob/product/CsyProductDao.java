package com.myjob.product;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.myjob.product.mybatis.MyFactory;

@Component
public class CsyProductDao {
    SqlSession session;

    public boolean update(ProductVo vo){
        boolean isDaoSuccess = false;
        session = new MyFactory().getSession();
        int cnt = session.update("csyProduct.update", vo);
        if(cnt>0){
            isDaoSuccess = true;
            session.commit();
        }else{
            session.rollback();
        }
        session.close();
        return isDaoSuccess;
    }
}
