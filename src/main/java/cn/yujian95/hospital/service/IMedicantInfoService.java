package cn.yujian95.hospital.service;

import cn.yujian95.hospital.dto.param.MedicantInfoParam;
import cn.yujian95.hospital.entity.MedicantInfo;

import java.util.List;
import java.util.Optional;


public interface IMedicantInfoService {

    /**
     * 添加药物信息
     *
     * @param param 药物信息参数
     * @return 是否成功
     */
    boolean insert(MedicantInfoParam param);

    /**
     * 更新药物信息
     *
     * @param id    药物编号
     * @param param 药物信息参数
     * @return 是否成功
     */
    boolean update(Long id, MedicantInfoParam param);

    /**
     * 获取药物信息
     *
     * @param id 药物编号
     * @return 药物信息
     */
    Optional<MedicantInfo> getOptional(Long id);

    /**
     * 获取药物名称
     *
     * @param id 药物编号
     * @return 医院名称，否则返回未知
     */
    String getName(Long id);

    /**
     * 删除药物信息
     *
     * @param id 药物编号
     * @return 是否成功
     */
    boolean delete(Long id);

    /**
     * 判断药物信息是否存在
     *
     * @param id 药物编号
     * @return 是否存在
     */
    boolean count(Long id);

    /**
     * 判断电话是否存在
     *
     * @param phone 电话
     * @return 是否存在
     */
    boolean count(String phone);

    /**
     * 查找药物列表
     *
     * @param name     药物名称
     * @param pageNum  第几页
     * @param pageSize 页大小
     * @return 药物列表
     */
    List<MedicantInfo> list(String name, Integer pageNum, Integer pageSize);
}
