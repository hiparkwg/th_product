package com.myjob.product;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.myjob.product.mybatis.MyFactory;

@Component
public class CsyProductDao {
    SqlSession session;

    public ProductVo select(Integer sno){
        System.out.println("sno:" + sno);
        ProductVo  vo = null;
        session = new MyFactory().getSession();
        vo = session.selectOne("csyProduct.select", sno);

        session.close();
        return vo;
    }

    public boolean update(ProductVo vo){
        vo.setAmt(vo.getEa() * vo.getPrice());

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
