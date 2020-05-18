package co.xingguo.travelmanage.mapper;

import co.xingguo.travelmanage.model.Reservation;
import co.xingguo.travelmanage.model.ReservationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ReservationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    long countByExample(ReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int deleteByExample(ReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int insert(Reservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int insertSelective(Reservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    List<Reservation> selectByExampleWithRowbounds(ReservationExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    List<Reservation> selectByExample(ReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    Reservation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") Reservation record, @Param("example") ReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByExample(@Param("record") Reservation record, @Param("example") ReservationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByPrimaryKeySelective(Reservation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table RESERVATION
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByPrimaryKey(Reservation record);
}