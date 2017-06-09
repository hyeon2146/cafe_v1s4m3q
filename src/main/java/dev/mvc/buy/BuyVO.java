package dev.mvc.buy;

/*  buyno         INT NOT NULL AUTO_INCREMENT, -- �ֹ���ȣ, ���ڵ带 �����ϴ� �÷� 
payno         INT NOT NULL , -- ������ȣ
itemno        INT NOT NULL , -- ��ǰ��ȣ
cnt             INT DEFAULT 0  NULL , -- ��ǰ��
price           INT NOT NULL , -- �ݾ�
rdate VARCHAR(10) NOT NULL, -- �����
PRIMARY KEY(buyno),      
FOREIGN KEY (payno) REFERENCES pay (payno),
FOREIGN KEY (cartno) REFERENCES cart (cartno),
FOREIGN KEY (itemno) REFERENCES item (itemno)*/

public class BuyVO {
  /** �ֹ� �Ϸ� ��ȣ */
  private int buyno;
  /** ���� ��ȣ */
  private int payno;
  /** ��ǰ ��ȣ*/
  private int itemno;
  /** ��ǰ �� */
  private int cnt;
  /** �ݾ� */
  private int price;
  /** ����� */
  private String rdate;
  public int getBuyno() {
    return buyno;
  }
  public void setBuyno(int buyno) {
    this.buyno = buyno;
  }
  public int getPayno() {
    return payno;
  }
  public void setPayno(int payno) {
    this.payno = payno;
  }
  public int getItemno() {
    return itemno;
  }
  public void setItemno(int itemno) {
    this.itemno = itemno;
  }
  public int getCnt() {
    return cnt;
  }
  public void setCnt(int cnt) {
    this.cnt = cnt;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  
  
}
