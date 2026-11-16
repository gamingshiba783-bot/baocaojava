package com.javaweb.controller;

import com.javaweb.model.BookDTO;
import com.javaweb.model.CategoryDTO;
import com.javaweb.repository.BookRepository;
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
public class Homecontroller {
    @GetMapping(value = "/admin/book")
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("web/home");
        return mav;
    }
}
