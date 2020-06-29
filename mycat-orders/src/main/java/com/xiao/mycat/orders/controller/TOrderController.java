package com.xiao.mycat.orders.controller;

import cn.hutool.json.JSONUtil;
import com.xiao.mycat.orders.entity.TOrder;
import com.xiao.mycat.orders.service.TOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TOrder)表控制层
 *
 * @author makejava
 * @since 2020-06-29 11:59:38
 */
@Slf4j
@RestController
@RequestMapping("order")
public class TOrderController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 服务对象
     */
    @Resource
    private TOrderService tOrderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TOrder selectOne(Long id) {
        return this.tOrderService.queryById(id);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("selectAll")
    public List<TOrder> selectAll() {
        return this.tOrderService.queryAllByLimit(0, 1000);
    }


    /**
     * 新增订单 使用分布式id生成策略
     *
     * @param name
     * @return
     */
    @GetMapping("insertOne")
    public TOrder selecinsertOnetOne(String name) {

        TOrder order = new TOrder();
        order.setCompanyId(1L);
        order.setName(name);

        //分布式全局id
        Long orderId = stringRedisTemplate.opsForValue().increment("order_id");
        order.setId(orderId);

        log.info("新增订单, order:{}", JSONUtil.toJsonStr(order));
        return this.tOrderService.insert(order);
    }
}