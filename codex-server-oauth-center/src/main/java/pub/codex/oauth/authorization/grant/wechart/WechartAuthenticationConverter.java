package pub.codex.oauth.authorization.grant.wechart;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import pub.codex.oauth.utils.AuthEndpointUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public final class WechartAuthenticationConverter implements AuthenticationConverter {

    public static final String INVALID_REQUEST = "invalid_request";

    public static final AuthorizationGrantType wechartAuthorizationGrantType = new AuthorizationGrantType("wechart");

    @Nullable
    @Override
    public Authentication convert(HttpServletRequest request) {
        // grant_type (REQUIRED)
        String grantType = request.getParameter(OAuth2ParameterNames.GRANT_TYPE);
        if (!wechartAuthorizationGrantType.getValue().equals(grantType)) {
            return null;
        }

        MultiValueMap<String, String> parameters = AuthEndpointUtils.getParameters(request);

        // code (REQUIRED)
        String PARAM_CODE = "code";
        String code = parameters.getFirst(PARAM_CODE);
        if (!StringUtils.hasText(code) ||
                parameters.get(PARAM_CODE).size() != 1) {
            AuthEndpointUtils.throwError(
                    INVALID_REQUEST,
                    PARAM_CODE,
                    AuthEndpointUtils.WECHART_CODE_REQUEST_ERROR_URI);
        }

        // scope (OPTIONAL)
        String scope = parameters.getFirst(OAuth2ParameterNames.SCOPE);
        if (StringUtils.hasText(scope) &&
                parameters.get(OAuth2ParameterNames.SCOPE).size() != 1) {
            AuthEndpointUtils.throwError(
                    OAuth2ErrorCodes.INVALID_REQUEST,
                    OAuth2ParameterNames.SCOPE,
                    AuthEndpointUtils.ACCESS_TOKEN_REQUEST_ERROR_URI);
        }
        Set<String> requestedScopes = null;
        if (StringUtils.hasText(scope)) {
            requestedScopes = new HashSet<>(
                    Arrays.asList(StringUtils.delimitedListToStringArray(scope, " ")));
        }


        Authentication clientPrincipal = SecurityContextHolder.getContext().getAuthentication();

        return new WechartGrantAuthenticationToken(code, clientPrincipal, requestedScopes, Collections.emptyMap());
    }

}