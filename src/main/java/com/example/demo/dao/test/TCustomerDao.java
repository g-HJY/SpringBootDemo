package com.example.demo.dao.test;

import com.example.demo.entity.test.Customer;
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
    Customer queryById(String fcustomerid);

    /**
     * 查询指定行数据
     *
     * @param tCustomer 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Customer> queryAllByLimit(Customer tCustomer, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tCustomer 查询条件
     * @return 总行数
     */
    long count(Customer tCustomer);

    /**
     * 新增数据
     *
     * @param tCustomer 实例对象
     * @return 影响行数
     */
    int insert(Customer tCustomer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCustomer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Customer> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TCustomer> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Customer> entities);

    /**
     * 修改数据
     *
     * @param tCustomer 实例对象
     * @return 影响行数
     */
    int update(Customer tCustomer);

    /**
     * 通过主键删除数据
     *
     * @param fcustomerid 主键
     * @return 影响行数
     */
    int deleteById(String fcustomerid);

}

