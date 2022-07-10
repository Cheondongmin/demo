package com.system.testProject.demo.service.impl;

import com.system.testProject.demo.dao.FileDao;
import com.system.testProject.demo.service.FileService;
import com.system.testProject.demo.utils.CommonValue;
import com.system.testProject.demo.vo.FileVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service("FileService")
public class FileServiceImpl implements FileService {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    private FileDao fileDao;

    /**
     * 파일 저장 후 로깅
     * @param insertFile
     * @return
     * @throws Exception
     */
    @Override
    public int insertFile(MultipartFile[] insertFile) throws Exception {
        int result = 0;
        for(MultipartFile file : insertFile) {
            if(!file.isEmpty()) {
                FileVO fileVO = new FileVO();
                String fileOriName = file.getOriginalFilename();

                fileVO.setFileName(fileOriName);
                fileVO.setFileSize(Long.toString(file.getSize()));
                fileVO.setFileExt(fileOriName.substring(fileOriName.lastIndexOf(".") + 1));
                fileVO.setFileSaveName(UUID.randomUUID().toString() + "_" + fileOriName);
                fileVO.setFileSavePath(CommonValue.FILE_SAVE_PATH);

                //파일 저장
                saveFile(file,fileVO);

                try {
                    //저장된 파일 정보 db에 로깅
                    result += fileDao.insertFile(fileVO);
                } catch (Exception e) {
                    logger.error("insertFile error",e);
                }
            }
        }

        return result;
    }

    @Override
    public List<FileVO> getFileList() throws Exception {
        return fileDao.getFileList();
    }


    /**
     * 파일 저장 메소드
     * @param file
     * @param fileVO
     */
    private void saveFile(MultipartFile file, FileVO fileVO) {
        File newFileName = new File(fileVO.getFileSaveName());

        //전달된 내용을 실제 물리적인 파일로 저장해준다.
        try {
            file.transferTo(newFileName);
        } catch (Exception e) {
            logger.error("saveFile error",e);
        }
    }
}
