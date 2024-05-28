package com.myjob.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LsjController {
    
    @Autowired
    LsjProductDao dao;


    @RequestMapping(path="/view")
    public ModelAndView view(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("code/view");
        System.out.println("실행");
        return mv;
    }
    @RequestMapping(path="/list")
    public ModelAndView list(String findStr){
        ModelAndView mv = new ModelAndView();
        List<CodeVo> list = new ArrayList<>();
        list = dao.select(findStr);
        mv.addObject("list", list);
        mv.setViewName("code/list");
        System.out.println("실행");
        return mv;
    }
    @RequestMapping(path="/register")
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("code/register");
        System.out.println("실행함");
        return mv;
    }
    @RequestMapping(path="/registerR")
    public String registerR(CodeVo vo){
        String msg = "";
        msg = dao.registerR(vo);
        return msg;


    }
    @RequestMapping(path="/update")
    public ModelAndView update(String code){
        ModelAndView mv = new ModelAndView();
        CodeVo vo = null;
        vo = dao.update(code);
        mv.addObject("vo", vo);
        mv.setViewName("code/update");
        return mv;
    }
    @RequestMapping(path="/updateR")
    public String updateR(CodeVo vo){
        System.out.println(vo);
        String msg = "";
        msg = dao.updateR(vo);
        return msg;
    }

    

}
