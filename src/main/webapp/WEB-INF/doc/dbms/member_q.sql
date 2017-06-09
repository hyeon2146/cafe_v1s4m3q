1. 테이블 구조
DROP TABLE member;
 
CREATE TABLE member (
  mno INT NOT NULL AUTO_INCREMENT, -- 회원 번호, 레코드를 구분하는 컬럼 
  authurlno INT                 NOT NULL DEFAULT 1, -- 권한 번호
  id           VARCHAR(20)   NOT NULL UNIQUE, -- 아이디, 중복 안됨, 레코드를 구분 
  passwd    VARCHAR(20)   NOT NULL, -- 패스워드, 영숫자 조합
  mname    VARCHAR(20)   NOT NULL, -- 성명, 한글 10자 저장 가능
  tel          VARCHAR(14)   NOT NULL, -- 전화번호
  zipcode   VARCHAR(5)        NULL, -- 우편번호, 12345
  address1  VARCHAR(80)       NULL, -- 주소 1
  address2  VARCHAR(50)       NULL, -- 주소 2
  mdate     DATETIME            NOT NULL, -- 가입일    
  
  PRIMARY KEY (mno),             -- 한번 등록된 값은 중복 안됨
  FOREIGN KEY (authurlno) REFERENCES authurl(authurlno)
);
 
선호 매장 검색해 입력할 수 있다면 

2. 등록
 
1) id 중복 확인
SELECT COUNT(id) as cnt
FROM member
WHERE id='user4';
 
 cnt
 ---
   0   ← 중복 되지 않음.
   
2) 등록
INSERT INTO member(authurlno, id, passwd, mname, tel, zipcode, address1, address2, mdate)
VALUES (1, 'user1', '1234', '왕눈이', '000-0000-0000', '12345', '서울시 종로구', '관철동', now());
 
INSERT INTO member(authurlno, id, passwd, mname, tel, zipcode, address1, address2, mdate)
VALUES (1, 'user2', '1234', '왕눈이', '000-0000-0000', '12345', '서울시 종로구', '관철동', now());
 
INSERT INTO member(authurlno, id, passwd, mname, tel, zipcode, address1, address2, mdate)
VALUES (1, 'user3', '1234', '왕눈이', '000-0000-0000', '12345', '서울시 종로구', '관철동', now());
 
 
3. 목록
- 검색을 하지 않는 경우, 전체 목록 출력
 
SELECT mno, authurlno, id, passwd, mname, tel, zipcode, address1, address2, mdate
FROM member
ORDER BY mno ASC;
 
 mno authurlno id    passwd mname tel           zipcode address1 address2 mdate
 --- --------- ----- ------ ----- ------------- ------- -------- -------- ---------------------
   1         1 user1 1234   왕눈이   000-0000-0000 12345   서울시 종로구  관철동      2017-05-31 16:24:37.0
   2         1 user2 1234   왕눈이   000-0000-0000 12345   서울시 종로구  관철동      2017-05-31 16:24:39.0
   3         1 user3 1234   왕눈이   000-0000-0000 12345   서울시 종로구  관철동      2017-05-31 16:24:40.0

   
3. 조회
 
1) user1 사원 정보 보기
 
 
4. 수정
 
 
5. 삭제
 
 
6. 검색
 
 
7. 페이징
 
 
* 프로젝트 설계시 추가 컬럼 안내: 이메일, 별명, 회원 사진, 직업, 등급
  
-------------------------------------------------------------------------------------

