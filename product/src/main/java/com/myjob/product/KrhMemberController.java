package com.myjob.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class KrhMemberController {
    @Autowired
    KrhMemberDao dao;

    @RequestMapping(path="/krh_view")
    public ModelAndView view(Integer sno){
       ModelAndView mv= new ModelAndView();
       ProductVo vo = dao.view(sno);
       mv.addObject("vo",vo);
       mv.setViewName("product/krhview");
        return mv;
    }


    @RequestMapping(path="/krhDeleteR")
    public String deleteR(Integer sno){
        String msg=dao.delete(sno);
        return msg;
    }
}
