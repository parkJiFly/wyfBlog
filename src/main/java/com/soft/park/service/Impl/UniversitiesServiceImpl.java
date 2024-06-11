package com.soft.park.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft.park.dto.UniversitiesDTO;
import com.soft.park.entity.UniversitiesEntity;
import com.soft.park.mapper.UniversitiesMapper;
import com.soft.park.service.IUniversitiesService;
import com.soft.park.utils.BeanUtil;
import com.soft.park.vo.UniversitiesVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author  WenYaFei
 * @date  2024-06-11 17:24:03
 * @description 大学表(Universities)表服务实现类
 */
@Service
@Slf4j
public class UniversitiesServiceImpl extends ServiceImpl<UniversitiesMapper,UniversitiesEntity> implements IUniversitiesService {
    @Autowired
    private UniversitiesMapper universitiesMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UniversitiesDTO queryById(Integer id) {
        UniversitiesEntity universitiesEntity  = this.universitiesMapper.queryById(id);
		return BeanUtil.copy(universitiesEntity, UniversitiesDTO.class);
    }

    /**
     * 分页查询
     *
     * @param universitiesVO 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<UniversitiesDTO> queryByPage(UniversitiesVO universitiesVO, PageRequest pageRequest) {
        long total = this.universitiesMapper.count(universitiesVO);
        List<UniversitiesEntity> universitiesEntityS = this.universitiesMapper.queryAllByLimit(universitiesVO,pageRequest);
        List<UniversitiesDTO> universitiesDTOS = BeanUtil.copyToList(universitiesEntityS, UniversitiesDTO.class);
        return new PageImpl<>(universitiesDTOS, pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param universitiesVO 实例对象
     * @return 实例对象
     */
    @Override
    public UniversitiesDTO insert(UniversitiesVO universitiesVO) {
        UniversitiesEntity universitiesEntity = BeanUtil.copy(universitiesVO, UniversitiesEntity.class);
        this.universitiesMapper.insert(universitiesEntity);
        return BeanUtil.copy(universitiesEntity, UniversitiesDTO.class);
    }

    /**
     * 修改数据
     *
     * @param universitiesVO 实例对象
     * @return 实例对象
     */
    @Override
    public UniversitiesDTO update(UniversitiesVO universitiesVO) {  
        UniversitiesEntity universitiesEntity = BeanUtil.copy(universitiesVO, UniversitiesEntity.class);
        this.universitiesMapper.update(universitiesEntity);
        return this.queryById(universitiesVO.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.universitiesMapper.deleteById(id) > 0;
    }
}
