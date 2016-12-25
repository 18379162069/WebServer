package com.springapp.mvc.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by louie on 2016/2/18.
 */
public class ConvertDocument {

    public String[] convertDocument(String DOCUMENT_PATH,String rootPath, String parentId, String id, byte[] documentData) {
        List<String> imageUrls = new ArrayList<String>();
        File directory = new File(String.format("%s/%s/%s/%s", rootPath, DOCUMENT_PATH, parentId, id));
        if (!directory.exists()) {
            try {
                File docFile = new File(String.format("%s/%s/%s/%s.doc", rootPath, DOCUMENT_PATH, parentId, id));
                docFile.getParentFile().mkdirs();
                FileOutputStream fileOutputStream = new FileOutputStream(docFile);
                fileOutputStream.write(documentData);
                fileOutputStream.close();
                Process process = new ProcessBuilder(
                        "javaw",
                        "-jar",
                        rootPath + "WEB-INF\\doc2images.jar",
                        docFile.getAbsolutePath(),
                        String.format("%s/%s/%s/%s", rootPath, DOCUMENT_PATH, parentId, id)).start();
                process.waitFor();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0, length = directory.list().length; i < length; i++)
            imageUrls.add(String.format("/%s/%s/%s/%s.jpg", DOCUMENT_PATH, parentId, id, i));
        return imageUrls.toArray(new String[imageUrls.size()]);
    }

}
