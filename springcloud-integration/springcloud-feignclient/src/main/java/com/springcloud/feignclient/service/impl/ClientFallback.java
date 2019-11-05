package com.springcloud.feignclient.service.impl;

import com.springcloud.feignclient.dto.UserDto;
import com.springcloud.feignclient.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ClientFallback implements UserService {
    @Override
    public UserDto getUser(String id) {
        UserDto userDto = new UserDto();
        userDto.setNickName("调用Client1服务超时，调用方法findById（id）-根据id查询所有记录"+id);
        System.out.println("超时调用！");
        return userDto;
    }
}
