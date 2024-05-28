package com.myjob.product;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.myjob.product.mybatis.MyFactory;

@Component
public class OjwMemberDao {
    SqlSession session;
    OjwMemberDao dao;
    
    public CodeVo view(String code){
    CodeVo vo = null;
    SqlSession session = new MyFactory().getSession();
    vo = session.selectOne("ojwProduct.view",code);

    session.close();
    return vo;
    }

    public String delete(String code){
        SqlSession session = new MyFactory().getSession();
        String msg = "";
        int cnt = session.delete("ojwProduct.delete_code", code);
        if(cnt>0){
            session.commit();
            msg="삭제 완료";
        }else{
            session.rollback();
            msg="삭제중 오류발생";
        }

        session.close();
        return msg;
    }
}
