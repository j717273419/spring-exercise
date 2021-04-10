package com.wangdongjie.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class RedirectDemoHandler {
    //url
    //http://localhost:8080/redirect2
    @RequestMapping(value = "/redirect2",method = RequestMethod.GET)
    public String redirect2(){
        return "result";
    }

    @RequestMapping(value="/testredirect",method = { RequestMethod.POST, RequestMethod.GET })
    public ModelAndView testredirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/result.jsp");
        return null;
    }
}
