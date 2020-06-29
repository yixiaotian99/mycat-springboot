package com.xiao.mycat.demo.controller;

import com.xiao.mycat.demo.entity.User;
import com.xiao.mycat.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TUser)表控制层
 *
 * @author makejava
 * @since 2020-06-29 11:03:08
 */
@Slf4j
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService tUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(Long id) {
        log.info("查询用户, id:{}", id);
        return this.tUserService.queryById(id);
    }


    /**
     * 查询所有用户
     *
     * @return
     */
    @GetMapping("selectAll")
    public List<User> selectOne() {
        log.info("查询所有用户");
        return this.tUserService.queryAllByLimit(0, 1000);
    }


}