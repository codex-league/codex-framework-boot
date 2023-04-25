package pub.codex.oauth.service.client;


import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationCodeRequestAuthenticationException;

/**
 * 客户端用户认证服务
 *
 */
public class ClientUserDetailsService{

    private static final String ERROR_URI = "https://developers.weixin.qq.com/miniprogram/dev/OpenApiDoc/user-login/code2Session.html";


    @Autowired
    private WxMaService wxMaService;

    /**
     * 微信 code 认证方式
     *
     * @return
     */
    public ClientUserDetails loadUserByCode(String jsCode) {

        ClientUserDetails clientUserDetails = new ClientUserDetails();

        try{

            WxMaJscode2SessionResult wxMaJscode2SessionResult = wxMaService.jsCode2SessionInfo(jsCode);
            clientUserDetails.setUnionId(wxMaJscode2SessionResult.getUnionid());
            clientUserDetails.setOpenId(wxMaJscode2SessionResult.getOpenid());
            clientUserDetails.setUsername(wxMaJscode2SessionResult.getOpenid());

            // // TODO: 自己补充业务

        } catch (WxErrorException e){
                OAuth2Error error = new OAuth2Error(OAuth2ErrorCodes.SERVER_ERROR,
                        e.getMessage(), ERROR_URI);
                throw new OAuth2AuthorizationCodeRequestAuthenticationException(error, null);
        }

        return clientUserDetails;
    }

}
