package com.yupi.springbootinit.mapper;

import com.api.common.model.entity.InterfaceInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yupi.springbootinit.model.vo.InterfaceInfoVO;

import java.util.List;

/**
 * @author xuqin
 * @description 针对表【interface_info(接口信息)】的数据库操作Mapper
 * @createDate 2024-08-14 16:35:16
 * @Entity generator.domain.InterfaceInfo
 */
public interface InterfaceInfoMapper extends BaseMapper<InterfaceInfo> {

    List<InterfaceInfoVO> topList(int limit);
}




