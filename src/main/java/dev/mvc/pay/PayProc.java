package dev.mvc.pay;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dev.mvc.pay.PayProc")
public class PayProc implements PayProcInter{

  @Autowired
  @Qualifier("dev.mvc.pay.PayDAO")
  private PayDAO payDAO;
  public PayProc() {
    System.out.println("--> PayProc created.");
  }
  
  @Override
  public int create(PayVO payVO) {
    int count = payDAO.create(payVO);
    return count;
  }

  @Override
  public List<PayVO> list(int mno) {
    List<PayVO> list = payDAO.list(mno);
    return list;
  }

  @Override
  public List<PayVO> list_all() {
    List<PayVO> list = payDAO.list_all();
    return list;
  }

  @Override
  public int delete(int payno) {
    int count = payDAO.delete(payno);
    return count;
  }

  @Override
  public int update(PayVO payVO) {
    int count = payDAO.update(payVO);
    return count;
  }

  @Override
  public PayVO read(int payno) {
    return payDAO.read(payno);
  }
  
  

}
