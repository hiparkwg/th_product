package com.myjob.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OjwMemberController {
    @Autowired
    OjwMemberDao dao;

    @RequestMapping(path="/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(path="/ojw_view")
    public ModelAndView view(String code){
        ModelAndView mv = new ModelAndView();
        CodeVo vo = dao.view(code);
        mv.addObject("vo", vo);
        mv.setViewName("code/ojw_view");
        return mv;
    }

    @RequestMapping(path="/deleteR")
    public String delete(String code){
        String msg = dao.delete(code);
        return msg;
    }
}
