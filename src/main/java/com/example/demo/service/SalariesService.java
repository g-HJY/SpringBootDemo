package com.example.demo.service;
import com.example.demo.entity.test2.Salaries;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Salaries)表服务接口
 *
 * @author makejava
 * @since 2021-12-20 09:55:30
 */
public interface SalariesService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    Salaries queryById(int id);

    /**
     * 分页查询
     *
     * @param salaries 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Salaries> queryByPage(Salaries salaries, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param salaries 实例对象
     * @return 实例对象
     */
    Salaries insert(Salaries salaries);

    /**
     * 修改数据
     *
     * @param salaries 实例对象
     * @return 实例对象
     */
    Salaries update(Salaries salaries);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 是否成功
     */
    boolean deleteById(int id);

}
