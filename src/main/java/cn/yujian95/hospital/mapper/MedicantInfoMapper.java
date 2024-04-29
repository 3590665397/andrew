package cn.yujian95.hospital.mapper;

import cn.yujian95.hospital.entity.MedicantInfo;
import cn.yujian95.hospital.entity.MedicantInfoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MedicantInfoMapper {
    long countByExample(MedicantInfoExample example);

    int deleteByExample(MedicantInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MedicantInfo record);

    int insertSelective(MedicantInfo record);

    List<MedicantInfo> selectByExample(MedicantInfoExample example);

    MedicantInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MedicantInfo record, @Param("example") MedicantInfoExample example);

    int updateByExample(@Param("record") MedicantInfo record, @Param("example") MedicantInfoExample example);

    int updateByPrimaryKeySelective(MedicantInfo record);

    int updateByPrimaryKey(MedicantInfo record);
}