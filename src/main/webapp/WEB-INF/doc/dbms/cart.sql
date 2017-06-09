DROP TABLE cart;
 
CREATE TABLE cart(
  cartno     INT NOT NULL AUTO_INCREMENT, -- īƮ��ȣ, ���ڵ带 �����ϴ� �÷� 
  mno       INT NOT NULL , -- 
  itemno    INT NOT NULL , -- 
  cnt         INT NOT NULL , -- 
  buycheck CHAR(1) DEFAULT 'Y'  NOT NULL, -- ��� ����
 
  PRIMARY KEY(cartno),
  FOREIGN KEY (mno) REFERENCES member (mno),
  FOREIGN KEY (itemno) REFERENCES item (itemno)
);
 
1. ���
 
INSERT INTO cart(mno, itemno, cnt, buycheck)
VALUES(1, 5, 1, 'Y');
 
INSERT INTO category(categoryno, categrpno, title, seqno, visible, ids, rdate)
VALUES((SELECT NVL(MAX(categoryno), 0)+1 as categoryno FROM category),
             1, '�θǽ�', 2 ,'Y' , 'admin', sysdate);
 
INSERT INTO category(categoryno, categrpno, title, seqno, visible, ids, rdate)
VALUES((SELECT NVL(MAX(categoryno), 0)+1 as categoryno FROM category),
             1, '�ڹ�' , 3 , 'Y' , 'admin', sysdate);
 
             
2. ���
-- DELETE FROM category;
 
SELECT cartno, mno, itemno, cnt, buycheck
FROM cart 
ORDER BY cartno ASC;