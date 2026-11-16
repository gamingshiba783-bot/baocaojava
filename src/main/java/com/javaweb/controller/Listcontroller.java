package com.javaweb.controller;

import com.javaweb.model.AuthorDTO;
import com.javaweb.model.CategoryDTO;
import com.javaweb.model.PublishDTO;
import com.javaweb.service.AuthorSevice;
import com.javaweb.service.CategorySevice;
import com.javaweb.service.Publishersevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
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
public class Listcontroller {

    @Autowired
    private AuthorSevice authorSevice;
    @Autowired
    private CategorySevice categorySevice;
    @Autowired
    private Publishersevice publishersevice;
    @GetMapping(value = "/admin/list/alllist")
    public ModelAndView list(
            @ModelAttribute AuthorDTO authorDTO,
            @ModelAttribute CategoryDTO categoryDTO,
            @ModelAttribute PublishDTO publishDTO,
            @RequestParam Map<String, Object> params) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelauthor", authorDTO);
        mav.addObject("listmodelauthor", authorSevice.findAll(params));
        mav.addObject("modelcategory", categoryDTO);
        mav.addObject("listmodelcategory", categorySevice.fillAll(params));
        mav.addObject("modelpublish", publishDTO);
        mav.addObject("listmodelpublish", publishersevice.findAll(params));
        return mav;
    }
    @GetMapping(value = "/admin/author/list-{id}")
    public ModelAndView editauthor(@PathVariable("id") Long Id) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelauthor", authorSevice.findById(Id));
        mav.addObject("modelcategory",new CategoryDTO());
        mav.addObject("modelpublish",new PublishDTO());
        mav.addObject("listmodelauthor", authorSevice.findAll(new HashMap<>()));
        mav.addObject("listmodelcategory", categorySevice.fillAll(new HashMap<>()));
        mav.addObject("listmodelpublish", publishersevice.findAll(new HashMap<>()));
        return mav;
    }
    @GetMapping(value = "/admin/category/list-{id}")
    public ModelAndView editcategory(@PathVariable("id") Long Id) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelauthor",new AuthorDTO());
        mav.addObject("modelcategory", categorySevice.CategoryByID(Id));
        mav.addObject("modelpublish",new PublishDTO());
        mav.addObject("listmodelauthor", authorSevice.findAll(new HashMap<>()));
        mav.addObject("listmodelcategory", categorySevice.fillAll(new HashMap<>()));
        mav.addObject("listmodelpublish", publishersevice.findAll(new HashMap<>()));
        return mav;
    }
    @GetMapping(value = "/admin/publisher/list-{id}")
    public ModelAndView editpublisher(@PathVariable("id") Long Id) {
        ModelAndView mav = new ModelAndView("admin/building/list");
        mav.addObject("modelauthor",new AuthorDTO());
        mav.addObject("modelcategory",new CategoryDTO());
        mav.addObject("modelpublish", publishersevice.findbyid(Id));
        mav.addObject("listmodelauthor", authorSevice.findAll(new HashMap<>()));
        mav.addObject("listmodelcategory", categorySevice.fillAll(new HashMap<>()));
        mav.addObject("listmodelpublish", publishersevice.findAll(new HashMap<>()));
        return mav;
    }
}
