package com.springcloud.springclouduser.controller;

import com.springcloud.springclouduser.entity.CUserEntity;
import com.springcloud.springclouduser.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaomianyang
 * @description
 * @date 2019-07-02 20:13
 */
@RestController
@RefreshScope
public class UserController {

    @Value("${envName}")
    private String envName;
    
    @Autowired
    private UserServiceImpl userService;

    /**
     * @description 环境配置获取
     * @author xiaomianyang
     * @date 2019-09-20 14:28
     * @param []
     * @return java.lang.String
     */
    @GetMapping("getEnvName")
    public String getEnvName(){
        return envName;
    }
    
    /**
     * @description 获取用户
     * @author xiaomianyang
     * @date 2019-07-02 20:17
     * @param [id]
     * @return com.apgblogs.clouduser.entity.CUserEntity
     */
    @GetMapping("{id}")
    public CUserEntity getUser(@PathVariable String id) throws Exception{
        Thread.sleep(1200);
//        int c=2/0;
        return userService.getUser(id);
    }
    
    /**
     * @description 保存用户
     * @author xiaomianyang
     * @date 2019-07-02 20:20
     * @param [userEntity]
     * @return com.apgblogs.clouduser.entity.CUserEntity
     */
    @PostMapping
    public CUserEntity saveUser(@RequestBody CUserEntity CUserEntity){
        return userService.saveUser(CUserEntity);
    }
}
