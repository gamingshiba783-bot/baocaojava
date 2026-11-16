package com.javaweb.controller;

import com.javaweb.model.BookDTO;
import com.javaweb.service.Booksevice;
import com.javaweb.service.CategorySevice;
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
public class Bookcontroller {
    @Autowired
    private CategorySevice categorySevice;
    @Autowired
    private  Booksevice booksevice;
    @Autowired
    private PublisherSeviceImpl publisherSevice;
    @Autowired
    private AuthorSeviceImpl authorSevice;

    @GetMapping(value = "/admin/book/edit")
    public  ModelAndView buildingbook(@ModelAttribute BookDTO bookDTO, @RequestParam Map<String, Object> params){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("model",bookDTO);
        List<BookDTO> result = booksevice.findAll(params);
        mav.addObject("listmodel",result);
        mav.addObject("Listpublishers",publisherSevice.getpublishers());
        mav.addObject("listauthor",authorSevice.getauthors());
        mav.addObject("listcategory",categorySevice.getCategory());
        return  mav;
    }
    @GetMapping(value = "/admin/book/edit-{id}")
    public ModelAndView editbook(@PathVariable("id") Long Id){
        ModelAndView mav = new ModelAndView("admin/building/edit");
        mav.addObject("model", booksevice.findByid(Id));          // sách cần sửa
        mav.addObject("Listpublishers", publisherSevice.getpublishers());
        mav.addObject("listauthor", authorSevice.getauthors());
        mav.addObject("listcategory", categorySevice.getCategory());
        mav.addObject("listmodel", booksevice.findAll(new HashMap<>()));
        return mav;
    }
}
