package com.kim.web;

import com.kim.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ExcelService excelService;

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/list")
    List list() throws IOException {
        return excelService.getFileList();
    }
}