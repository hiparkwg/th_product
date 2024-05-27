package com.myjob.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class KrhMemberController {
    @Autowired //타입이 똑같은 놈과 연결해줭
    KrhMemberDao dao;

    @RequestMapping(path = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(path="/krh_view")
    public ModelAndView view(Integer sno){
       ModelAndView mv= new ModelAndView();
       ProductVo vo = dao.view(sno);
       mv.addObject("vo",vo);
       mv.setViewName("product/krhview");
        return mv;
    }

    @RequestMapping(path="/krh_delete")
    public ModelAndView delete(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("delete");
        return mv;
    }

    @RequestMapping(path="/krh_deleteR")
    public String deleteR(Integer sno){
        String msg=dao.delete(sno);
        return msg;
    }
}
