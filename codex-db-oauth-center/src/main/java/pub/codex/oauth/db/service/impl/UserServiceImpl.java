package pub.codex.oauth.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import pub.codex.oauth.db.mapper.UserMapper;
import pub.codex.oauth.entity.UserEntity;
import pub.codex.oauth.db.service.UserService;


@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {


}
