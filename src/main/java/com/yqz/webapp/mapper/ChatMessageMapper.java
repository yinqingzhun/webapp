package com.yqz.webapp.mapper;

import com.yqz.webapp.dto.ChatMessage;
import com.yqz.webapp.dto.ChatMessageDetailVO;
import com.yqz.webapp.dto.ChatMessageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ChatMessageMapper {
    int countByExample(ChatMessageExample example);

    int deleteByExample(ChatMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChatMessage record);

    int insertSelective(ChatMessage record);

    List<ChatMessage> selectByExample(ChatMessageExample example);

    ChatMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByExample(@Param("record") ChatMessage record, @Param("example") ChatMessageExample example);

    int updateByPrimaryKeySelective(ChatMessage record);

    int updateByPrimaryKey(ChatMessage record);
    
    List<ChatMessageDetailVO> getReceivedChatMessage(@Param("userId") int userId );
}