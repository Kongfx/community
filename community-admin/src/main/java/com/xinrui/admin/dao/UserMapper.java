package com.xinrui.admin.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.xinrui.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * User basic infomation Mapper 接口
 * </p>
 *
 * @author kongfx
 * @since 2019-04-28
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

	User selectUserAndRolesByName(String username);
}
