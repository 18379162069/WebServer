package com.springapp.mvc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * Created by louie on 2016/1/18.
 */
@Service
@Transactional
public class PicUpLoad {

    @Autowired
    private RootPath resoursePath;

    public String updatePicName(String OriginalFilename) {

        String[] tmpOld = OriginalFilename.split("\\.");
        String newPicName = UUID.randomUUID().toString();
        return newPicName + "." + tmpOld[1];
    }

    public void upLoad(MultipartFile file, String picname,String picStorePlace) {
        String rootPath = resoursePath.RootPath();
        try {
            SaveFileFromInputStream(file.getInputStream(), rootPath+picStorePlace, picname);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void SaveFileFromInputStream(InputStream stream, String path, String filename) throws IOException {
        FileOutputStream fs = new FileOutputStream(path + "/" + filename);
        byte[] buffer = new byte[1024];
        int byteread;
        while ((byteread = stream.read(buffer)) != -1) {
            fs.write(buffer, 0, byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
    }
}
