package com.example.demo.service;

import com.example.demo.entity.TCustomer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户表(TCustomer)表服务接口
 *
 * @author makejava
 * @since 2021-10-09 10:48:24
 */
public interface TCustomerService {

    /**
     * 通过ID查询单条数据
     *
     * @param fcustomerid 主键
     * @return 实例对象
     */
    TCustomer queryById(String fcustomerid);

    /**
     * 分页查询
     *
     * @param tCustomer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<TCustomer> queryByPage(TCustomer tCustomer, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    TCustomer insert(TCustomer tCustomer);

    /**
     * 修改数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    TCustomer update(TCustomer tCustomer);

    /**
     * 通过主键删除数据
     *
     * @param fcustomerid 主键
     * @return 是否成功
     */
    boolean deleteById(String fcustomerid);

}
