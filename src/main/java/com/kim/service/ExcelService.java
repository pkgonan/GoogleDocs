package com.kim.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExcelService {

    @Autowired
    private ResourceLoader resourceLoader;
    private String pattern = "classpath:static/excel/*.csv";

    public List getFileList() throws IOException {
        Resource[] resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources(pattern);

        return Arrays.stream(resources).map((f)-> f.getFilename()).collect(Collectors.toList());
    }
}