package com.mapper;

import com.pojo.Muscovyplay;
import com.pojo.MuscovyplayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MuscovyplayMapper {
    int countByExample(MuscovyplayExample example);

    int deleteByExample(MuscovyplayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Muscovyplay record);

    int insertSelective(Muscovyplay record);

    List<Muscovyplay> selectByExample(MuscovyplayExample example);

    Muscovyplay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Muscovyplay record, @Param("example") MuscovyplayExample example);

    int updateByExample(@Param("record") Muscovyplay record, @Param("example") MuscovyplayExample example);

    int updateByPrimaryKeySelective(Muscovyplay record);

    int updateByPrimaryKey(Muscovyplay record);
}