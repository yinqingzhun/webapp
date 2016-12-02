package com.yqz.webapp.mapper;

import com.yqz.webapp.dto.Owner;

public interface OwnerMapper {
    int deleteByPrimaryKey(Integer ownerId);

    int insert(Owner record);

    int insertSelective(Owner record);

    Owner selectByPrimaryKey(Integer ownerId);

    int updateByPrimaryKeySelective(Owner record);

    int updateByPrimaryKey(Owner record);
}