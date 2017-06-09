package dev.mvc.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface MemberDAOInter {
  /**
   * �ߺ� ���̵� �˻�
   *   <select id="checkId" resultType="int" parameterType="String">
   * @param id
   * @return �ߺ� ���̵� ����
   */
  public int checkId(String id);
  

  /**
   * ȸ�� ���
   * <insert id="create" parameterType="MemberVO">
   * @param memberVO
   * @return ��ϵ� ȸ�� ��
   */
  public int create(MemberVO memberVO);
  
  /**
   * ȸ�� ��ü ���
   * @return
   */
  public List<MemberVO> list();
  
  /**
   * ��ȸ
   * <select id="read" resultType="MemberVO" parameterType="int"> 
   * @param mno
   * @return
   */
  public MemberVO read(int mno);
  
  /**
   * ��ȸ
   * <select id="readById" resultType="MemberVO" parameterType="String"> 
   * @param id
   * @return
   */
  public MemberVO readById(String id);
  
  /**
   * ����
   * <update id="update" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int update(MemberVO memberVO);
  
  /**
   * �н����� üũ
   * <select id="passwd_check" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int passwd_check(HashMap<String, Object> hashMap);
  
  /**
   * �е���� ����
   * <update id="passwd_update" parameterType="MemberVO">
   * @param memberVO
   */
  public int passwd_update(MemberVO memberVO);
  
  /**
   * ���ڵ� 1�� ����
   * <delete id="delete" parameterType="int">
   * @param mno ������ ȸ�� ��ȣ
   * @return ������ ���ڵ� ����
   */
  public int delete(int mno);
  
  /**
   * �α��� 
   * <select id="login"  resultType="int"  parameterType="Map">
   * @param map
   * @return
   */
  public int login(Map map);
}
