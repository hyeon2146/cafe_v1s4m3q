package dev.mvc.mycard;

import java.util.List;

public interface MycardProcInter {

  /**
   * 등록
   *<insert id="create" parameterType="MycardVO">
    INSERT INTO mycard(mno, cname, money, rdate, mdate)
    VALUES(#{mno}, #{cname}, #{money}, now(), now())
    </insert>
   * @param mycardVO
   * @return
   */
  public int create(MycardVO mycardVO);
  
  /**
   * 회원별 목록
   *<select id="list" resultType="MycardVO" parameterType="int">
    SELECT mycardno, mno, cname, money, rdate, mdate
    FROM mycard
    WHERE mno = #{mno}
    ORDER BY mycardno ASC
    </select>
   * @param mno
   * @return
   */
  public List<MycardVO> list(int mno);


  /**
   * 전체 목록
   *<select id="list_all" resultType="MycardVO">
    SELECT mycardno, mno, cname, money, rdate, mdate
    FROM mycard
    ORDER BY mycardno ASC
    </select>
   * @return
   */
  public List<MycardVO> list_all ();
 

  /**
   * 삭제
   * <delete id="delete" parameterType="int">
    DELETE FROM mycard
    WHERE mycardno=#{mycardno}
    </delete> 
   * @param mycardno
   * @return
   */
  public int delete (int mycardno);


  /**
   * 조회
   *<select id="read" resultType="MycardVO">
    SELECT mycardno, mno, cname, money, rdate, mdate
    FROM mycard
    WHERE mycardno = #{mycardno}
    ORDER BY mycardno ASC
    </select>
   * @param mycardno
   * @return
   */
  public MycardVO read(int mycardno);

  /**
   * 이름 수정
   *<update id="update" parameterType="MycardVO">
    UPDATE mycard
    SET cname=#{cname}
    WHERE mycardno = #{mycardno}
    </update>   
   * @param mycardVO
   * @return
   */
  public int update (MycardVO mycardVO);
  
  /**
   * 잔액 수정
   *<update id="update_money" parameterType="MycardVO">
    UPDATE mycard
    SET money = #{cname}, mdate=now()
    WHERE mycardno = 1;
    </update>
   * @param mycardVO
   * @return
   */
  public int update_money (MycardVO mycardVO);
}
