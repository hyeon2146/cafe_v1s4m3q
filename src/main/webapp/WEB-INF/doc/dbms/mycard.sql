------------------------------------------------------------------------------------
1) mycard ���̺��� ���� 
   - PRIMARY KEY(mycardno): mycardno ���� 2���̻� ��ϵǴ� ���� ����, �ߺ� ����
   
   - ������ ���̺� ����
     DROP TABLE mycard;
   
CREATE TABLE mycard(
    mycardno INT NOT NULL AUTO_INCREMENT, -- ī�� ���� ��ȣ
    mno INT NOT NULL, -- ȸ�� ��ȣ
    cname VARCHAR(10) NOT NULL, -- ī�� ��Ī
    money INT NOT NULL, -- �ܾ�
    rdate DATETIME NOT NULL, -- �����
    mdate DATETIME NOT NULL, -- ������
    
    PRIMARY KEY (mycardno),
    FOREIGN KEY (mno) REFERENCES member(mno)
);
 
    
2) ���̺� ����
   DROP TABLE mycard;
 
 
3) ���
   INSERT INTO mycard(mno, cname, money, rdate, mdate)
   VALUES(2, 'ī��', 10000, now(), now() );
 
   
4) ���
   SELECT mycardno, mno, cname, money, rdate, mdate
   FROM mycard 
   ORDER BY mycardno ASC;
   
 
   SELECT mycardno, mno, cname, money, rdate, mdate
   FROM mycard 
   ORDER BY mycardno DESC;
   
   
5) ��ȸ
   SELECT mycardno, mno, cname, money, rdate, mdate
   FROM mycard
   WHERE mycardno = 1;
   

 
6) ����
   UPDATE mycard
   SET cname = '���� ����'
   WHERE mycardno = 1;
   
   
   UPDATE mycard
   SET money = 1
   WHERE mycardno = 1;
 
 
7) ����
�� �ϳ��� ���ڵ� ����
    DELETE FROM mycard
    WHERE mycardno = 1;
 
 
�� ��� ���ڵ� ����(����)
    DELETE FROM mycard;
 
 
-------------------------------------------------------------------------------------
