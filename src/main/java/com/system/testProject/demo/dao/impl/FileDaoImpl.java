package com.system.testProject.demo.dao.impl;

import com.system.testProject.demo.dao.FileDao;
import com.system.testProject.demo.service.impl.FileServiceImpl;
import com.system.testProject.demo.vo.FileVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FileDaoImpl implements FileDao {

    private static final Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Autowired
    protected SqlSessionTemplate sqlSession;

    /**
     * 파일 업로드된 정보 로깅
     * @param fileVO
     * @return
     * @throws Exception
     */
    @Override
    public int insertFile(FileVO fileVO) throws Exception {
        return sqlSession.insert("insertFile",fileVO);
    }

    /**
     * 파일 리스트 가져오기
     * @return
     * @throws Exception
     */
    @Override
    public List<FileVO> getFileList() throws Exception {
        return sqlSession.selectList("getFileList");
    }
}
