package com.xiao.mycat.demo.service.impl;

import com.xiao.mycat.demo.entity.Dict;
import com.xiao.mycat.demo.dao.DictDaoMapper;
import com.xiao.mycat.demo.service.DictService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TDict)表服务实现类
 *
 * @author makejava
 * @since 2020-06-29 11:30:24
 */
@Service("tDictService")
public class DictServiceImpl implements DictService {
    @Resource
    private DictDaoMapper tDictDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Dict queryById(Long id) {
        return this.tDictDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Dict> queryAllByLimit(int offset, int limit) {
        return this.tDictDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tDict 实例对象
     * @return 实例对象
     */
    @Override
    public Dict insert(Dict tDict) {
        this.tDictDao.insert(tDict);
        return tDict;
    }

    /**
     * 修改数据
     *
     * @param tDict 实例对象
     * @return 实例对象
     */
    @Override
    public Dict update(Dict tDict) {
        this.tDictDao.update(tDict);
        return this.queryById(tDict.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.tDictDao.deleteById(id) > 0;
    }


    /**
     * 插入记录，并且返回 id=1 的记录， id=1的记录在从库中名称已经修改，与主库不同，测试读写分离
     * @param tDict
     * @return
     */
    @Override
    public Dict insertReturnId1(Dict tDict) {
        this.tDictDao.insert(tDict);

        return this.tDictDao.queryById(1L);
    }
}