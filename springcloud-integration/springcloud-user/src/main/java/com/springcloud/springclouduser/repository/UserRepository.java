package com.springcloud.springclouduser.repository;

import com.springcloud.springclouduser.entity.CUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xiaomianyang
 * @description
 * @date 2019-07-02 20:12
 */
public interface UserRepository extends JpaRepository<CUserEntity,String> {
}
