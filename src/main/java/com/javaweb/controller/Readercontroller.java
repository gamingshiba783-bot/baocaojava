package com.javaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Readercontroller {
    @GetMapping(value = "/admin/book/reader")
    public ModelAndView reader() {
        ModelAndView mav = new ModelAndView("admin/building/reader");
        return mav;
    }
}
