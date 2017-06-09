DROP TABLE categrp;
DROP TABLE category;
DROP TABLE cart;
DROP TABLE item;

CREATE TABLE categrp(
    categrpno     INT NOT NULL AUTO_INCREMENT, -- 카테그룹번호, 레코드를 구분하는 컬럼 
    name           VARCHAR(50) NOT NULL, -- 이름
    seqno          INT       DEFAULT 0    NOT NULL, -- 순서
    visible          CHAR(1) DEFAULT 'Y'               NOT NULL, -- 출력 선택
    PRIMARY KEY(categrpno)
);
 
CREATE TABLE category(
  categoryno      INT NOT NULL AUTO_INCREMENT, -- 카테그룹번호, 레코드를 구분하는 컬럼 
  categrpno       INT NOT NULL , -- 카테그룹번호, 레코드를 구분하는 컬럼 
  title                VARCHAR(50) NOT NULL, -- 카테고리명
  seqno             INT       DEFAULT 0    NOT NULL, -- 순서
  visible             CHAR(1) DEFAULT 'Y'               NOT NULL, -- 출력 선택
  ids                  VARCHAR(100) NOT NULL, -- 접근계정
  cnt                  INT       DEFAULT 0    NOT NULL, -- 등록된 글 수 
  rdate               DATETIME    NOT NULL, -- 등록일
  PRIMARY KEY(categoryno),
  FOREIGN KEY (categrpno) REFERENCES categrp (categrpno)
);
 
 
CREATE TABLE item(
        itemno               INT NOT NULL AUTO_INCREMENT, -- 아이템번호, 레코드를 구분하는 컬럼 
        categoryno         INT NOT NULL , -- 카테고리번호
        title                   VARCHAR(100) NOT NULL, 
        content              VARCHAR(4000) NOT NULL, 
        thumb               VARCHAR(100) NOT NULL, 
        file1                   VARCHAR(50) NOT NULL, 
        size1                  INT DEFAULT 0  NULL , 
        rdate                   DATETIME    NOT NULL, -- 등록일
        word                 VARCHAR(100) NOT NULL, 
        PRIMARY KEY(itemno),
        FOREIGN KEY (categoryno) REFERENCES category (categoryno)
);
 
 
CREATE TABLE cart(
  cartno     INT NOT NULL AUTO_INCREMENT, -- 카트번호, 레코드를 구분하는 컬럼 
  mno       INT NOT NULL , -- 
  itemno    INT NOT NULL , -- 
  cnt         INT NOT NULL , -- 
  buycheck CHAR(1) DEFAULT 'Y'  NOT NULL, -- 출력 선택
 
  PRIMARY KEY(cartno),
  FOREIGN KEY (mno) REFERENCES member (mno),
  FOREIGN KEY (itemno) REFERENCES item (itemno)
);

------------------------------------------------------------------------------------
1) store 테이블의 생성 
   - PRIMARY KEY(storeno): storeno 값이 2번이상 등록되는 것을 차단, 중복 제거
   
   - 기존의 테이블 삭제
     DROP TABLE store;
   
CREATE TABLE store(
    storeno INT NOT NULL AUTO_INCREMENT, -- 매장 번호
    sname VARCHAR(20) NOT NULL, -- 매장 명
    address1 VARCHAR(80) NOT NULL, -- 매장 주소 
    address2 VARCHAR(80) NOT NULL, -- 찾아오는 길 
    tel VARCHAR(20) NOT NULL, -- 매장 전화번호
    parking VARCHAR(10) DEFAULT 'Y' NOT NULL, -- 주차장 유무
    rdate DATETIME NOT NULL, -- 등록일
    
    PRIMARY KEY (storeno)
);
 
    
2) 테이블 삭제
   DROP TABLE store;
 
 
3) 등록
   INSERT INTO store(sname, address1, address2, tel, parking, rdate)
   VALUES('매장명', '주소', '찾아오는 길', '02-000-0000', 'Y', now() );
 
   
4) 목록
   SELECT storeno, sname, address1, address2, tel, parking, rdate
   FROM store 
   ORDER BY storeno ASC;
   
 
   SELECT storeno, sname, address1, address2, tel, parking, rdate
   FROM store 
   ORDER BY storeno DESC;
   
   
5) 조회
   SELECT reviewno, mno, mlno, title, content, grade, cnt, likecnt, rdate
   FROM review
   WHERE reviewno = 1;
   

 
6) 수정
   UPDATE review
   SET mno=#{mno}, title = '제목 수정', content = '내용 수정', grade = 1
   WHERE reviewno = 1;
 
 
7) 삭제
① 하나의 레코드 삭제
    DELETE FROM review
    WHERE reviewno = 1;
 
 
② 모든 레코드 삭제(주의)
    DELETE FROM review;
 
 
-------------------------------------------------------------------------------------
