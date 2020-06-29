package com.xiao.mycat.demo.controller;

import cn.hutool.json.JSONUtil;
import com.xiao.mycat.demo.entity.Dict;
import com.xiao.mycat.demo.service.DictService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TDict)表控制层
 *
 * @author makejava
 * @since 2020-06-29 11:30:24
 */
@Slf4j
@RestController
@RequestMapping("dict")
public class DictController {
    /**
     * 服务对象
     */
    @Resource
    private DictService tDictService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Dict selectOne(Long id) {
        return this.tDictService.queryById(id);
    }


    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping("selectAll")
    public List<Dict> selectAll() {
        return this.tDictService.queryAllByLimit(0, 1000);
    }


    /**
     * 插入一个元素，并且返回 id=1 的元素，测试读写分离
     *
     * @param name
     * @return
     */
    @GetMapping("insertOne")
    public Dict insertOne(String name) {

        Dict dict = new Dict();
        dict.setName(name);
        Dict insert = this.tDictService.insert(dict);
        log.info("插入元素, insert:{}", JSONUtil.toJsonStr(insert));

        return this.tDictService.queryById(1L);
    }

    @GetMapping("insertOne2")
    public Dict insertOne2(String name) {

        Dict dict = new Dict();
        dict.setName(name);
        return this.tDictService.insertReturnId1(dict);
    }
}

