------------------------------------------------------------------------------------
1) buy ���̺��� ���� 
   - PRIMARY KEY(buyno): buyno ���� 2���̻� ��ϵǴ� ���� ����, �ߺ� ����
   
   - ������ ���̺� ����
    DROP TABLE buy;
 
CREATE TABLE buy(
	buyno         INT NOT NULL AUTO_INCREMENT, -- �ֹ���ȣ, ���ڵ带 �����ϴ� �÷� 
	payno         INT NOT NULL , -- ������ȣ
	itemno        INT NOT NULL , -- ��ǰ��ȣ
	cnt             INT DEFAULT 0  NULL , -- ��ǰ��
	price           INT NOT NULL , -- �ݾ�
	rdate VARCHAR(10) NOT NULL, -- �����
  PRIMARY KEY(buyno),      
  FOREIGN KEY (payno) REFERENCES pay (payno),
  FOREIGN KEY (itemno) REFERENCES item (itemno)
);
 
    
2) ���̺� ����
   DROP TABLE buy;
 
 
3) ���
   INSERT INTO buy(payno, itemno, cnt, price, rdate)
   VALUES(1, 1, 1, 1, 5000, now());
 
   
4) ���
   SELECT buyno, payno, itemno, cnt, price, rdate
   FROM buy 
   ORDER BY buyno ASC;
   
 
   SELECT buyno, payno, itemno, cnt, price, rdate
   FROM buy 
   ORDER BY buyno DESC;
   
   
5) ��ȸ
   SELECT buyno, payno, itemno, cnt, price, rdate
   FROM buy
   WHERE buyno = 1;
   

 
6) ����
   UPDATE buy
   SET payno = 1, itemno = 1, cnt = 1, price = 2000
   WHERE buyno = 1;
 
 
7) ����
�� �ϳ��� ���ڵ� ����
    DELETE FROM buy
    WHERE buyno = 1;
 
 
�� ��� ���ڵ� ����(����)
    DELETE FROM buy;
 
 
-------------------------------------------------------------------------------------
