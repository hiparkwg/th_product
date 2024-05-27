package com.myjob.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BjmProductController {

    @Autowired
    BjmProductDao bjm;
    
    @RequestMapping(path="/", method={RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }
    
    @RequestMapping(path="/bjmRegister")
    public ModelAndView bjmRegister(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("code/register");
        return mv;
    }
    @RequestMapping(path="/bjmRegisterR")
    public boolean bjmRegisterR(CodeVo vo){
        boolean b = false;
        b = bjm.bjmRegister(vo);
        // System.out.println("-------------");
        // System.out.println(vo.getCode());
        return b;
    }
}
