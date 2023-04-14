package pub.codex.oauth.db.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import pub.codex.oauth.db.mapper.OauthClientMapper;
import pub.codex.oauth.entity.OauthClientEntity;
import pub.codex.oauth.db.service.OauthClientService;


@Service("oauthClientService")
public class OauthClientServiceImpl extends ServiceImpl<OauthClientMapper, OauthClientEntity> implements OauthClientService {


}
