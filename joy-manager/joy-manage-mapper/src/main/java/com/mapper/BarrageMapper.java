package com.mapper;

import com.pojo.Barrage;
import com.pojo.BarrageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BarrageMapper {
    int countByExample(BarrageExample example);

    int deleteByExample(BarrageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Barrage record);

    int insertSelective(Barrage record);

    List<Barrage> selectByExample(BarrageExample example);

    int updateByExampleSelective(@Param("record") Barrage record, @Param("example") BarrageExample example);

    int updateByExample(@Param("record") Barrage record, @Param("example") BarrageExample example);
}