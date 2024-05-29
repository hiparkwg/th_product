package com.myjob.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CsyProductController {
    @Autowired
    CsyProductDao dao;

    @RequestMapping(path="/csyProductForm")
    public ModelAndView updateForm(Integer sno){
        ModelAndView mv = new ModelAndView();
        ProductVo vo = dao.select(sno);
        mv.addObject("vo", vo);
        mv.setViewName("product/csyUpdate");
        return mv;
    }
  
    @RequestMapping(path="/csyProductUpdate")
    public boolean update(ProductVo vo) {
        System.out.println(vo); 
        boolean isSuccess = false;
        isSuccess = dao.update(vo);
        return isSuccess;
    }
}
