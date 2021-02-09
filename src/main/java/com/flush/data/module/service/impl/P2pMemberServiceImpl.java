package com.flush.data.module.service.impl;

import com.flush.data.module.dao.P2pMemberMapper;
import com.flush.data.module.entity.P2pMember;
import com.flush.data.module.service.P2pMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * xxx
 */
@Service
public class P2pMemberServiceImpl implements P2pMemberService {

    //TODO required=false 参考：https://www.cnblogs.com/Howinfun/p/11731826.html
    @Autowired(required = false)
    private P2pMemberMapper p2pMemberMapper;

    @Override
    public P2pMember login(String user, String pass) {
        P2pMember p2pMember =  this.p2pMemberMapper.login(user);
        if(p2pMember != null){
            //TODO 判断密码是否一致
            return p2pMember;
        }else{
            return null;
        }
    }
}