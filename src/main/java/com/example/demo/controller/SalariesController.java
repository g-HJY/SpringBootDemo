package com.example.demo.controller;

import com.example.demo.entity.test2.Salaries;
import com.example.demo.service.SalariesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Salaries)表控制层
 *
 * @author makejava
 * @since 2021-12-20 09:55:29
 */
@RestController
@RequestMapping("/salaries")
public class SalariesController {
    /**
     * 服务对象
     */
    @Resource
    private SalariesService salariesService;

    /**
     * 分页查询
     *
     * @param salaries 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Salaries>> queryByPage(Salaries salaries, PageRequest pageRequest) {
        return ResponseEntity.ok(this.salariesService.queryByPage(salaries, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/queryById")
    public ResponseEntity<Salaries> queryById(int id) {
        return ResponseEntity.ok(this.salariesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param salaries 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Salaries> add(Salaries salaries) {
        return ResponseEntity.ok(this.salariesService.insert(salaries));
    }

    /**
     * 编辑数据
     *
     * @param salaries 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Salaries> edit(Salaries salaries) {
        return ResponseEntity.ok(this.salariesService.update(salaries));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(int id) {
        return ResponseEntity.ok(this.salariesService.deleteById(id));
    }

}

