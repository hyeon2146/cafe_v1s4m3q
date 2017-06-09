package dev.mvc.pay;

import java.util.List;

public interface PayProcInter {
  /**
   * 등록
   * <insert id="create" parameterType="PayVO">
      INSERT INTO pay(mno, mycardno, tel, zipcode, address1, address2, total, rdate)
      VALUES(#{mno}, #{mycardno}, #{tel}, #{zipcode}, #{address1}, #{address1}, #{total}, now())
    </insert>
   * @param payVO
   * @return 
   */
  public int create(PayVO payVO);
  
  /**
   * 회원별 조회
   *<select id="list" resultType="PayVO" parameterType="int">
    SELECT payno, mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
    FROM pay
    WHERE mno = #{mno}
    ORDER BY payno ASC
    </select>
   * @return List<PayVO>
   */
  public List<PayVO> list(int mno);
  
  /**
   * 전체 조회
   *<select id="list_all" resultType="PayVO">
    SELECT payno, mno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
    FROM pay
    ORDER BY payno ASC
    </select>
   * @return
   */
  public List<PayVO> list_all();
  
  /**
   * 삭제
   *<delete id="delete" parameterType="int">
    DELETE FROM pay
    WHERE payno=#{payno}
    </delete> 
   * @param payno
   * @return
   */
   public int delete(int payno);


   /**
    * 조회
    *<select id="read" resultType="PayVO">
     SELECT payno, mycardno, rname, tel, zipcode, address1, address2, total, rdate
     FROM pay
     WHERE payno = #{payno}
     ORDER BY payno ASC
     </select>
    * @param payno
    * @return
    */
   public PayVO read(int payno);
   
   /**
    * 수정
    *<update id="update" parameterType="PayVO">
     UPDATE pay
     SET mycardno = #{mycardno}, rname = #{rname}, tel = #{tel}, zipcode = #{zipcode}, address1 = #{address1}, address2 = #{address2}, total = #{total}
     WHERE payno = #{payno}
     </update>    
    * @param payVO
    * @return
    */
   public int update(PayVO payVO);
}
