1. ���̺� ����
DROP TABLE member;
 
CREATE TABLE member (
  mno INT NOT NULL AUTO_INCREMENT, -- ȸ�� ��ȣ, ���ڵ带 �����ϴ� �÷� 
  authurlno INT                 NOT NULL DEFAULT 1, -- ���� ��ȣ
  id           VARCHAR(20)   NOT NULL UNIQUE, -- ���̵�, �ߺ� �ȵ�, ���ڵ带 ���� 
  passwd    VARCHAR(20)   NOT NULL, -- �н�����, ������ ����
  mname    VARCHAR(20)   NOT NULL, -- ����, �ѱ� 10�� ���� ����
  tel          VARCHAR(14)   NOT NULL, -- ��ȭ��ȣ
  zipcode   VARCHAR(5)        NULL, -- �����ȣ, 12345
  address1  VARCHAR(80)       NULL, -- �ּ� 1
  address2  VARCHAR(50)       NULL, -- �ּ� 2
  mdate     DATETIME            NOT NULL, -- ������    
  
  PRIMARY KEY (mno),             -- �ѹ� ��ϵ� ���� �ߺ� �ȵ�
  FOREIGN KEY (authurlno) REFERENCES authurl(authurlno)
);
 
��ȣ ���� �˻��� �Է��� �� �ִٸ� 

2. ���
 
1) id �ߺ� Ȯ��
SELECT COUNT(id) as cnt
FROM member
WHERE id='user4';
 
 cnt
 ---
   0   �� �ߺ� ���� ����.
   
2) ���
INSERT INTO member(authurlno, id, passwd, mname, tel, zipcode, address1, address2, mdate)
VALUES (1, 'user1', '1234', '�մ���', '000-0000-0000', '12345', '����� ���α�', '��ö��', now());
 
INSERT INTO member(authurlno, id, passwd, mname, tel, zipcode, address1, address2, mdate)
VALUES (1, 'user2', '1234', '�մ���', '000-0000-0000', '12345', '����� ���α�', '��ö��', now());
 
INSERT INTO member(authurlno, id, passwd, mname, tel, zipcode, address1, address2, mdate)
VALUES (1, 'user3', '1234', '�մ���', '000-0000-0000', '12345', '����� ���α�', '��ö��', now());
 
 
3. ���
- �˻��� ���� �ʴ� ���, ��ü ��� ���
 
SELECT mno, authurlno, id, passwd, mname, tel, zipcode, address1, address2, mdate
FROM member
ORDER BY mno ASC;
 
 mno authurlno id    passwd mname tel           zipcode address1 address2 mdate
 --- --------- ----- ------ ----- ------------- ------- -------- -------- ---------------------
   1         1 user1 1234   �մ���   000-0000-0000 12345   ����� ���α�  ��ö��      2017-05-31 16:24:37.0
   2         1 user2 1234   �մ���   000-0000-0000 12345   ����� ���α�  ��ö��      2017-05-31 16:24:39.0
   3         1 user3 1234   �մ���   000-0000-0000 12345   ����� ���α�  ��ö��      2017-05-31 16:24:40.0

   
3. ��ȸ
 
1) user1 ��� ���� ����
 
 
4. ����
 
 
5. ����
 
 
6. �˻�
 
 
7. ����¡
 
 
* ������Ʈ ����� �߰� �÷� �ȳ�: �̸���, ����, ȸ�� ����, ����, ���
  
-------------------------------------------------------------------------------------

