DROP TABLE categrp;
DROP TABLE category;
DROP TABLE cart;
DROP TABLE item;

CREATE TABLE categrp(
    categrpno     INT NOT NULL AUTO_INCREMENT, -- ī�ױ׷��ȣ, ���ڵ带 �����ϴ� �÷� 
    name           VARCHAR(50) NOT NULL, -- �̸�
    seqno          INT       DEFAULT 0    NOT NULL, -- ����
    visible          CHAR(1) DEFAULT 'Y'               NOT NULL, -- ��� ����
    PRIMARY KEY(categrpno)
);
 
CREATE TABLE category(
  categoryno      INT NOT NULL AUTO_INCREMENT, -- ī�ױ׷��ȣ, ���ڵ带 �����ϴ� �÷� 
  categrpno       INT NOT NULL , -- ī�ױ׷��ȣ, ���ڵ带 �����ϴ� �÷� 
  title                VARCHAR(50) NOT NULL, -- ī�װ���
  seqno             INT       DEFAULT 0    NOT NULL, -- ����
  visible             CHAR(1) DEFAULT 'Y'               NOT NULL, -- ��� ����
  ids                  VARCHAR(100) NOT NULL, -- ���ٰ���
  cnt                  INT       DEFAULT 0    NOT NULL, -- ��ϵ� �� �� 
  rdate               DATETIME    NOT NULL, -- �����
  PRIMARY KEY(categoryno),
  FOREIGN KEY (categrpno) REFERENCES categrp (categrpno)
);
 
 
CREATE TABLE item(
        itemno               INT NOT NULL AUTO_INCREMENT, -- �����۹�ȣ, ���ڵ带 �����ϴ� �÷� 
        categoryno         INT NOT NULL , -- ī�װ���ȣ
        title                   VARCHAR(100) NOT NULL, 
        content              VARCHAR(4000) NOT NULL, 
        thumb               VARCHAR(100) NOT NULL, 
        file1                   VARCHAR(50) NOT NULL, 
        size1                  INT DEFAULT 0  NULL , 
        rdate                   DATETIME    NOT NULL, -- �����
        word                 VARCHAR(100) NOT NULL, 
        PRIMARY KEY(itemno),
        FOREIGN KEY (categoryno) REFERENCES category (categoryno)
);
 
 
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

------------------------------------------------------------------------------------
1) store ���̺��� ���� 
   - PRIMARY KEY(storeno): storeno ���� 2���̻� ��ϵǴ� ���� ����, �ߺ� ����
   
   - ������ ���̺� ����
     DROP TABLE store;
   
CREATE TABLE store(
    storeno INT NOT NULL AUTO_INCREMENT, -- ���� ��ȣ
    sname VARCHAR(20) NOT NULL, -- ���� ��
    address1 VARCHAR(80) NOT NULL, -- ���� �ּ� 
    address2 VARCHAR(80) NOT NULL, -- ã�ƿ��� �� 
    tel VARCHAR(20) NOT NULL, -- ���� ��ȭ��ȣ
    parking VARCHAR(10) DEFAULT 'Y' NOT NULL, -- ������ ����
    rdate DATETIME NOT NULL, -- �����
    
    PRIMARY KEY (storeno)
);
 
    
2) ���̺� ����
   DROP TABLE store;
 
 
3) ���
   INSERT INTO store(sname, address1, address2, tel, parking, rdate)
   VALUES('�����', '�ּ�', 'ã�ƿ��� ��', '02-000-0000', 'Y', now() );
 
   
4) ���
   SELECT storeno, sname, address1, address2, tel, parking, rdate
   FROM store 
   ORDER BY storeno ASC;
   
 
   SELECT storeno, sname, address1, address2, tel, parking, rdate
   FROM store 
   ORDER BY storeno DESC;
   
   
5) ��ȸ
   SELECT reviewno, mno, mlno, title, content, grade, cnt, likecnt, rdate
   FROM review
   WHERE reviewno = 1;
   

 
6) ����
   UPDATE review
   SET mno=#{mno}, title = '���� ����', content = '���� ����', grade = 1
   WHERE reviewno = 1;
 
 
7) ����
�� �ϳ��� ���ڵ� ����
    DELETE FROM review
    WHERE reviewno = 1;
 
 
�� ��� ���ڵ� ����(����)
    DELETE FROM review;
 
 
-------------------------------------------------------------------------------------
