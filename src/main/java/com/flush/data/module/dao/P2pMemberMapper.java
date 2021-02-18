package com.flush.data.module.dao;

import com.flush.data.module.entity.P2pMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface P2pMemberMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(P2pMember record);

    int insertSelective(P2pMember record);

    P2pMember selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(P2pMember record);

    int updateByPrimaryKey(P2pMember record);

    P2pMember login(@Param("user") String user);
}