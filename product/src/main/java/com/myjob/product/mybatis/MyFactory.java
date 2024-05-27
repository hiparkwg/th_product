package com.myjob.product.mybatis;


import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyFactory {
    SqlSession session;

   public MyFactory(){
        try {
            Reader reader =Resources.getResourceAsReader("com/myjob/product/mybatis/lsjconfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            session = factory.openSession(); 
                
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
            
        
    }
    public SqlSession getSession(){
        return session;
    }
}
