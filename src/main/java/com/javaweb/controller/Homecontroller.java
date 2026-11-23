package com.javaweb.controller;

import com.javaweb.model.BookDTO;
import com.javaweb.model.CategoryDTO;
import com.javaweb.repository.BookRepository;
import com.javaweb.service.*;
import com.javaweb.service.impl.AuthorSeviceImpl;
import com.javaweb.service.impl.PublisherSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Homecontroller {
    @Autowired
    private LoanSevice loanSevice;
    @Autowired
    private Booksevice booksevice;
    @Autowired
    private ReaderSevice readerSevice;
    @GetMapping(value = "/admin/book")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("web/home");
        mav.addObject("toploan",loanSevice.findbyids());
        mav.addObject("coutbooks",booksevice.countBooks());
        mav.addObject("coutreader",readerSevice.coutreader());
        mav.addObject("coutloan",loanSevice.coutloan());
        mav.addObject("coutstatus",loanSevice.coutstatusloan());
        mav.addObject("coutstatusbrow",loanSevice.coutstatusbrow());
        return mav;
    }
}
