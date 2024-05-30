package com.myjob.product;

import java.util.List;
import java.util.Map;

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
    public ModelAndView codeList(String findStr, int nowPage){
 
        ModelAndView mv = new ModelAndView();
        Map<String, Object> map = dao.code_search(findStr, nowPage);
        List<CodeVo> list = (List<CodeVo>)map.get("list");
        Page page = (Page)map.get("page");

        mv.addObject("page", page);
        mv.addObject("list", list);
        System.out.println("findStr : " + findStr);
        mv.setViewName("code/msm_list2");
        return mv;
    }

    @RequestMapping(path="/product/msm_list")
    public ModelAndView productList(String findStr, int nowPage){
        ModelAndView mv = new ModelAndView();
        Map<String, Object> map = dao.product_search(findStr, nowPage);

        mv.addObject("list", map.get("list"));
        mv.addObject("page", map.get("page"));
        mv.setViewName("/product/msm_list2");
        return mv;
    }

   

}
