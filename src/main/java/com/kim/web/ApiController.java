package com.kim.web;

import com.kim.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    private ExcelService excelService;

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("home");
    }

    @RequestMapping("/list")
    List list() {
        return excelService.getFileList();
    }

    @RequestMapping("/hello")
    ModelAndView hello() {
        return new ModelAndView("hello");
    }
}