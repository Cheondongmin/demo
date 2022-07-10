# demo
파일 업로드 미니 프로젝트

마이바티스 및 H2 데이터베이스 사용


//////// DB 테이블

TB_FILE
-------------------------
FILE_SEQ  / int AI PK / 파일 일련번호
FILE_NAME / VARCHAR(100)  / 파일이름
FILE_SAVE_NAME / VARCHAR(100) / 파일 저장 이름
FILE_SAVE_PATH / VARCHAR(100) / 파일 저장 경로
FILE_EXT / VARCHAR(50)  / 파일 확장자
FILE_SIZE / INT / 파일사이즈
USE_YN / CHAR(1)  / 사용여부
REG_DT / DATETIME / 등록일자
