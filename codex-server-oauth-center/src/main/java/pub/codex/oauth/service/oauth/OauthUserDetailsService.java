package pub.codex.oauth.service.oauth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationCodeRequestAuthenticationException;
import pub.codex.oauth.db.service.UserService;
import pub.codex.oauth.entity.UserEntity;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class OauthUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<UserEntity> query = new LambdaQueryWrapper<>();
        query.eq(UserEntity::getUsername, username);
        UserEntity user = userService.getOne(query);

        if(user == null){
            OAuth2Error error = new OAuth2Error(OAuth2ErrorCodes.SERVER_ERROR,
                    "This user information has not been queried", null);
            throw new OAuth2AuthorizationCodeRequestAuthenticationException(error, null);
        }

        Set<GrantedAuthority> authorities = new HashSet<>();

        OauthUserDetails oauthUserDetails = new OauthUserDetails();
        oauthUserDetails.setUsername(user.getUsername());
        oauthUserDetails.setPassword(user.getPassword());
        oauthUserDetails.setAuthorities(authorities);

        return oauthUserDetails;

    }
}
