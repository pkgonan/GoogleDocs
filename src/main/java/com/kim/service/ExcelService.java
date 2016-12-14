package com.kim.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Service
public class ExcelService {

    final static String path = "C:\\kim";

    public List getFileList() {
        File directory = new File(path);
        return Arrays.asList(directory.list());
    }
}