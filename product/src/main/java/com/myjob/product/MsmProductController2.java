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

    /*code ----------------------- */
    @RequestMapping(path="/code/msm_list")
    public ModelAndView codeList(String findStr){
        ModelAndView mv = new ModelAndView();
        List<CodeVo> list = dao.code_search(findStr);
        mv.addObject("list", list);
        System.out.println("findStr : " + findStr);
        mv.setViewName("code/msm_list2");
        return mv;
    }

    @RequestMapping(path="/product/msm_list")
    public ModelAndView productList(String findStr){
        ModelAndView mv = new ModelAndView();
        List<ProductVo> list = dao.product_search(findStr);
        mv.addObject("list", list);
        mv.setViewName("/product/msm_list2");
        return mv;
    }

    /*product ----------------------- */
    @RequestMapping(path="/product/msm_product_form")
    public ModelAndView productRegisterForm(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product/msm_list2");
        return mv;
    }

    @RequestMapping(path="/product/msm_list")
    public ModelAndView producRegisterR(String findStr){
        ModelAndView mv = new ModelAndView();
        List<ProductVo> list = dao.product_search(findStr);
        mv.addObject("list", list);
        mv.setViewName("/product/msm_list2");
        return mv;
    }



}
