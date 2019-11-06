package com.springcloud.springcloudgood.controller;

import com.springcloud.springcloudgood.entity.CGoodEntity;
import com.springcloud.springcloudgood.service.GoodServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhangGang
 * @description
 * @date 2019-07-04 12:08
 */
@RestController
@RequestMapping("good")
public class GoodController {
    
    @Autowired
    private GoodServiceImpl goodService;
    
    /**
     * @description 查询商品
     * @author ZhangGang
     * @date 2019-07-04 12:16
     * @param [id]
     * @return com.apgblogs.cloudgood.entity.CGoodEntity
     */
    @GetMapping("{id}")
    public CGoodEntity getGood(@PathVariable String id){

        return goodService.getGood(id);
    }
    
    /**
     * @description 保存商品
     * @author ZhangGang
     * @date 2019-07-04 12:11
     * @param [cGoodEntity]
     * @return com.apgblogs.cloudgood.entity.CGoodEntity
     */
    @PostMapping
    public CGoodEntity saveGood(@RequestBody CGoodEntity cGoodEntity){
        return goodService.saveGood(cGoodEntity);
    }
}
