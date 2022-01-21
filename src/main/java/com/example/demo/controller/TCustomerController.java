package com.example.demo.controller;

import com.example.demo.entity.test.Customer;
import com.example.demo.service.TCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户表(TCustomer)表控制层
 *
 * @author makejava
 * @since 2021-10-09 10:48:22
 */
@Api(tags = "用户信息相关接口")
@RestController
@RequestMapping("/customer")
public class TCustomerController {
    /**
     * 服务对象
     */
    @Resource
    private TCustomerService tCustomerService;

    /**
     * 分页查询
     *
     * @param tCustomer 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Customer>> queryByPage(Customer tCustomer, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tCustomerService.queryByPage(tCustomer, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    @ApiOperation(value = "根据用户id获取用户的信息",
            notes = "查询数据库中的记录",
            httpMethod = "GET",
            response = ResponseEntity.class)
    public ResponseEntity<Customer> queryById(String id) {
        return ResponseEntity.ok(this.tCustomerService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tCustomer 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Customer> add(Customer tCustomer) {
        return ResponseEntity.ok(this.tCustomerService.insert(tCustomer));
    }

    /**
     * 编辑数据
     *
     * @param tCustomer 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Customer> edit(Customer tCustomer) {
        return ResponseEntity.ok(this.tCustomerService.update(tCustomer));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(String id) {
        return ResponseEntity.ok(this.tCustomerService.deleteById(id));
    }

}

