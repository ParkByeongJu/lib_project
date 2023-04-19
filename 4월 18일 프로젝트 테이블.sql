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
    
SELECT a.name, 
       CASE 
         WHEN b.rental_status = '대여 중' THEN '대여 중' 
         ELSE '대여 가능' 
       END AS rental_status
FROM t_book a 
left JOIN t_rental b 
ON b.book_name = a.name;
    
    
    
    
    
    