SELECT * FROM TAB;

CREATE TABLE T_TEST(
     ID VARCHAR2(20) PRIMARY KEY
    ,NAME VARCHAR2(20) NOT NULL
); 

SELECT * FROM T_TEST;

INSERT INTO T_TEST(ID, NAME)
VALUES ('HONG', '홍길동');

COMMIT;

select * from employees;

select to_char(hire_date, 'mm') from employees;

select  to_char(hire_date, 'mm') as date1, count(hire_date) from employees group by to_char(hire_date, 'mm') order by 1;

select * from employees;


drop table t_book;

CREATE TABLE t_member (
  id       VARCHAR2(20) PRIMARY key,
  password VARCHAR2(20) NOT NULL,
  name     VARCHAR2(50) NOT NULL,
  birth    DATE         NOT NULL,
  email    VARCHAR2(50) NOT NULL,
  phone    VARCHAR2(20) NOT NULL
);

drop table t_member;

select * from t_member; 
delete from t_member where id = 'JMGOOD';

select count(*) from t_member where id = 'admin' and password = 123;


create table t_book(
     책이름    varchar2(100) primary key
    ,출판사    varchar2(100) not null
    ,입고 날짜 DATE          NOT NULL
);

CREATE TABLE T_BOOK(
      name      VARCHAR2(100)  PRIMARY KEY
     ,writer     VARCHAR2(50)   NOT NULL
     ,publisher VARCHAR2(100)  NOT NULL
     ,store        DATE           NOT NULL
);


INSERT INTO t_book(name, writer, publisher, store)
VALUES('디지털 영상신호처리', '김형오', '광문각', TO_DATE(sysdate, 'yyyy-mm-dd'));

commit;

select *
from t_book;

CREATE TABLE T_RENTAL(
     RENTAL_ID INT PRIMARY KEY
    ,BOOK_NAME VARCHAR2(100) unique
    ,MEMBER_ID VARCHAR2(20)
    ,RENTAL_DATE DATE
    ,return_date date,
    CONSTRAINT FK_BOOK_NAME FOREIGN KEY(BOOK_NAME) REFERENCES T_BOOK(NAME)
    );
ALTER TABLE T_RENTAL ADD rental_status VARCHAR2(20) DEFAULT '대여 가능';
    
select * from T_rental;

CREATE SEQUENCE seq_t_RENTAL START WITH 1 INCREMENT BY 1 NOCACHE;

ALTER TABLE T_RENTAL ADD CONSTRAINT UC_BOOK_MEMBER UNIQUE (BOOK_NAME);

drop SEQUENCE seq_t_RENTAL;
drop table t_rental;

ALTER TABLE t_rental ADD COLUMN return_date date; 


select a.name b.rental_status
    from t_book a 
    join t_rental b on b.book_name = a.name;
    
SELECT a.name, b.rental_status
    FROM t_book a 
    left JOIN t_rental b ON b.book_name = a.name;
    
SELECT a.name ,b.MEMBER_ID ,b.RENTAL_DATE ,b.return_date 
        ,CASE WHEN b.rental_status = '대여 중' THEN '대여 중' ELSE '대여 가능' END AS rental_status
FROM t_book a 
left JOIN t_rental b 
ON b.book_name = a.name;
    

DELETE T_BOOK FROM T_BOOK INNER JOIN t_rental ON t_book.name = t_rental.book_name  AND rental_status = '대여 가능' WHERE a.name = '자바의 정석';

delete t_book from t_book where (select book_name, rental_statue from t_rental where t_book.name = t_rental.book_name)  rental_status = '대여 가능' and where name = '자바의 정석';


delete m1 from t_book m1
            inner join t_rental m2 on m2.book_name = m1.name 
where m1.name = '자바의 정석';


and m2.rental_status = '대여가능';

delete from t_book
where name = '자바의 정석';

DELETE FROM t_book
WHERE name = '이것이 자바다'
AND EXISTS (
    SELECT 1
    FROM t_rental
    WHERE book_name = t_book.name
    AND rental_status = '대여 가능'
);

select * from t_book;

select * from t_rental;

DELETE FROM t_book 
WHERE name = '자바의 정석' 
AND name not IN (SELECT book_name FROM t_rental);

SELECT book_name FROM t_rental WHERE rental_status = '대여 가능';
select * from t_rental;

select * from t_book;

commit;

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
