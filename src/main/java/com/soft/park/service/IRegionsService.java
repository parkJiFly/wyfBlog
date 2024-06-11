package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.RegionsDTO;
import com.soft.park.entity.RegionsEntity;
import com.soft.park.vo.RegionsVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author  WenYaFei
 * @date  2024-06-11 16:16:43
 * @description 区域表(Regions)表服务接口
 */
public interface IRegionsService extends IService<RegionsEntity> {

    /**
     * 通过ID查询单条数据
     *
     * @param regionId 主键
     * @return 实例对象
     */
    RegionsDTO queryById(String regionId);

    /**
     * 分页查询
     *
     * @param regionsVO 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<RegionsDTO> queryByPage(RegionsVO regionsVO, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param regionsVO 实例对象
     * @return 实例对象
     */
    RegionsDTO insert(RegionsVO regionsVO);

    /**
     * 修改数据
     *
     * @param regionsVO 实例对象
     * @return 实例对象
     */
    RegionsDTO update(RegionsVO regionsVO);

    /**
     * 通过主键删除数据
     *
     * @param regionId 主键
     * @return 是否成功
     */
    boolean deleteById(String regionId);

    /**
     * 省市区树查询
     * @param regionsVO
     * @return
     */
    RegionsDTO queryList(RegionsVO regionsVO);

}
