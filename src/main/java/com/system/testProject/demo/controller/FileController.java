package com.system.testProject.demo.controller;

import com.system.testProject.demo.service.FileService;
import com.system.testProject.demo.utils.CommonValue;
import com.system.testProject.demo.vo.FileVO;
import com.zaxxer.hikari.util.FastList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
public class FileController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @javax.annotation.Resource(name = "FileService")
    private FileService fileService;

    /**
     * 파일 목록 페이지 이동
     * @param model
     * @return
     */
    @GetMapping("/result.do")
    public String mainPage(Model model){
        return "result";
    }

    /**
     * 파일 업로드 및 로깅
     * @param uploadFile
     * @return
     */
    @RequestMapping(value="/upload.do", produces="application/json;charset=UTF-8", method=RequestMethod.POST)
    public @ResponseBody HashMap<String,Object> upload(@RequestParam MultipartFile[] uploadFile) {
        int result = 0;
        HashMap<String, Object> map = new HashMap<>();

        logger.debug("Insert File START >>");

        try {
            //파일 저장 후 DB에 로깅
            result = fileService.insertFile(uploadFile);
        } catch (Exception e) {
            logger.error("upload error", e);
        }

        logger.debug("Success Upload File Count :" + result);
        logger.debug("Insert File END >>");

        //파일 저장된게 없을경우 홈으로 back
        if (result > 0) {
            map.put("result",true);
        } else {
            map.put("result",false);
        }
        return map;
    }

    /**
     * 파일 목록 불러오기
     * @return
     */
    @GetMapping("/getFileList.do")
    @ResponseBody
    public List<FileVO> getFileList() {
        List<FileVO> fileList = new ArrayList<>();
        try {
            //파일 목록 가져오기
            fileList = fileService.getFileList();
        } catch (Exception e) {
            logger.error("result error" + e);
        }

        return fileList;
    }

    /**
     * 파일 다운로드
     * @param fileVO
     * @return
     */
    @GetMapping("/download.do")
    public ResponseEntity<Resource> download(@ModelAttribute FileVO fileVO) {
        Path path = Paths.get(CommonValue.FILE_SAVE_PATH + "/" + fileVO.getFileSaveName());
        Resource resource = null;
        HttpHeaders headers = new HttpHeaders();

        try {
            String contentType = Files.probeContentType(path);

            // header를 통해서 다운로드 되는 파일의 정보를 설정한다.
            headers.setContentDisposition(ContentDisposition.builder("attachement").filename(fileVO.getFileName(), StandardCharsets.UTF_8).build());
            headers.add(HttpHeaders.CONTENT_TYPE, contentType);

            resource = new InputStreamResource(Files.newInputStream(path));
        } catch (Exception e) {
            logger.error("download error" + e);
        }

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
