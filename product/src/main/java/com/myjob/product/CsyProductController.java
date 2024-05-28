package com.myjob.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@RestController
public class CsyProductController {
    @Autowired
    CsyProductDao dao;

  
    @RequestMapping(path="/csyProductUpdate")
    public boolean update(ProductVo vo) {
        System.out.println(vo); 
        boolean isSuccess = false;
        isSuccess = dao.update(vo);
        return isSuccess;
    }
}
