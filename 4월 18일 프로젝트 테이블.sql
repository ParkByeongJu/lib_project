SELECT * FROM TAB;

CREATE TABLE T_TEST(
     ID VARCHAR2(20) PRIMARY KEY
    ,NAME VARCHAR2(20) NOT NULL
); 

SELECT * FROM T_TEST;

INSERT INTO T_TEST(ID, NAME)
VALUES ('HONG', 'ȫ�浿');

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
     å�̸�    varchar2(100) primary key
    ,���ǻ�    varchar2(100) not null
    ,�԰� ��¥ DATE          NOT NULL
);

CREATE TABLE T_BOOK(
      name      VARCHAR2(100)  PRIMARY KEY
     ,writer     VARCHAR2(50)   NOT NULL
     ,publisher VARCHAR2(100)  NOT NULL
     ,store        DATE           NOT NULL
);


INSERT INTO t_book(name, writer, publisher, store)
VALUES('������ �����ȣó��', '������', '������', TO_DATE(sysdate, 'yyyy-mm-dd'));

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
ALTER TABLE T_RENTAL ADD rental_status VARCHAR2(20) DEFAULT '�뿩 ����';
    
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
        ,CASE WHEN b.rental_status = '�뿩 ��' THEN '�뿩 ��' ELSE '�뿩 ����' END AS rental_status
FROM t_book a 
left JOIN t_rental b 
ON b.book_name = a.name;
    

DELETE T_BOOK FROM T_BOOK INNER JOIN t_rental ON t_book.name = t_rental.book_name  AND rental_status = '�뿩 ����' WHERE a.name = '�ڹ��� ����';

delete t_book from t_book where (select book_name, rental_statue from t_rental where t_book.name = t_rental.book_name)  rental_status = '�뿩 ����' and where name = '�ڹ��� ����';


delete m1 from t_book m1
            inner join t_rental m2 on m2.book_name = m1.name 
where m1.name = '�ڹ��� ����';


and m2.rental_status = '�뿩����';

delete from t_book
where name = '�ڹ��� ����';

DELETE FROM t_book
WHERE name = '�̰��� �ڹٴ�'
AND EXISTS (
    SELECT 1
    FROM t_rental
    WHERE book_name = t_book.name
    AND rental_status = '�뿩 ����'
);

select * from t_book;

select * from t_rental;

DELETE FROM t_book 
WHERE name = '�ڹ��� ����' 
AND name not IN (SELECT book_name FROM t_rental);

SELECT book_name FROM t_rental WHERE rental_status = '�뿩 ����';
select * from t_rental;

select * from t_book;

commit;

INSERT INTO t_book(name, writer, publisher, store)
VALUES('�������ȱ�� �ʱ�����', '�̱��', '����ķ', TO_DATE(sysdate, 'yyyy-mm-dd'));
commit;

'�ѱ����� ������ C���', '�ں���', '����ķ'
'��ǻ�ͺ����� �ӽŷ���', '������', '������'
'ȥ�� �����ϴ� ���̽�', '�ں���', '����ķ'
'����ó����� �Ǳ�����', '������', '����ķ'
'����ó����� �ʱ�����', '������', '����ķ'
'�����ͺм���� �ʱ�', '���縸', '����ķ'
'�����ͺм���� �Ǳ�', '���縸', '����ķ'
'�������ȱ�� �Ǳ�����', '�̱��', '����ķ'
'�������ȱ�� �ʱ�����', '�̱��', '����ķ'
