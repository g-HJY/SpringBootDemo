package com.example.demo.dao;

import com.example.demo.entity.TCustomer;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户表(TCustomer)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-09 10:48:23
 */
public interface TCustomerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param fcustomerid 主键
     * @return 实例对象
     */
    TCustomer queryById(String fcustomerid);

    /**
     * 查询指定行数据
     *
     * @param tCustomer 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<TCustomer> queryAllByLimit(TCustomer tCustomer, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tCustomer 查询条件
     * @return 总行数
     */
    long count(TCustomer tCustomer);

    /**
     * 新增数据
     *
     * @param tCustomer 实例对象
     * @return 影响行数
     */
    int insert(TCustomer tCustomer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCustomer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TCustomer> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCustomer> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<TCustomer> entities);

    /**
     * 修改数据
     *
     * @param tCustomer 实例对象
     * @return 影响行数
     */
    int update(TCustomer tCustomer);

    /**
     * 通过主键删除数据
     *
     * @param fcustomerid 主键
     * @return 影响行数
     */
    int deleteById(String fcustomerid);

}

