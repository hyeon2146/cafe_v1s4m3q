------------------------------------------------------------------------------------
1) buy 테이블의 생성 
   - PRIMARY KEY(buyno): buyno 값이 2번이상 등록되는 것을 차단, 중복 제거
   
   - 기존의 테이블 삭제
    DROP TABLE buy;
 
CREATE TABLE buy(
	buyno         INT NOT NULL AUTO_INCREMENT, -- 주문번호, 레코드를 구분하는 컬럼 
	payno         INT NOT NULL , -- 결제번호
	itemno        INT NOT NULL , -- 상품번호
	cnt             INT DEFAULT 0  NULL , -- 상품수
	price           INT NOT NULL , -- 금액
	rdate VARCHAR(10) NOT NULL, -- 등록일
  PRIMARY KEY(buyno),      
  FOREIGN KEY (payno) REFERENCES pay (payno),
  FOREIGN KEY (itemno) REFERENCES item (itemno)
);
 
    
2) 테이블 삭제
   DROP TABLE buy;
 
 
3) 등록
   INSERT INTO buy(payno, itemno, cnt, price, rdate)
   VALUES(1, 1, 1, 1, 5000, now());
 
   
4) 목록
   SELECT buyno, payno, itemno, cnt, price, rdate
   FROM buy 
   ORDER BY buyno ASC;
   
 
   SELECT buyno, payno, itemno, cnt, price, rdate
   FROM buy 
   ORDER BY buyno DESC;
   
   
5) 조회
   SELECT buyno, payno, itemno, cnt, price, rdate
   FROM buy
   WHERE buyno = 1;
   

 
6) 수정
   UPDATE buy
   SET payno = 1, itemno = 1, cnt = 1, price = 2000
   WHERE buyno = 1;
 
 
7) 삭제
① 하나의 레코드 삭제
    DELETE FROM buy
    WHERE buyno = 1;
 
 
② 모든 레코드 삭제(주의)
    DELETE FROM buy;
 
 
-------------------------------------------------------------------------------------
