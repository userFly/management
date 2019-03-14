package com.jesper.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class FilterUtil {
    public static final String ROOT = "src/main/resources/static/img/item/";

    /**
     * 实现文件上传
     */
    public String fileUpload(MultipartFile file) {
        if (!file.isEmpty()) {
            int rannum = (int) (new Random().nextDouble() * (999 - 100 + 1)) + 10;
            String fileName = rannum + "_" + file.getOriginalFilename();
            String path = ROOT;
            File dest = new File(new File(path).getAbsolutePath() + "/" + fileName);
            if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
                dest.getParentFile().mkdir();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return fileName;
        }
        return "";
    }

   /* public ResponseEntity<byte[]> filedownload(HttpServletRequest request, String filename) throws Exception {
        String path = request.getServletContext().getRealPath("/upload");
        File file = new File(path + File.separator + filename);
        filename = this.getFilename(request, filename);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

    public String getFilename(HttpServletRequest request, String filename) throws Exception {
        String[] IEBrowserKeyWord = {"MSIE", "Trident", "Edge"};
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWord) {
            if (userAgent.contains(keyWord)) {
                return URLEncoder.encode(filename, "UTF-8");
            }
        }
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }*/

}
