package com.springcloud.order.repository;

import com.springcloud.order.entity.COrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ZhangGang
 * @description
 * @date 2019-07-03 11:37
 */
public interface OrderRepository extends JpaRepository<COrderEntity,String> {

    /**
     * @description 查询该用户的所有订单
     * @author ZhangGang
     * @date 2019-07-19 12:04
     * @param [createBy]
     * @return java.util.List<com.apgblogs.cloudorder.entity.COrderEntity>
     */
    List<COrderEntity> findByCreateByOrderByCreateDate(String createBy);
}
