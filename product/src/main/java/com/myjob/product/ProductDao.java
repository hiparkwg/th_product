package com.myjob.product;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.myjob.product.mybatis.MyFactory;

@Component
public class ProductDao {
    SqlSession session;
    public ProductDao(){
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
