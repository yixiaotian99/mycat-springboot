package com.xiao.mycat.demo.service;

import com.xiao.mycat.demo.entity.Dict;
import java.util.List;

/**
 * (TDict)表服务接口
 *
 * @author makejava
 * @since 2020-06-29 11:30:24
 */
public interface DictService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Dict queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Dict> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tDict 实例对象
     * @return 实例对象
     */
    Dict insert(Dict tDict);

    /**
     * 修改数据
     *
     * @param tDict 实例对象
     * @return 实例对象
     */
    Dict update(Dict tDict);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    Dict insertReturnId1(Dict tDict);
}