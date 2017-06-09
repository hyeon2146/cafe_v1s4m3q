package dev.mvc.pay;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dev.mvc.pay.PayDAO")
public class PayDAO implements PayDAOInter {

  @Autowired
  private SqlSessionTemplate mybatis;
  public PayDAO() {
    System.out.println("--> PayDAO created.");
  }
  @Override
  public int create(PayVO payVO) {
    int count = mybatis.insert("pay.create", payVO);
    return count;
  }
  @Override
  public List<PayVO> list(int mno) {
    List<PayVO> list = mybatis.selectList("pay.list", mno);
    return list;
  }
  @Override
  public List<PayVO> list_all() {
    List<PayVO> list = mybatis.selectList("pay.list_all");
    return list;
  }
  @Override
  public int delete(int payno) {
    int count = mybatis.delete("pay.delete", payno);
    return count;
  }
  @Override
  public int update(PayVO payVO) {
    int count = mybatis.update("pay.update",payVO);
    return count;
  }
  @Override
  public PayVO read(int payno) {
    return mybatis.selectOne("pay.read",payno);
  }

}
