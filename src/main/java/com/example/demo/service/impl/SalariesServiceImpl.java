package com.example.demo.service.impl;

import com.example.demo.dao.test2.SalariesDao;
import com.example.demo.entity.test2.Salaries;
import com.example.demo.service.SalariesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Salaries)表服务实现类
 *
 * @author makejava
 * @since 2021-12-20 09:55:30
 */
@Service("salariesService")
public class SalariesServiceImpl implements SalariesService {
    @Resource
    private SalariesDao salariesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param  id 主键
     * @return 实例对象
     */
    @Override
    public Salaries queryById(int id) {
        return this.salariesDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param salaries 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Salaries> queryByPage(Salaries salaries, PageRequest pageRequest) {
        long total = this.salariesDao.count(salaries);
        return new PageImpl<>(this.salariesDao.queryAllByLimit(salaries, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param salaries 实例对象
     * @return 实例对象
     */
    @Override
    public Salaries insert(Salaries salaries) {
        this.salariesDao.insert(salaries);
        return salaries;
    }

    /**
     * 修改数据
     *
     * @param salaries 实例对象
     * @return 实例对象
     */
    @Override
    public Salaries update(Salaries salaries) {
        this.salariesDao.update(salaries);
        return this.queryById(salaries.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param  id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(int id) {
        return this.salariesDao.deleteById(id) > 0;
    }
}
