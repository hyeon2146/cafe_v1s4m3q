package dev.mvc.buy;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dev.mvc.buy.BuyDAO")
public class BuyDAO implements BuyDAOInter {

  @Autowired
  private SqlSessionTemplate mybatis;
  public BuyDAO() {
    System.out.println("--> BuyDAO() created.");
  }
  
  @Override
  public int create(BuyVO buyVO) {
    int count = mybatis.insert("buy.create", buyVO);
    return count;
  }

}
