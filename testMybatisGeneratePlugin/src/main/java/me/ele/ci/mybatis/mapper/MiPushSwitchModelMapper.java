package me.ele.ci.mybatis.mapper;

import java.util.List;
import me.ele.ci.mybatis.model.MiPushSwitchModel;
import me.ele.ci.mybatis.model.MiPushSwitchModelCriteria;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface MiPushSwitchModelMapper extends Mapper<MiPushSwitchModel> {
    int countByExample(MiPushSwitchModelCriteria example);

    int deleteByExample(MiPushSwitchModelCriteria example);

    List<MiPushSwitchModel> selectByExample(MiPushSwitchModelCriteria example);

    int updateByExampleSelective(@Param("record") MiPushSwitchModel record, @Param("example") MiPushSwitchModelCriteria example);

    int updateByExample(@Param("record") MiPushSwitchModel record, @Param("example") MiPushSwitchModelCriteria example);
}