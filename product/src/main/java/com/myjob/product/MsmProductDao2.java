package com.myjob.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import com.myjob.product.mybatis.MyFactory;

@Component
public class MsmProductDao2 {
    SqlSession session;
    public MsmProductDao2(){
        session = new MyFactory().getSession();
    }
    
    public Map<String, Object> code_search(String findStr, int nowPage){
        Map<String, Object> map = new HashMap<>();

        session = new MyFactory().getSession();
        int totSize = session.selectOne("code.tot_size", findStr);

        Page page = new Page();
        page.setFindStr(findStr);
        page.setNowPage(nowPage);
        page.setTotSize(totSize);
        page.compute();
        
        List<CodeVo> list = session.selectList("code.search", page);
        session.close();
        map.put("list", list);
        map.put("page", page);

        return map;
    }

    public Map<String, Object> product_search(String findStr, int nowPage){
        Map<String, Object> map = new HashMap<>();

        session = new MyFactory().getSession();
        int totSize = session.selectOne("product.tot_size", findStr);
        Page page = new Page();
        page.setFindStr(findStr);
        page.setNowPage(nowPage);
        page.setTotSize(totSize);
        page.compute(); // nowpage를 사용하여 startNo, endNo 연산

        List<ProductVo> list = session.selectList("product.search", page);
        map.put("list", list);
        map.put("page", page);

        session.close();
        return map;
    }

}
