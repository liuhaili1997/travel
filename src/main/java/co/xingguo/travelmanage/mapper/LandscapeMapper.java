package co.xingguo.travelmanage.mapper;

import co.xingguo.travelmanage.model.Landscape;
import co.xingguo.travelmanage.model.LandscapeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface LandscapeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    long countByExample(LandscapeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int deleteByExample(LandscapeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int insert(Landscape record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int insertSelective(Landscape record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    List<Landscape> selectByExampleWithBLOBsWithRowbounds(LandscapeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    List<Landscape> selectByExampleWithBLOBs(LandscapeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    List<Landscape> selectByExampleWithRowbounds(LandscapeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    List<Landscape> selectByExample(LandscapeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    Landscape selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") Landscape record, @Param("example") LandscapeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Landscape record, @Param("example") LandscapeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByExample(@Param("record") Landscape record, @Param("example") LandscapeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByPrimaryKeySelective(Landscape record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Landscape record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table LANDSCAPE
     *
     * @mbg.generated Sun May 17 14:18:19 CST 2020
     */
    int updateByPrimaryKey(Landscape record);
}