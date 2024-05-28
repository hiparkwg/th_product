package com.myjob.product;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.myjob.product.mybatis.MyFactory;

@Component
public class KrhMemberDao {
    SqlSession session;
    KrhMemberDao dao;
    
    public ProductVo view(Integer sno){
        ProductVo vo=null;
        SqlSession session = new MyFactory().getSession();
        vo = session.selectOne("krhproduct.view",sno);
        session.close();
        //System.out.println(sno);
        return vo;
    }

    public String delete(Integer sno){
        System.out.println("dao sno : " + sno);
        SqlSession session = new MyFactory().getSession();
        int cnt=session.delete("krhproduct.delete_product",sno);
        String msg="";
        if(cnt>0){
            msg="축하합니다! 성공적으로 삭제되었습니다!";
            session.commit();
        }else{
            msg="삐용삐용! 삭제에 실패하였습니다!";
            session.rollback();
        }
        System.out.println(msg);
        session.close();
        return msg;
    }
}
