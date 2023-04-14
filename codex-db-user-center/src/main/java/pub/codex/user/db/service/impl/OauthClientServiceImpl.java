package pub.codex.user.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import pub.codex.user.db.mapper.OauthClientMapper;
import pub.codex.user.entity.OauthClientEntity;
import pub.codex.user.db.service.OauthClientService;


@Service("oauthClientService")
public class OauthClientServiceImpl extends ServiceImpl<OauthClientMapper, OauthClientEntity> implements OauthClientService {


}
