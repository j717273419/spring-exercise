package com.wangdongjie.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;

/*

spring mvc 文件上传的方式。


 */

@Controller
public class UploadHandler {

    @RequestMapping("/upload")
    public String upload(){
        System.out.println("执行了upload");
        return "upload";
    }

    //使用MultipartFile方式上传
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

    /*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     * 不推荐此方法，特别慢
     */
    @RequestMapping("upload1")
    public String  fileUpload(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
        try {
            String fileName = "E:\\"+new Date().getTime()+file.getOriginalFilename();
            File f = new File(fileName);
            if (!f.exists()){
                f.getParentFile().mkdir();
                f.createNewFile();
            }
            //获取输出流
            OutputStream os=new FileOutputStream(fileName);
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            //一个一个字节的读取并写入
            while((temp=is.read())!=(-1))
            {
                os.write(temp);
            }
            os.flush();
            os.close();
            is.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "upload";
    }

    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("upload2")
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file) throws IOException {
        long  startTime=System.currentTimeMillis();
        System.out.println("fileName："+file.getOriginalFilename());
        String path="E:\\"+new Date().getTime()+file.getOriginalFilename();
        System.out.println("path："+path);
        File newFile=new File(path);
        if (!newFile.exists()) {
            newFile.getParentFile().mkdirs();
        }
        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(newFile);
        long  endTime=System.currentTimeMillis();
        System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "upload";
    }
}
