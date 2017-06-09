------------------------------------------------------------------------------------
1) pay 테이블의 생성 
   - PRIMARY KEY(payno): payno 값이 2번이상 등록되는 것을 차단, 중복 제거
   
   - 기존의 테이블 삭제
     DROP TABLE pay;
   
CREATE TABLE pay(
    payno INT NOT NULL AUTO_INCREMENT, -- 카드 고유 번호
    mno INT NOT NULL, -- 회원 번호
    mycardno INT NOT NULL, -- 카드 번호
    rname VARCHAR(20) NOT NULL, -- 받는 사람
    tel          VARCHAR(14)   NOT NULL, -- 전화번호
    zipcode   VARCHAR(5)        NULL, -- 우편번호, 12345
    address1  VARCHAR(80)       NULL, -- 주소 1
    address2  VARCHAR(50)       NULL, -- 주소 2
    total         INT NOT NULL, -- 합계금
    rdate DATETIME NOT NULL, -- 등록일
    
    PRIMARY KEY (payno),
    FOREIGN KEY (mycardno) REFERENCES mycard(mycardno),
    FOREIGN KEY (mno) REFERENCES member(mno)
);
 
    
2) 테이블 삭제
   DROP TABLE pay;
 
 
3) 등록
   INSERT INTO pay(mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate)
   VALUES(2, 1, '회원2', '', '', '주소', '', 10000, now() );
 
   
   INSERT INTO pay(mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate)
   VALUES(2, 1, '회원2', '', '', '주소', '', 10000, now() );
 
   
   INSERT INTO pay(mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate)
   VALUES(2, 1, '회원2', '', '', '주소', '', 10000, now() );
 
   
4) 목록
   SELECT payno, mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
   FROM pay 
   ORDER BY payno ASC;
   
 
   SELECT payno, mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
   FROM pay 
   ORDER BY payno DESC;
   
   
5) 회원별 조회
   SELECT payno, mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
   FROM pay
   WHERE mno = 1
   ORDER BY payno ASC;
   

 
6) 수정
   UPDATE pay
   SET mycardno = 1, rname = '', tel = '', zipcode = '', address1 = '', address2 = '', total = 1000
   WHERE payno = 1;
 
 
7) 삭제
① 하나의 레코드 삭제
    DELETE FROM pay
    WHERE payno = 1;
 
 
② 모든 레코드 삭제(주의)
    DELETE FROM pay;
 
 
-------------------------------------------------------------------------------------
