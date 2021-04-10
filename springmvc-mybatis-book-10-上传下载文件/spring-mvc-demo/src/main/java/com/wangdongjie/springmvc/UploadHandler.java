package com.wangdongjie.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadHandler {

    @RequestMapping("/upload")
    public String upload(){
        System.out.println("执行了upload");
        return "upload";
    }

    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST)
    @ResponseBody
    public String uploadfile(HttpServletRequest request, @RequestParam("information") String information, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("执行了uploadfile");
        System.out.println("information:"+information);
        if (!file.isEmpty()) {
            String path = request.getServletContext().getRealPath("file");
            String fileName = file.getOriginalFilename();
            File uploadFile = new File(path, fileName);
            if (!uploadFile.getParentFile().exists()) {
                uploadFile.getParentFile().mkdirs();
            }
            file.transferTo(new File(path + File.separator + fileName));
            System.out.println("file:"+path + File.separator + fileName);
            System.out.println("upload success");
            return "upload";
        }
        else {
            System.out.println("upload failed");
            return "upload";
        }
    }
}
