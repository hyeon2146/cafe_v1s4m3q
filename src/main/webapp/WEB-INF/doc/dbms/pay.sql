------------------------------------------------------------------------------------
1) pay ���̺��� ���� 
   - PRIMARY KEY(payno): payno ���� 2���̻� ��ϵǴ� ���� ����, �ߺ� ����
   
   - ������ ���̺� ����
     DROP TABLE pay;
   
CREATE TABLE pay(
    payno INT NOT NULL AUTO_INCREMENT, -- ī�� ���� ��ȣ
    mno INT NOT NULL, -- ȸ�� ��ȣ
    mycardno INT NOT NULL, -- ī�� ��ȣ
    rname VARCHAR(20) NOT NULL, -- �޴� ���
    tel          VARCHAR(14)   NOT NULL, -- ��ȭ��ȣ
    zipcode   VARCHAR(5)        NULL, -- �����ȣ, 12345
    address1  VARCHAR(80)       NULL, -- �ּ� 1
    address2  VARCHAR(50)       NULL, -- �ּ� 2
    total         INT NOT NULL, -- �հ��
    rdate DATETIME NOT NULL, -- �����
    
    PRIMARY KEY (payno),
    FOREIGN KEY (mycardno) REFERENCES mycard(mycardno),
    FOREIGN KEY (mno) REFERENCES member(mno)
);
 
    
2) ���̺� ����
   DROP TABLE pay;
 
 
3) ���
   INSERT INTO pay(mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate)
   VALUES(2, 1, 'ȸ��2', '', '', '�ּ�', '', 10000, now() );
 
   
   INSERT INTO pay(mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate)
   VALUES(2, 1, 'ȸ��2', '', '', '�ּ�', '', 10000, now() );
 
   
   INSERT INTO pay(mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate)
   VALUES(2, 1, 'ȸ��2', '', '', '�ּ�', '', 10000, now() );
 
   
4) ���
   SELECT payno, mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
   FROM pay 
   ORDER BY payno ASC;
   
 
   SELECT payno, mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
   FROM pay 
   ORDER BY payno DESC;
   
   
5) ȸ���� ��ȸ
   SELECT payno, mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
   FROM pay
   WHERE mno = 1
   ORDER BY payno ASC;
   

 
6) ����
   UPDATE pay
   SET mycardno = 1, rname = '', tel = '', zipcode = '', address1 = '', address2 = '', total = 1000
   WHERE payno = 1;
 
 
7) ����
�� �ϳ��� ���ڵ� ����
    DELETE FROM pay
    WHERE payno = 1;
 
 
�� ��� ���ڵ� ����(����)
    DELETE FROM pay;
 
 
-------------------------------------------------------------------------------------
