package com.springcloud.order.service;

import com.springcloud.order.entity.COrderEntity;
import com.springcloud.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ZhangGang
 * @description
 * @date 2019-07-03 11:38
 */
@Service
public class OrderServiceImpl {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * @description 通过订单Id获取订单
     * @author ZhangGang
     * @date 2019-07-03 12:32
     * @param [id]
     * @return com.apgblogs.cloudorder.entity.COrderEntity
     */
    public COrderEntity getOrder(String id){
        if(!orderRepository.existsById(id)){
            return null;
        }
        return orderRepository.findById(id).get();
    }

    /**
     * @description 保存订单
     * @author ZhangGang
     * @date 2019-07-03 12:33
     * @param [orderEntity]
     * @return com.apgblogs.cloudorder.entity.COrderEntity
     */
    public COrderEntity saveOrder(COrderEntity COrderEntity){
        COrderEntity.setOrderNo(String.valueOf(System.currentTimeMillis()));
        return orderRepository.save(COrderEntity);
    }

    /**
     * @description 获取用户下的订单
     * @author ZhangGang
     * @date 2019-07-19 12:09
     * @param [userId]
     * @return java.util.List<com.apgblogs.cloudorder.entity.COrderEntity>
     */
    public List<COrderEntity> getOrderListByUser(String userId){
        return orderRepository.findByCreateByOrderByCreateDate(userId);
    }

}
