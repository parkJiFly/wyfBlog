package com.soft.park.service;

import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.soft.park.entity.FileInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024-07-03 10:32:49
 * @description 附件管理(FileInfo)表服务接口
 */
public interface IFileInfoService extends IService<FileInfoEntity> {

	Map<String, List<JSONObject>> scanFile() throws Exception;

}
