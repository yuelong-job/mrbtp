package com.zoneland.modules.system.service.impl;

import com.zoneland.modules.system.entity.User;
import com.zoneland.modules.system.mapper.UserMapper;
import com.zoneland.modules.system.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuelong
 * @since 2021-07-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
