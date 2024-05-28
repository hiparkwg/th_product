package com.myjob.product;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.myjob.product.mybatis.MyFactory;

@Component
public class MsmProductDao2 {
    SqlSession session;
    public MsmProductDao2(){
        session = new MyFactory().getSession();
    }
    
    public List<CodeVo> code_search(String findStr){
        session = new MyFactory().getSession();
        List<CodeVo> list = session.selectList("code.search", findStr);
        session.close();
        return list;
    }

    public List<ProductVo> product_search(String findStr){
        session = new MyFactory().getSession();
        List<ProductVo> list = session.selectList("product.search", findStr);
        session.close();
        return list;
    }

}
