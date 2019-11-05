package com.springcloud.feignclient.service;

import com.springcloud.feignclient.dto.UserDto;
import com.springcloud.feignclient.service.impl.ClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xiaomianyang
 * @description
 * @date 2019-07-20 15:26
 */
@FeignClient(name="cloud-user",fallback = ClientFallback.class)
public interface UserService {

    @GetMapping("{id}")
    UserDto getUser(@PathVariable String id);
}
