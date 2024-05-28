package com.myjob.product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MsmProductController2 {
    @Autowired
    MsmProductDao2 dao;

    @RequestMapping(path="/code/msm_list")
        public ModelAndView codeList(String findStr){
            ModelAndView mv = new ModelAndView();
            List<CodeVo> list = dao.code_search(findStr);
            mv.addObject("list", list);
            mv.setViewName("code/msm_list");
            return mv;
        }

    @RequestMapping(path="/product/msm_list")
        public ModelAndView productList(String findStr){
            ModelAndView mv = new ModelAndView();
            List<ProductVo> list = dao.product_search(findStr);
            mv.addObject("list", list);
            mv.setViewName("/product/msm_list");
            return mv;
        }
}
