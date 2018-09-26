package com.wx.dev.dao;

import com.wx.dev.entity.TblMulitData;
import com.wx.dev.entity.TblMulitDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblMulitDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int countByExample(TblMulitDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int deleteByExample(TblMulitDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int insert(TblMulitData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int insertSelective(TblMulitData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    List<TblMulitData> selectByExample(TblMulitDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    TblMulitData selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int updateByExampleSelective(@Param("record") TblMulitData record, @Param("example") TblMulitDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int updateByExample(@Param("record") TblMulitData record, @Param("example") TblMulitDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int updateByPrimaryKeySelective(TblMulitData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tbl_mulit_data
     *
     * @mbggenerated Tue Dec 13 15:57:28 CST 2016
     */
    int updateByPrimaryKey(TblMulitData record);
}