package dev.mvc.buy;

public interface BuyProcInter {
  /**
   *<insert id="create" parameterType="BuyVO">
    INSERT INTO buy(payno, cartno, itemno, cnt, price, rdate)
    VALUES(#{payno}, #{cartno}, #{itemno}, #{cnt}, #{price}, now());
    </insert>
   * @param buyVO
   * @return
  */
  public int create (BuyVO buyVO);
  
}
