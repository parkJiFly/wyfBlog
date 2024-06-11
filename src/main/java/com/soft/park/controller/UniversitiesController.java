package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IUniversitiesService;
import com.soft.park.vo.UniversitiesVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author  WenYaFei
 * @date  2024-06-11 17:24:03
 * @description 大学表(Universities)控制层
 */
@RestController
@RequestMapping("/universities")
public class UniversitiesController {
    /**
     * 服务对象
     */
    @Autowired
    private IUniversitiesService iUniversitiesService;

    /**
     * 分页查询
     *
     * @param universitiesVO 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("list-page")
    public Result queryByPage(UniversitiesVO universitiesVO, PageRequest pageRequest) {
        return Result.success(this.iUniversitiesService.queryByPage(universitiesVO, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/detail")
    public Result queryById(@RequestParam("id") Integer id) {
        return Result.success(this.iUniversitiesService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param universitiesVO 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result add(@RequestBody UniversitiesVO universitiesVO) {
        return Result.success(this.iUniversitiesService.insert(universitiesVO));
    }

    /**
     * 编辑数据
     *
     * @param universitiesVO 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public Result update(@RequestBody UniversitiesVO universitiesVO) {
        return Result.success(this.iUniversitiesService.update(universitiesVO));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/delete")
    public Result deleteById(Integer id) {
        return Result.success(this.iUniversitiesService.deleteById(id));
    }

}

