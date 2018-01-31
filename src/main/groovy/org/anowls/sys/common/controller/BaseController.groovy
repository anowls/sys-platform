package org.anowls.sys.common.controller

import javax.servlet.http.HttpServletRequest

import org.apache.commons.lang3.StringUtils
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

abstract class BaseController {

    protected HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
    }

    protected String getUserIp() {
        String value = this.getRequest().getHeader("X-Real-IP")
        return StringUtils.isNotBlank(value) && !"unknown".equalsIgnoreCase(value) ? value : this.getRequest().getRemoteAddr()
    }
}
