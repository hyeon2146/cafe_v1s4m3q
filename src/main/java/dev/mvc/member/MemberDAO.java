package dev.mvc.member;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
@Repository("dev.mvc.member.MemberDAO")
public class MemberDAO implements MemberDAOInter {
 
  @Autowired
  private SqlSessionTemplate mybatis;
 
  public MemberDAO() {
    System.out.println("--> MemberDAO created.");
  }

  /**
   * 중복 아이디 검사
   *   <select id="checkId" resultType="int" parameterType="String">
   * @param id
   * @return 중복 아이디 갯수
   */
  @Override
  public int checkId(String id) {
    int count =mybatis.selectOne("member.checkId", id);
    
    return count;
  }

  /**
   * 회원 등록
   * <insert id="create" parameterType="MemberVO">
   * @param memberVO
   * @return 등록된 회원 수
   */
  @Override
  public int create(MemberVO memberVO) {
    int count =mybatis.insert("member.create",memberVO);
    return count;
  }

  @Override
  public List<MemberVO> list() {
    List<MemberVO> list = mybatis.selectList("member.list");
    
    return list;
  }
  
  @Override
  public MemberVO read(int mno) {
    MemberVO memberVO = mybatis.selectOne("member.read", mno);
    
    return memberVO;
  }
 
  @Override
  public MemberVO readById(String id) {
    MemberVO memberVO = mybatis.selectOne("member.readById", id);
    
    return memberVO;
  }  
  
  @Override
  public int update(MemberVO memberVO) {
    int count = mybatis.update("member.update", memberVO);
    return count;
  }

  @Override
  public int passwd_check(HashMap<String, Object> hashMap) {
    int count = mybatis.selectOne("member.passwd_check", hashMap);
    return count;
  }

  @Override
  public int passwd_update(MemberVO memberVO) {
    int count = mybatis.update("member.passwd_update", memberVO);
    return count;
  }  
    
  @Override
  public int delete(int mno) {
    int count = mybatis.delete("member.delete", mno);
    return count;
  }

  @Override
  public int login(Map map) {
    int count = mybatis.selectOne("member.login", map);
    return count;
  }
 
} 
 