package com.yj.sys.mapper;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface MapperUtil<T> extends Mapper<T>,MySqlMapper<T>,ConditionMapper<T>,IdsMapper<T> {
}
