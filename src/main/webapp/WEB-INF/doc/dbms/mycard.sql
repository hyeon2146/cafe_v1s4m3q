------------------------------------------------------------------------------------
1) mycard 테이블의 생성 
   - PRIMARY KEY(mycardno): mycardno 값이 2번이상 등록되는 것을 차단, 중복 제거
   
   - 기존의 테이블 삭제
     DROP TABLE mycard;
   
CREATE TABLE mycard(
    mycardno INT NOT NULL AUTO_INCREMENT, -- 카드 고유 번호
    mno INT NOT NULL, -- 회원 번호
    cname VARCHAR(10) NOT NULL, -- 카드 별칭
    money INT NOT NULL, -- 잔액
    rdate DATETIME NOT NULL, -- 등록일
    mdate DATETIME NOT NULL, -- 충전일
    
    PRIMARY KEY (mycardno),
    FOREIGN KEY (mno) REFERENCES member(mno)
);
 
    
2) 테이블 삭제
   DROP TABLE mycard;
 
 
3) 등록
   INSERT INTO mycard(mno, cname, money, rdate, mdate)
   VALUES(2, '카드', 10000, now(), now() );
 
   
4) 목록
   SELECT mycardno, mno, cname, money, rdate, mdate
   FROM mycard 
   ORDER BY mycardno ASC;
   
 
   SELECT mycardno, mno, cname, money, rdate, mdate
   FROM mycard 
   ORDER BY mycardno DESC;
   
   
5) 조회
   SELECT mycardno, mno, cname, money, rdate, mdate
   FROM mycard
   WHERE mycardno = 1;
   

 
6) 수정
   UPDATE mycard
   SET cname = '제목 수정'
   WHERE mycardno = 1;
   
   
   UPDATE mycard
   SET money = 1
   WHERE mycardno = 1;
 
 
7) 삭제
① 하나의 레코드 삭제
    DELETE FROM mycard
    WHERE mycardno = 1;
 
 
② 모든 레코드 삭제(주의)
    DELETE FROM mycard;
 
 
-------------------------------------------------------------------------------------
