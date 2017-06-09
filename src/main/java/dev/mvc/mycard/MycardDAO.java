package dev.mvc.mycard;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dev.mvc.mycard.MycardDAO")
public class MycardDAO implements MycardDAOInter {

  @Autowired
  private SqlSessionTemplate mybatis;
  public MycardDAO() {
    System.out.println("--> MycardDAO created.");
  }
  @Override
  public int create(MycardVO mycardVO) {
    return mybatis.insert("mycard.create", mycardVO);
  }
  @Override
  public List<MycardVO> list(int mno) {
    return mybatis.selectList("mycard.list", mno);
  }
  @Override
  public List<MycardVO> list_all() {
    return mybatis.selectList("mycard.list_all");
  }
  @Override
  public int delete(int mycardno) {
    return mybatis.delete("mycard.delete", mycardno);
  }
  @Override
  public MycardVO read(int mycardno) {
    return mybatis.selectOne("mycard.read", mycardno);
  }
  @Override
  public int update(MycardVO mycardVO) {
    return mybatis.update("mycard.update", mycardVO);
  }
  @Override
  public int update_money(MycardVO mycardVO) {
    return mybatis.update("mycard.update_money", mycardVO);
  }

}
