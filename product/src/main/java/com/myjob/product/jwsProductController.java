package com.myjob.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class jwsProductController {

    @Autowired
    jwsDao jws;

    @RequestMapping(path = "/jwsregister")
    public ModelAndView product_Register() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product/jwsregister");
        return mv;
    }
    @RequestMapping(path="/jwsregisterR")
    public boolean jwsregisterR(ProductVo vo) {
        boolean b = false;
        b = jws.jwsregister(vo);
        return b;
    }
}
