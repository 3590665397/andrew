package cn.yujian95.hospital.service.impl;

import cn.yujian95.hospital.dto.param.MedicantInfoParam;
import cn.yujian95.hospital.entity.*;
import cn.yujian95.hospital.mapper.MedicantInfoMapper;
import cn.yujian95.hospital.service.IMedicantInfoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Optional;



@Service
public class
MedicantInfoServiceImpl implements IMedicantInfoService {

    @Resource
    private MedicantInfoMapper infoMapper;

    /**
     * 添加药物信息
     *
     * @param param 药物信息参数
     * @return 是否成功
     */
    @Override
    public boolean insert(MedicantInfoParam param) {
        MedicantInfo info = new MedicantInfo();

        BeanUtils.copyProperties(param, info);

        info.setGmtCreate(new Date());
        info.setGmtModified(new Date());

        return infoMapper.insertSelective(info) > 0;
    }

    /**
     * 更新药物信息
     *
     * @param id    药物编号
     * @param param 药物信息参数
     * @return 是否成功
     */
    @Override
    public boolean update(Long id, MedicantInfoParam param) {
        MedicantInfo info = new MedicantInfo();

        BeanUtils.copyProperties(param, info);

        info.setId(id);
        info.setGmtModified(new Date());

        return infoMapper.updateByPrimaryKeySelective(info) > 0;
    }

    /**
     * 获取药物名称
     *
     * @param id 药物编号
     * @return 药物名称，否则返回未知
     */
    @Override
    public String getName(Long id) {
        return getOptional(id).map(MedicantInfo::getName).orElse("未知");
    }

    /**
     * 获取药物信息
     *
     * @param id 药物编号
     * @return 药物信息
     */
    @Override
    public Optional<MedicantInfo> getOptional(Long id) {

        return Optional.ofNullable(infoMapper.selectByPrimaryKey(id));
    }

    /**
     * 删除数量信息
     *
     * @param id 药物编号
     * @return 是否成功
     */
    @Override
    public boolean delete(Long id) {
        return infoMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 判断数量是否存在
     *
     * @param number 数量
     * @return 是否存在
     */
    @Override
    public boolean count(String number) {
        MedicantInfoExample example = new MedicantInfoExample();

        example.createCriteria()
                .andnumberEqualTo(number);

        return infoMapper.countByExample(example) > 0;
    }

    /**
     * 判断药物信息是否存在
     *
     * @param id 药物编号
     * @return 是否存在
     */
    @Override
    public boolean count(Long id) {
        MedicantInfoExample example = new MedicantInfoExample();

        example.createCriteria()
                .andIdEqualTo(id);

        return infoMapper.countByExample(example) > 0;
    }

    /**
     * 查找药物列表
     *
     * @param name     药物名称
     * @param pageNum  第几页
     * @param pageSize 页大小
     * @return 药物列表
     */
    @Override
    public List<MedicantInfo> list(String name, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        MedicantInfoExample example = new MedicantInfoExample();

        if (!StringUtils.isEmpty(name)) {
            example.createCriteria()
                    .andNameLike("%" + name + "%");

        }

        return infoMapper.selectByExample(example);
    }
}
