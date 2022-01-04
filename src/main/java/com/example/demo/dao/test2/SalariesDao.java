package com.example.demo.dao.test2;

import com.example.demo.entity.test2.Salaries;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Salaries)表数据库访问层
 *
 * @author makejava
 * @since 2021-12-20 09:55:29
 */
public interface SalariesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  id 主键
     * @return 实例对象
     */
    Salaries queryById(int id);

    /**
     * 查询指定行数据
     *
     * @param salaries 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Salaries> queryAllByLimit(Salaries salaries, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param salaries 查询条件
     * @return 总行数
     */
    long count(Salaries salaries);

    /**
     * 新增数据
     *
     * @param salaries 实例对象
     * @return 影响行数
     */
    int insert(Salaries salaries);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Salaries> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Salaries> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Salaries> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Salaries> entities);

    /**
     * 修改数据
     *
     * @param salaries 实例对象
     * @return 影响行数
     */
    int update(Salaries salaries);

    /**
     * 通过主键删除数据
     *
     * @param  id 主键
     * @return 影响行数
     */
    int deleteById(int id);

}

