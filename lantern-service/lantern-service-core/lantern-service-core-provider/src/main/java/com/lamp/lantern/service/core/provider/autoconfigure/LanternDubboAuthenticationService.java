package com.lamp.lantern.service.core.provider.autoconfigure;

import com.lamp.lantern.plugins.api.auth.AuthenticationData;
import com.lamp.lantern.plugins.api.auth.AuthenticationPolicy;
import com.lamp.lantern.plugins.api.auth.AuthenticationPolicyService;
import com.lamp.lantern.plugins.api.auth.AuthenticationService;
import com.lamp.lantern.plugins.api.auth.AuthenticationServiceResult;
import org.apache.dubbo.config.annotation.DubboReference;

/**
 * Routes Lantern authentication and policy lookups through standard Dubbo references.
 */
public class LanternDubboAuthenticationService implements AuthenticationService, AuthenticationPolicyService {

    @DubboReference
    private AuthenticationService authenticationService;

    @DubboReference
    private AuthenticationPolicyService policyService;

    @Override
    public AuthenticationServiceResult getUserInfo(AuthenticationData data) {
        return authenticationService.getUserInfo(data);
    }

    @Override
    public AuthenticationServiceResult authentication(AuthenticationData data) {
        return authenticationService.authentication(data);
    }

    @Override
    public AuthenticationPolicy findPolicy(Long systemId, String method, String route) {
        return policyService.findPolicy(systemId, method, route);
    }
}
