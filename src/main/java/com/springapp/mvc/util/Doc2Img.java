package com.springapp.mvc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie on 2016/2/29.
 */
@Service
public class Doc2Img {

    @Autowired
    private RootPath root;
    @Autowired
    private RequestFactory Factory;

    public String[] convertDocument(String docPath) {
        List<String> imageUrls = new ArrayList<String>();
        String PIC_PATH = "C:\\Users\\louie\\Desktop\\Demo\\WEB_RES\\doc_pic";

        File docFile = new File(docPath);
        File directory = new File(PIC_PATH + "\\" + docFile.getName());
        if (!directory.exists()) {
            try {
                Process process = new ProcessBuilder(
                        "javaw",
                        "-jar",
                        "C:\\Users\\Administrator\\Desktop\\Web\\WebServer\\WebServer\\src\\main\\webapp\\WEB-INF\\doc2images.jar",
                        docPath,
                        PIC_PATH + "\\" + docFile.getName()).start();
                process.waitFor();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0, length = directory.list().length; i < length; i++)
//            imageUrls.add(String.format("/web/courseImg/%s/%s.jpg", docFile.getName(),i));
            imageUrls.add(String.format("/%s/%s.jpg", docFile.getName(), i));
        return imageUrls.toArray(new String[imageUrls.size()]);
    }
}
