package com.soft.park.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.dto.UniversitiesDTO;
import com.soft.park.entity.UniversitiesEntity;
import com.soft.park.vo.UniversitiesVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * @version 1.0
 * @Author  WenYaFei
 * @date  2024-06-11 17:24:03
 * @description 大学表(Universities)表服务接口
 */
public interface IUniversitiesService extends IService<UniversitiesEntity> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UniversitiesDTO queryById(Integer id);

    /**
     * 分页查询
     *
     * @param universitiesVO 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UniversitiesDTO> queryByPage(UniversitiesVO universitiesVO, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param universitiesVO 实例对象
     * @return 实例对象
     */
    UniversitiesDTO insert(UniversitiesVO universitiesVO);

    /**
     * 修改数据
     *
     * @param universitiesVO 实例对象
     * @return 实例对象
     */
    UniversitiesDTO update(UniversitiesVO universitiesVO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
