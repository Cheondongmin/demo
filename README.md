# demo
파일 업로드 미니 프로젝트<br>
<br>
파일 업로드 후 파일에 대한 정보를 db에 로깅한 후 <br>
다운로드 하고싶은 파일을 불러올때 해당 db를 이용해 목록을 그려낸다.


RDBMS
------------------------
H2 데이터베이스 사용


DB 테이블
-------------------------
FILE_SEQ  / int AI PK / 파일 일련번호<BR>
FILE_NAME / VARCHAR(100)  / 파일이름<BR>
FILE_SAVE_NAME / VARCHAR(100) / 파일 저장 이름<BR>
FILE_SAVE_PATH / VARCHAR(100) / 파일 저장 경로<BR>
FILE_EXT / VARCHAR(50)  / 파일 확장자<BR>
FILE_SIZE / INT / 파일사이즈<BR>
USE_YN / CHAR(1)  / 사용여부<BR>
REG_DT / DATETIME / 등록일자<BR>
