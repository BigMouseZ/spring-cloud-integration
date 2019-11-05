package com.springcloud.feignclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.feignclient.dto.OrderDto;
import com.springcloud.feignclient.dto.UserDto;
import com.springcloud.feignclient.service.OrderService;
import com.springcloud.feignclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiaomianyang
 * @description
 * @date 2019-07-20 12:07
 */

/**
 * @RestController // 设置默认的全局降级触发函数
 * @DefaultProperties(defaultFallback = "defaultFallback")
 * public class HystrixController {
 * <p>
 * //设置超时时间
 * @HystrixCommand(commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000"))
 * //为指定方法设置降级函数
 * //  @HystrixCommand(fallbackMethod = "fallback")
 * //服务断路器模式设置
 * //  @HystrixCommand(commandProperties = {
 * //设置断路器生效
 * //            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
 * //一个统计窗口内熔断触发的最小个数3/10s
 * //            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "3"),
 * //熔断5秒后去尝试请求
 * //            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000"),
 * //失败率达到30百分比后熔断
 * //            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "30"),})
 * //当配置文件设置参数之后，可以直接使用@HystrixCommand注解来使服务熔断生效
 * //  @HystrixCommand
 * @GetMapping(value = "productOrderlist")
 * public String getProductOrderList(@RequestParam Integer number) {
 * if (number % 2 == 0) {
 * return "success";
 * }
 * RestTemplate restTemplate = new RestTemplate();
 * //throw new RuntimeException("发送异常");
 * return restTemplate.postForObject("http://127.0.0.1:9080/product/listForOrder", Arrays.asList("157875196366160022"),String.class);
 * }
 * private String fallback() {
 * return "网络开小差了，请稍后重试···";
 * }
 * private String defaultFallback() {
 * return "defaultFallback: 网络开小差了，请稍后重试···";
 * }
 * }
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback") // 整个Controller默认的fallback
public class UserCenterController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * @param []
     * @return java.util.List<com.apgblogs.clouduser.dto.OrderDto>
     * @description 获取当前用户的订单列表
     * @author xiaomianyang
     * @date 2019-07-19 13:05
     */
    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500")// 指定fallback，指定超时时间，超时时间默认为1秒
    }, threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "30"),
            @HystrixProperty(name = "maxQueueSize", value = "101"),
            @HystrixProperty(name = "keepAliveTimeMinutes", value = "2"),
            @HystrixProperty(name = "queueSizeRejectionThreshold", value = "15"),
            @HystrixProperty(name = "metrics.rollingStats.numBuckets", value = "12"),
            @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "1440")
    })
    @GetMapping("userOrderList/{userId}")
    public Object getUserOrderList(@PathVariable String userId) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            List<OrderDto> orderDtoList = orderService.getUserOrderList(userId);
            UserDto userDto = userService.getUser(userId);
            resultMap.put("user", userDto);
            resultMap.put("orderList", orderDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }

    private Object error(String userId) {
        return "请求出错";
    }

    public String defaultFallback() {
        return "默认提示";
    }

    public String fallback(String userId) {
        return "请稍后重试:"+userId;
    }
}
