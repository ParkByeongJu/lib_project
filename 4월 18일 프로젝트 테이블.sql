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

CREATE TABLE T_RENTAL(
     RENTAL_ID INT PRIMARY KEY
    ,BOOK_NAME VARCHAR2(100) unique
    ,MEMBER_ID VARCHAR2(20)
    ,RENTAL_DATE DATE
    ,return_date date
    ,rental_status VARCHAR2(20) DEFAULT '�뿩 ����'
    CONSTRAINT FK_BOOK_NAME FOREIGN KEY(BOOK_NAME) REFERENCES T_BOOK(NAME)
    );
CREATE SEQUENCE seq_t_RENTAL START WITH 1 INCREMENT BY 1 NOCACHE;
ALTER TABLE T_RENTAL ADD rental_status VARCHAR2(20) DEFAULT '�뿩 ����';
ALTER TABLE T_RENTAL ADD CONSTRAINT UC_BOOK_MEMBER UNIQUE (BOOK_NAME);

CREATE TABLE T_RENTAL(
     RENTAL_ID INT PRIMARY KEY
    ,BOOK_NAME VARCHAR2(100)
    ,MEMBER_ID VARCHAR2(20)
    ,RENTAL_DATE DATE
    ,return_date date
    ,rental_status VARCHAR2(20) DEFAULT '�뿩 ����'
    ,CONSTRAINT FK_BOOK_NAME FOREIGN KEY(BOOK_NAME) REFERENCES T_BOOK(NAME)
    );


DELETE FROM t_book 
WHERE name = '�ڹ��� ����' 
AND name not IN (SELECT book_name FROM t_rental);


SELECT * FROM T_MEMBER;
SELECT * FROM T_BOOK;
SELECT * FROM T_RENTAL;

delete from t_rental where book_name = 'ȥ�� �����ϴ� ���̽�';

delete from t_member
where id = 'JM' and password = '1234' and id not in (select member_id from t_rental);


