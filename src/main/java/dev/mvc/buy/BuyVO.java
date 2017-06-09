package dev.mvc.buy;

/*  buyno         INT NOT NULL AUTO_INCREMENT, -- 주문번호, 레코드를 구분하는 컬럼 
payno         INT NOT NULL , -- 결제번호
itemno        INT NOT NULL , -- 상품번호
cnt             INT DEFAULT 0  NULL , -- 상품수
price           INT NOT NULL , -- 금액
rdate VARCHAR(10) NOT NULL, -- 등록일
PRIMARY KEY(buyno),      
FOREIGN KEY (payno) REFERENCES pay (payno),
FOREIGN KEY (cartno) REFERENCES cart (cartno),
FOREIGN KEY (itemno) REFERENCES item (itemno)*/

public class BuyVO {
  /** 주문 일련 번호 */
  private int buyno;
  /** 결제 번호 */
  private int payno;
  /** 상품 번호*/
  private int itemno;
  /** 상품 수 */
  private int cnt;
  /** 금액 */
  private int price;
  /** 등록일 */
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
