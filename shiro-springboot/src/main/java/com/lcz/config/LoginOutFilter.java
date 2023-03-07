package com.lcz.config;

import com.lcz.bean.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Locale;

public class LoginOutFilter extends LogoutFilter {
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = this.getSubject(request, response);
        if (this.isPostOnlyLogout() && !WebUtils.toHttp(request).getMethod().toUpperCase(Locale.ENGLISH).equals("POST")) {
            return this.onLogoutRequestNotAPost(request, response);
        } else {
            String redirectUrl = this.getRedirectUrl(request, response, subject);
            User curUser = (User) SecurityUtils.getSubject().getPrincipal();
            System.out.println("注销当前登录人");
            System.out.println(curUser);
            try {
                subject.logout();
            } catch (SessionException var6) {
            }

            this.issueRedirect(request, response, redirectUrl);
            return false;
        }
    }
}
