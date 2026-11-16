package com.javaweb.controller;

import com.javaweb.enums.LoanDetail;
import com.javaweb.enums.Loanstatus;
import com.javaweb.model.LoanDTO;
import com.javaweb.model.LoanDetailDTO;
import com.javaweb.service.Booksevice;
import com.javaweb.service.LoanDetailSevice;
import com.javaweb.service.LoanSevice;
import com.javaweb.service.ReaderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Borrowingcontroller {
    @Autowired
    private  LoanSevice loanSevice;
    @Autowired
    private ReaderSevice readerSevice;
    @Autowired
    private LoanDetailSevice loanDetailSevice;
    @Autowired
    private Booksevice booksevice;
    @GetMapping(value = "/admin/book/borrow")
    private ModelAndView addCommon(@ModelAttribute LoanDTO loan,@ModelAttribute LoanDetailDTO detail,
                          @RequestParam Map<String, Object> loanParams,@RequestParam Map<String, Object> detailParams) {
        ModelAndView mav = new ModelAndView("admin/building/borrowing");
        mav.addObject("modelloan", loan);
        mav.addObject("listmodelloan", loanSevice.findAll(loanParams));
        mav.addObject("modelloandetail", detail);
        mav.addObject("listmodelloandetail", loanDetailSevice.findAll(detailParams));
        mav.addObject("liststatus", Loanstatus.type());
        mav.addObject("listreader", readerSevice.getreader());
        mav.addObject("listloan", loanSevice.getloan());
        mav.addObject("listbook", booksevice.getbook());
        mav.addObject("listreturn", LoanDetail.type());
        return mav;
    }
    @GetMapping(value = "/admin/book/borrow-{id}")
    public ModelAndView updateborrow(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("admin/building/borrowing");

        mav.addObject("modelloan", loanSevice.findbyid(id));
        mav.addObject("modelloandetail", new LoanDetailDTO());

        mav.addObject("listmodelloan", loanSevice.findAll(new HashMap<>()));
        mav.addObject("listmodelloandetail", loanDetailSevice.findAll(new HashMap<>()));

        mav.addObject("liststatus", Loanstatus.type());
        mav.addObject("listreader", readerSevice.getreader());
        mav.addObject("listloan", loanSevice.getloan());
        mav.addObject("listbook", booksevice.getbook());
        mav.addObject("listreturn", LoanDetail.type());

        return mav;
    }
    @GetMapping(value = "/admin/loandetail/borrow-{id}")
    public ModelAndView borrowdetail(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("admin/building/borrowing");

        mav.addObject("modelloan", new LoanDTO());
        mav.addObject("modelloandetail", loanDetailSevice.findbyid(id));

        mav.addObject("listmodelloan", loanSevice.findAll(new HashMap<>()));
        mav.addObject("listmodelloandetail", loanDetailSevice.findAll(new HashMap<>()));

        mav.addObject("liststatus", Loanstatus.type());
        mav.addObject("listreader", readerSevice.getreader());
        mav.addObject("listloan", loanSevice.getloan());
        mav.addObject("listbook", booksevice.getbook());
        mav.addObject("listreturn", LoanDetail.type());

        return mav;
    }
}
