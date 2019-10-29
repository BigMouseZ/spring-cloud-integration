package com.springcloud.order.controller;

import com.springcloud.order.entity.COrderEntity;
import com.springcloud.order.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiaomianyang
 * @description
 * @date 2019-07-03 12:33
 */
@RestController
@RefreshScope
public class OrderController {

    @Value("${envName}")
    private String envName;
    
    @Autowired
    private OrderServiceImpl orderService;

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
     * @description 获取订单
     * @author xiaomianyang
     * @date 2019-07-03 12:34
     * @param [id]
     * @return com.apgblogs.cloudorder.entity.COrderEntity
     */
    @GetMapping("{id}")
    public COrderEntity getOrder(@PathVariable String id){
        return orderService.getOrder(id);
    }
    
    /**
     * @description 新增订单
     * @author xiaomianyang
     * @date 2019-07-03 13:09
     * @param [orderEntity]
     * @return com.apgblogs.cloudorder.entity.COrderEntity
     */
    @PostMapping
    public COrderEntity saveOrder(@RequestBody COrderEntity COrderEntity){
        return orderService.saveOrder(COrderEntity);
    }


    /**
     * @description 通过用户Id查询用户订单列表
     * @author xiaomianyang
     * @date 2019-07-19 12:09
     * @param [userId]
     * @return java.util.List<com.apgblogs.cloudorder.entity.COrderEntity>
     */
    @GetMapping("userOrderList/{userId}")
    public List<COrderEntity> getOrderListByUser(@PathVariable String userId){
        return orderService.getOrderListByUser(userId);
    }
}
