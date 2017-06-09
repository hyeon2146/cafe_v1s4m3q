package dev.mvc.member;

import java.util.List;

public interface MemberProcInter {
  /**
   * �ߺ� ���̵� �˻�
   * @param id
   * @return �ߺ� ���̵� ����
   */
  public int checkId(String id);
  
  /**
   * ȸ�� ���
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
  public int passwd_check(MemberVO memberVO);
  
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
   * �α��� ó��
   * <select id="login"  resultType="int" parameterType="Map">
   * @param id
   * @param passwd
   * @return
   */
  public int login(String id, String passwd);
}