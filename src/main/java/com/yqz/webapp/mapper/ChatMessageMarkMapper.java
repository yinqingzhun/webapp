package com.yqz.webapp.mapper;

import com.yqz.webapp.dto.ChatMessageMark;
import com.yqz.webapp.dto.ChatMessageMarkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChatMessageMarkMapper {
    int countByExample(ChatMessageMarkExample example);

    int deleteByExample(ChatMessageMarkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChatMessageMark record);

    int insertSelective(ChatMessageMark record);

    List<ChatMessageMark> selectByExample(ChatMessageMarkExample example);

    ChatMessageMark selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChatMessageMark record, @Param("example") ChatMessageMarkExample example);

    int updateByExample(@Param("record") ChatMessageMark record, @Param("example") ChatMessageMarkExample example);

    int updateByPrimaryKeySelective(ChatMessageMark record);

    int updateByPrimaryKey(ChatMessageMark record);
}