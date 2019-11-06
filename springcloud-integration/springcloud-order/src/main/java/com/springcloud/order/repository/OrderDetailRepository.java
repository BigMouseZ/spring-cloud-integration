package com.springcloud.order.repository;

import com.springcloud.order.entity.COrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhangGang
 * @description
 * @date 2019-07-03 11:38
 */
public interface OrderDetailRepository extends JpaRepository<COrderDetailEntity,String> {
}
