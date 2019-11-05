package com.springcloud.springclouduser.service;

import com.springcloud.springclouduser.entity.CUserEntity;
import com.springcloud.springclouduser.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author xiaomianyang
 * @description
 * @date 2019-07-02 20:15
 */
@Service
public class UserServiceImpl {
    
    @Autowired
    private UserRepository userRepository;
    
    /**
     * @description 通过用户Id获取用户
     * @author xiaomianyang
     * @date 2019-07-02 20:16
     * @param [id]
     * @return com.apgblogs.clouduser.entity.CUserEntity
     */
    public CUserEntity getUser(String id){
        if(!userRepository.existsById(id)){
            return null;
        }
        return userRepository.findById(id).get();
    }
    
    /**
     * @description 保存用户
     * @author xiaomianyang
     * @date 2019-07-02 20:19
     * @param [userEntity]
     * @return com.apgblogs.clouduser.entity.CUserEntity
     */
    public CUserEntity saveUser(CUserEntity CUserEntity){
        if(StringUtils.isEmpty(CUserEntity)){
            return null;
        }
        CUserEntity.setCreateBy("sys");
        CUserEntity.setUpdateBy("sys");
        return userRepository.save(CUserEntity);
    }
}
