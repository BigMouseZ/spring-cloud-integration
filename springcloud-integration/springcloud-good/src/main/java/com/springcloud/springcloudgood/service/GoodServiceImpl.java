package com.springcloud.springcloudgood.service;

import com.springcloud.springcloudgood.entity.CGoodEntity;
import com.springcloud.springcloudgood.repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiaomianyang
 * @description
 * @date 2019-07-04 12:06
 */
@Service
public class GoodServiceImpl {
    
    @Autowired
    private GoodRepository goodRepository;
    
    /**
     * @description 查询商品
     * @author xiaomianyang
     * @date 2019-07-04 12:07
     * @param [id]
     * @return com.apgblogs.cloudgood.entity.CGoodEntity
     */
    public CGoodEntity getGood(String id){
        if(!goodRepository.existsById(id)){
            return null;
        }
        return goodRepository.findById(id).get();
    }

    /**
     * @description 保存商品
     * @author xiaomianyang
     * @date 2019-07-04 12:08
     * @param [cGoodEntity]
     * @return com.apgblogs.cloudgood.entity.CGoodEntity
     */
    public CGoodEntity saveGood(CGoodEntity cGoodEntity){
        return goodRepository.save(cGoodEntity);
    }
    
}
