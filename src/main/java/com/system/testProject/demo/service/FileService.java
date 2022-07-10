package com.system.testProject.demo.service;

import com.system.testProject.demo.vo.FileVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileService {

    /**
     * 파일 삽입 및 로깅
     * @param insertFile
     * @return
     * @throws Exception
     */
    int insertFile(MultipartFile[] insertFile) throws Exception;

    /**
     * 파일 목록 불러오기
     * @return
     * @throws Exception
     */
    List<FileVO> getFileList() throws Exception;
}
