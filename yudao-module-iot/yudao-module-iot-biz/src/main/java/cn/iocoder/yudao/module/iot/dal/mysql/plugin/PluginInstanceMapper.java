package cn.iocoder.yudao.module.iot.dal.mysql.plugin;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.iot.controller.admin.plugin.vo.instance.PluginInstancePageReqVO;
import cn.iocoder.yudao.module.iot.dal.dataobject.plugin.PluginInstanceDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * IoT 插件实例 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface PluginInstanceMapper extends BaseMapperX<PluginInstanceDO> {

    default PluginInstanceDO selectByMainIdAndPluginId(String mainId, Long pluginId) {
        return selectOne(new LambdaQueryWrapperX<PluginInstanceDO>()
                .eq(PluginInstanceDO::getMainId, mainId)
                .eq(PluginInstanceDO::getPluginId, pluginId));
    }

    // TODO @haohao：这个还需要么？相关不用的 VO 可以删除
    default PageResult<PluginInstanceDO> selectPage(PluginInstancePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PluginInstanceDO>()
                .eqIfPresent(PluginInstanceDO::getMainId, reqVO.getMainId())
                .eqIfPresent(PluginInstanceDO::getPluginId, reqVO.getPluginId())
                .eqIfPresent(PluginInstanceDO::getIp, reqVO.getIp())
                .eqIfPresent(PluginInstanceDO::getPort, reqVO.getPort())
                .eqIfPresent(PluginInstanceDO::getHeartbeatAt, reqVO.getHeartbeatAt())
                .betweenIfPresent(PluginInstanceDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(PluginInstanceDO::getId));
    }

}