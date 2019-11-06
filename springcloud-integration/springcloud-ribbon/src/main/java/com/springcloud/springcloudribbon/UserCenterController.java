package com.springcloud.springcloudribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhangGang
 * @description
 * @date 2019-07-20 12:07
 */

@RestController
public class UserCenterController {
    /**
     * RestTemplate由SpringBoot web组件提供 默认整合ribbo负载均衡器
     * rest方式底层是采用httpClient技术
     */

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 订单服务调用会员服务:
     * 在springCloud当中，有两种方式调用生产的消息
     * 1.rest方式  2、fegin(SpringCloud方式)
     * @return
     */
    @GetMapping("getOrder")
    public String getOrderInfo() {

        //采用服务别名(生产者)+方法映射id:
        String url = "http://cloud-user/getEnvName";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("订单服务调用会员服务是_:"+result);
        return result;
    }
    /**
     * 订单服务调用会员服务:
     * 在springCloud当中，有两种方式调用生产的消息
     * 1.rest方式  2、fegin(SpringCloud方式)
     * @return
     */
    @PostMapping("saveOrder")
    public CUserEntity saveOrderInfo() {
        CUserEntity cUserEntity = new CUserEntity();
        cUserEntity.setNickName("cwe");
        //采用服务别名(生产者)+方法映射id:
        String url = "http://cloud-user/saveUser";
        ResponseEntity<CUserEntity> result = restTemplate.postForEntity(url,cUserEntity, CUserEntity.class);
//        CUserEntity cUserEntity1 =   restTemplate.postForObject(url,cUserEntity, CUserEntity.class);
        System.out.println("订单服务调用会员服务是_:"+result.getBody().toString());
        return result.getBody();
    }
}
