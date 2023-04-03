package pub.codex.db.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import pub.codex.db.usercenter.mapper.UserMapper;
import pub.codex.entity.usercenter.entity.UserEntity;
import pub.codex.db.usercenter.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {




}
