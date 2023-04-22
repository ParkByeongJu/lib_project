CREATE TABLE t_member (
  id       VARCHAR2(20) PRIMARY key,
  password VARCHAR2(20) NOT NULL,
  name     VARCHAR2(50) NOT NULL,
  birth    DATE         NOT NULL,
  email    VARCHAR2(50) NOT NULL,
  phone    VARCHAR2(20) NOT NULL
);

select * from t_member; 

CREATE TABLE T_BOOK(
      name      VARCHAR2(100)  PRIMARY KEY
     ,writer     VARCHAR2(50)   NOT NULL
     ,publisher VARCHAR2(100)  NOT NULL
     ,store        DATE           NOT NULL
);

INSERT INTO t_book(name, writer, publisher, store)
VALUES('정보보안기사 필기정복', '이기범', '성남캠', TO_DATE(sysdate, 'yyyy-mm-dd'));
commit;

'한권으로 끝내는 C언어', '박병주', '성남캠'
'컴퓨터비전과 머신러닝', '김형오', '광문각'
'혼자 공부하는 파이썬', '박병주', '성남캠'
'정보처리기사 실기정복', '김정두', '성남캠'
'정보처리기사 필기정복', '김정두', '성남캠'
'빅데이터분석기사 필기', '고재만', '성남캠'
'빅데이터분석기사 실기', '고재만', '성남캠'
'정보보안기사 실기정복', '이기범', '성남캠'
'정보보안기사 필기정복', '이기범', '성남캠'

CREATE TABLE T_RENTAL(
     RENTAL_ID INT PRIMARY KEY
    ,BOOK_NAME VARCHAR2(100) unique
    ,MEMBER_ID VARCHAR2(20)
    ,RENTAL_DATE DATE
    ,return_date date
    ,rental_status VARCHAR2(20) DEFAULT '대여 가능'
    CONSTRAINT FK_BOOK_NAME FOREIGN KEY(BOOK_NAME) REFERENCES T_BOOK(NAME)
    );
CREATE SEQUENCE seq_t_RENTAL START WITH 1 INCREMENT BY 1 NOCACHE;
ALTER TABLE T_RENTAL ADD rental_status VARCHAR2(20) DEFAULT '대여 가능';
ALTER TABLE T_RENTAL ADD CONSTRAINT UC_BOOK_MEMBER UNIQUE (BOOK_NAME);

CREATE TABLE T_RENTAL(
     RENTAL_ID INT PRIMARY KEY
    ,BOOK_NAME VARCHAR2(100)
    ,MEMBER_ID VARCHAR2(20)
    ,RENTAL_DATE DATE
    ,return_date date
    ,rental_status VARCHAR2(20) DEFAULT '대여 가능'
    ,CONSTRAINT FK_BOOK_NAME FOREIGN KEY(BOOK_NAME) REFERENCES T_BOOK(NAME)
    );


DELETE FROM t_book 
WHERE name = '자바의 정석' 
AND name not IN (SELECT book_name FROM t_rental);


SELECT * FROM T_MEMBER;
SELECT * FROM T_BOOK;
SELECT * FROM T_RENTAL;

delete from t_rental where book_name = '혼자 공부하는 파이썬';

delete from t_member
where id = 'JM' and password = '1234' and id not in (select member_id from t_rental);


