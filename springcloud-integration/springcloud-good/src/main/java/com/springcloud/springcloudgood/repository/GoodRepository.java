package com.springcloud.springcloudgood.repository;

import com.springcloud.springcloudgood.entity.CGoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ZhangGang
 * @description
 * @date 2019-07-04 12:05
 */
public interface GoodRepository extends JpaRepository<CGoodEntity,String> {
}
