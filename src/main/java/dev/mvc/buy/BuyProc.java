package dev.mvc.buy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dev.mvc.buy.BuyProc")
public class BuyProc implements BuyProcInter {

  @Autowired
  @Qualifier("dev.mvc.buy.BuyDAO")
  private BuyDAO buyDAO;
  
  public BuyProc() {
    System.out.println("--> BuyProc() created.");
  }

  @Override
  public int create(BuyVO buyVO) {
    int count = buyDAO.create(buyVO);
    return count;
  }

}
