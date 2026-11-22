package com.javaweb.controller;

import com.javaweb.enums.GenderReader;
import com.javaweb.enums.ReaderStatus;
import com.javaweb.model.ReaderDTO;
import com.javaweb.service.ReaderSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class Readercontroller {
    @Autowired
    private ReaderSevice readerSevice;
    @GetMapping(value = "/admin/book/reader")
    public ModelAndView reader(@ModelAttribute ReaderDTO readerDTO,@RequestParam Map<String, Object> parmas) {
        ModelAndView mav = new ModelAndView("admin/building/reader");
        mav.addObject("modelreader", readerDTO);
        mav.addObject("readersevice", readerSevice.findAll(parmas));
        mav.addObject("readerstatus", ReaderStatus.type());
        mav.addObject("readergender", GenderReader.fromValue());
        return mav;
    }
    @GetMapping(value = "/admin/book/reader-{id}")
    public ModelAndView reader(@PathVariable("id") Long Id) {
        ModelAndView mav = new ModelAndView("admin/building/reader");
        mav.addObject("modelreader",readerSevice.findReaderById(Id));
        mav.addObject("readerstatus", ReaderStatus.type());
        mav.addObject("readersevice",readerSevice.findAll(new HashMap<>()));
        mav.addObject("readergender", GenderReader.fromValue());
        return mav;
    }
}
