package com.yqz.webapp.mapper;

import com.yqz.webapp.dto.Owner;
import com.yqz.webapp.dto.OwnerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OwnerMapper {
    int countByExample(OwnerExample example);

    int deleteByExample(OwnerExample example);

    int deleteByPrimaryKey(Integer owner_id);

    int insert(Owner record);

    int insertSelective(Owner record);

    List<Owner> selectByExample(OwnerExample example);

    Owner selectByPrimaryKey(Integer owner_id);

    int updateByExampleSelective(@Param("record") Owner record, @Param("example") OwnerExample example);

    int updateByExample(@Param("record") Owner record, @Param("example") OwnerExample example);

    int updateByPrimaryKeySelective(Owner record);

    int updateByPrimaryKey(Owner record);
}