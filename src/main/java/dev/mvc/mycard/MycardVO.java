package dev.mvc.mycard;

public class MycardVO {
/*  mycardno INT NOT NULL AUTO_INCREMENT, -- 카드 고유 번호
  mno INT NOT NULL, -- 회원 번호
  cname VARCHAR(10) NOT NULL, -- 카드 별칭
  money INT NOT NULL, -- 잔액
  rdate DATETIME NOT NULL, -- 등록일
  mdate DATETIME NOT NULL, -- 충전일
  
  PRIMARY KEY (mycardno),
  FOREIGN KEY (mno) REFERENCES member(mno)*/
  
  private int mycardno;
  private int mno;
  private String cname;
  private int money;
  private String rdate;
  private String mdate;
  public int getMycardno() {
    return mycardno;
  }
  public void setMycardno(int mycardno) {
    this.mycardno = mycardno;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public String getCname() {
    return cname;
  }
  public void setCname(String cname) {
    this.cname = cname;
  }
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public String getMdate() {
    return mdate;
  }
  public void setMdate(String mdate) {
    this.mdate = mdate;
  }
  
  

}
