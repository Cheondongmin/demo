package com.system.testProject.demo.dao;

import com.system.testProject.demo.vo.FileVO;

import java.util.List;

public interface FileDao {
    /**
     * 파일 업로드
     * @param fileVO
     * @return
     * @throws Exception
     */
    int insertFile(FileVO fileVO) throws Exception;

    /**
     * 파일 리스트 가져오기
     * @return
     * @throws Exception
     */
    List<FileVO> getFileList() throws Exception;
}
