package com.system.testProject.demo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(callSuper = false)
public class FileVO {
    private String fileSeq;         //파일 일련번호
    private String uuid;            //unique한 파일 이름을 만들기 위한 속성
    private String fileName;        //실제 파일 이름
    private String fileSaveName;    //저장된 파일 이름
    private String fileSavePath;    //저장된 파일 경로
    private String fileExt;         //파일 확장자
    private String fileSize;        //파일 사이즈
    private String useYn;           //사용 여부
    private String regDt;           //등록 날짜
    private String contentType;
}
