package com.soft.park.controller;

import com.soft.park.result.Result;
import com.soft.park.service.IRegionsService;
import com.soft.park.vo.RegionsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author  WenYaFei
 * @date  2024-06-11 17:16:30
 * @description 区域表(Regions)控制层
 */
@RestController
@RequestMapping("/regions")
public class RegionsController {
    /**
     * 服务对象
     */
    @Autowired
    private IRegionsService iRegionsService;

    /**
     * 分页查询
     *
     * @param regionsVO 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping("list-page")
    public Result queryByPage(RegionsVO regionsVO, PageRequest pageRequest) {
        return Result.success(this.iRegionsService.queryByPage(regionsVO, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/detail")
    public Result queryById(@RequestParam("id") String id) {
        return Result.success(this.iRegionsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param regionsVO 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result add(@RequestBody RegionsVO regionsVO) {
        return Result.success(this.iRegionsService.insert(regionsVO));
    }

    /**
     * 编辑数据
     *
     * @param regionsVO 实体
     * @return 编辑结果
     */
    @PostMapping("/update")
    public Result update(@RequestBody RegionsVO regionsVO) {
        return Result.success(this.iRegionsService.update(regionsVO));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @GetMapping("/delete")
    public Result deleteById(String id) {
        return Result.success(this.iRegionsService.deleteById(id));
    }

}

