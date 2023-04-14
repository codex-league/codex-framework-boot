package pub.codex.user.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import pub.codex.user.db.mapper.UserMapper;
import pub.codex.user.entity.UserEntity;
import pub.codex.user.db.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {


}
