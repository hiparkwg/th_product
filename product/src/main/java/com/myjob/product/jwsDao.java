package com.myjob.product;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.myjob.product.jwsmybatis.MyFactory;

@Component
public class jwsDao {
    SqlSession session;

    public boolean jwsregister(ProductVo vo) {
        session = new MyFactory().getSession();
        boolean b = false;
        int cnt = session.insert("jws_product.register", vo);
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
