package com.myjob.product;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BjmProductController {

    @Autowired
    BjmProductDao dao;
    
    @RequestMapping(path="/bjmRegister")
    public ModelAndView bjmRegister(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("code/register");
        return mv;
    }
    @RequestMapping(path="/bjmRegisterR")
    public boolean bjmRegisterR(CodeVo vo){
        boolean b = false;
        b = dao.bjmRegister(vo);
        return b;
    }
}
