package com.medical.platform.core.tk.mybatis;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author HeYu
 * @Description 自己的 Mapper
 *  * 特别注意，该接口不能被扫描到，否则会出错
 * @Date $ $
 * @Param $
 * @return $
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {

}
