package com.property.dao;

import org.apache.ibatis.annotations.Insert;

import com.property.model.GZSecondHouseInfo;

/**
 * 
 * @author Administrator
 *
 */
public interface GZSecondHouseDAO {

    @Insert("insert into gz_second_house (`property`,`area`,`section`,`address`,`layout`,`price`,`average_price`,`contact`,`identity`,`phone`,`website`) values (#{property},#{area},#{section},#{address},#{layout},#{price},#{average_price},#{contact},#{identity},#{phone},#{website})")
    public int add(GZSecondHouseInfo gZSecondHouseInfo);
}
