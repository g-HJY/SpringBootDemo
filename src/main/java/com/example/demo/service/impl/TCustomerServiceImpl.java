package com.example.demo.service.impl;

import com.example.demo.dao.TCustomerDao;
import com.example.demo.entity.TCustomer;
import com.example.demo.service.TCustomerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户表(TCustomer)表服务实现类
 *
 * @author makejava
 * @since 2021-10-09 10:48:24
 */
@Service("tCustomerService")
public class TCustomerServiceImpl implements TCustomerService {
    @Resource
    private TCustomerDao tCustomerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param fcustomerid 主键
     * @return 实例对象
     */
    @Override
    /**
     *  ★2、@Cacheable表示当前方法使用缓存，并存入redis数据库中
     *         key：指定方法执行返回值的key，该属性是Spring用的，不写也有默认值
     *         value:表示存入redis数据库的key
     */
    @Cacheable(value="findCustomerId", key="'account.findCustomerId'")
    public TCustomer queryById(String fcustomerid) {
        return this.tCustomerDao.queryById(fcustomerid);
    }

    /**
     * 分页查询
     *
     * @param tCustomer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<TCustomer> queryByPage(TCustomer tCustomer, PageRequest pageRequest) {
        long total = this.tCustomerDao.count(tCustomer);
        return new PageImpl<>(this.tCustomerDao.queryAllByLimit(tCustomer, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    @Override
    public TCustomer insert(TCustomer tCustomer) {
        this.tCustomerDao.insert(tCustomer);
        return tCustomer;
    }

    /**
     * 修改数据
     *
     * @param tCustomer 实例对象
     * @return 实例对象
     */
    @Override
    public TCustomer update(TCustomer tCustomer) {
        this.tCustomerDao.update(tCustomer);
        return this.queryById(tCustomer.getFcustomerid());
    }

    /**
     * 通过主键删除数据
     *
     * @param fcustomerid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String fcustomerid) {
        return this.tCustomerDao.deleteById(fcustomerid) > 0;
    }
}
