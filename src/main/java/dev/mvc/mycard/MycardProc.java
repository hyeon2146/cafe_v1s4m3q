package dev.mvc.mycard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("dev.mvc.mycard.MycardProc")
public class MycardProc implements MycardProcInter {

  @Autowired
  @Qualifier("dev.mvc.mycard.MycardDAO")
  private MycardDAO mycardDAO;
  
  public MycardProc() {
    System.out.println("--> MycardProc created.");
  }

  @Override
  public int create(MycardVO mycardVO) {
    return mycardDAO.create(mycardVO);
  }

  @Override
  public List<MycardVO> list(int mno) {
    return mycardDAO.list(mno);
  }

  @Override
  public List<MycardVO> list_all() {
    return mycardDAO.list_all();
  }

  @Override
  public int delete(int mycardno) {
    return mycardDAO.delete(mycardno);
  }

  @Override
  public MycardVO read(int mycardno) {
    return mycardDAO.read(mycardno);
  }

  @Override
  public int update(MycardVO mycardVO) {
    return mycardDAO.update(mycardVO);
  }

  @Override
  public int update_money(MycardVO mycardVO) {
    return mycardDAO.update_money(mycardVO);
  }

}
