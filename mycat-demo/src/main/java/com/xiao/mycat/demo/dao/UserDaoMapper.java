package com.xiao.mycat.demo.dao;

import com.xiao.mycat.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-29 11:03:08
 */
public interface UserDaoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    User queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tUser 实例对象
     * @return 对象列表
     */
    List<User> queryAll(User tUser);

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 影响行数
     */
    int insert(User tUser);

    /**
     * 修改数据
     *
     * @param tUser 实例对象
     * @return 影响行数
     */
    int update(User tUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}