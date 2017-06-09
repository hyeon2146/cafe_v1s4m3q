package dev.mvc.pay;

public class PayVO {
/*  payno INT NOT NULL AUTO_INCREMENT, -- 카드 고유 번호
  mno INT NOT NULL, -- 회원 번호
  mycardno INT NOT NULL, -- 카드 번호
  rname VARCHAR(20) -- 받는 사람
  tel          VARCHAR(14)   NOT NULL, -- 전화번호
  zipcode   VARCHAR(5)        NULL, -- 우편번호, 12345
  address1  VARCHAR(80)       NULL, -- 주소 1
  address2  VARCHAR(50)       NULL, -- 주소 2
  total         INT NOT NULL, -- 합계금
  rdate VARCHAR(10) NOT NULL, -- 등록일
  
  PRIMARY KEY (payno),
  FOREIGN KEY (mycardno) REFERENCES mycard(mycardno),
  FOREIGN KEY (mno) REFERENCES member(mno)*/
  
  private int payno;
  private int mno;
  private int mycardno;
  private String rname;
  private String tel;
  private String zipcode;
  private String address1;
  private String address2;
  private int total;
  private String rdate;
  
  public int getPayno() {
    return payno;
  }
  public void setPayno(int payno) {
    this.payno = payno;
  }
  public int getMno() {
    return mno;
  }
  public void setMno(int mno) {
    this.mno = mno;
  }
  public int getMycardno() {
    return mycardno;
  }
  public void setMycardno(int mycardno) {
    this.mycardno = mycardno;
  }
  public String getRname() {
    return rname;
  }
  public void setRname(String rname) {
    this.rname = rname;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getZipcode() {
    return zipcode;
  }
  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }
  public String getAddress1() {
    return address1;
  }
  public void setAddress1(String address1) {
    this.address1 = address1;
  }
  public String getAddress2() {
    return address2;
  }
  public void setAddress2(String address2) {
    this.address2 = address2;
  }
  public int getTotal() {
    return total;
  }
  public void setTotal(int total) {
    this.total = total;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  
  
  

}
