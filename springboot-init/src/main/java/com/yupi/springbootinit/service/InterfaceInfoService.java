package com.yupi.springbootinit.service;

import com.api.common.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xuqin
 * @description 针对表【interface_info(接口信息)】的数据库操作Service
 * @createDate 2024-08-14 16:35:16
 */
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
