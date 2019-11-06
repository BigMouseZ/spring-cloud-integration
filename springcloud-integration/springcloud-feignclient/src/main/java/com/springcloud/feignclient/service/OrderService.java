package com.springcloud.feignclient.service;

import com.springcloud.feignclient.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author ZhangGang
 * @description
 * @date 2019-07-19 11:32
 */
@FeignClient(name="cloud-order")
public interface OrderService {

    /**
     * @description 获取用户订单列表
     * @author ZhangGang
     * @date 2019-07-19 12:26
     * @param [userId]
     * @return java.util.List<com.apgblogs.clouduser.dto.OrderDto>
     */
    @GetMapping("order/userOrderList/{userId}")
    List<OrderDto> getUserOrderList(@PathVariable String userId);
}
