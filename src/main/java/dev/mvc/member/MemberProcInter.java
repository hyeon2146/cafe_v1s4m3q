package dev.mvc.member;

import java.util.List;

public interface MemberProcInter {
  /**
   * 중복 아이디 검사
   * @param id
   * @return 중복 아이디 갯수
   */
  public int checkId(String id);
  
  /**
   * 회원 등록
   * @param memberVO
   * @return 등록된 회원 수
   */
  public int create(MemberVO memberVO);
  
  /**
   * 회원 전체 목록
   * @return
   */
  public List<MemberVO> list();
  
  /**
   * 조회
   * <select id="read" resultType="MemberVO" parameterType="int"> 
   * @param mno
   * @return
   */
  public MemberVO read(int mno);
  
  /**
   * 조회
   * <select id="readById" resultType="MemberVO" parameterType="String"> 
   * @param id
   * @return
   */
  public MemberVO readById(String id);
  
  /**
   * 변경
   * <update id="update" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int update(MemberVO memberVO);
   
  /**
   * 패스워드 체크
   * <select id="passwd_check" resultType="int" parameterType="MemberVO">
   * @param memberVO
   * @return
   */
  public int passwd_check(MemberVO memberVO);
  
  /**
   * 패드워드 변경
   * <update id="passwd_update" parameterType="MemberVO">
   * @param memberVO
   */
  public int passwd_update(MemberVO memberVO);
  
  /**
   * 레코드 1건 삭제
   * <delete id="delete" parameterType="int">
   * @param mno 삭제할 회원 번호
   * @return 삭제된 레코드 갯수
   */
  public int delete(int mno);
  
  /**
   * 로그인 처리
   * <select id="login"  resultType="int" parameterType="Map">
   * @param id
   * @param passwd
   * @return
   */
  public int login(String id, String passwd);
}