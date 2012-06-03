--회원 정보 테이블
CREATE TABLE memberDB(
id NVARCHAR2(15) PRIMARY KEY,
PASSWORD NVARCHAR2(15) NOT NULL,
NAME NVARCHAR2(15) NOT NULL,
jumin NVARCHAR2(15) NOT NULL,
age NUMBER(10) NOT NULL,
sex NVARCHAR2(10) NOT NULL,
addr NVARCHAR2(50) NOT NULL,
phone NVARCHAR2(15) NOT NULL,
email NVARCHAR2(20) NOT NULL,
action NUMBER(10) NOT null
)



SELECT *FROM  memberDB;

INSERT INTO  memberDB(id,PASSWORD,NAME,jumin,age,sex,addr,phone,email,action)
VALUES('goingkgn','1234','고기영','930102-1234567','20','남자','경기 평택',
       '031-123-1234','aaa@daum.net','1.3');

INSERT INTO  memberDB(id,PASSWORD,NAME,jumin,age,sex,addr,phone,email,action)
VALUES('minju','5678','김민주','860708-2234567','27','여자','인천 부평',
       '032-234-5678','bbb@daum.net','1.5');

INSERT INTO  memberDB(id,PASSWORD,NAME,jumin,age,sex,addr,phone,email,action)
VALUES('chamin','5056','이채민','880618-2234567','25','여자','충남 천안',
       '033-123-5056','ccc@daum.net','1.5');

INSERT INTO  memberDB(id,PASSWORD,NAME,jumin,age,sex,addr,phone,email,action)
VALUES('jinhwan','6128','박진환','870102-1234567','26','남자','전남 광주',
       '063-666-1234','ddd@daum.net','1.75');


--관리자의 일반회원 관리 테이블
CREATE TABLE phyInfo(
id NVARCHAR2(15) CONSTRAINT id_fk REFERENCES MEMBERDB(id),
day varchar2(6) NOT NULL,
height number(3) NOT NULL,
weight number(3) NOT NULL
)


SELECT * FROM phyInfo;

INSERT INTO phyInfo VALUES('jinhwan','201205',177,64);
INSERT INTO phyInfo VALUES('chamin','201205',166,44);

COMMIT;


select height,weight from phyInfo where id ='chamin';
