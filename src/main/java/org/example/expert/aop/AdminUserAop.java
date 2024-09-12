package org.example.expert.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class AdminUserAop {
    @Pointcut("within(org.example.expert.domain.comment.controller.CommentAdminController) || " +
            "within(org.example.expert.domain.user.controller.UserAdminController)")
    public void adminUserControllerMethods() {
    }

    @Before("adminUserControllerMethods()")
    public void logAdminAccess(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Long userId = (Long) request.getAttribute("userId");
        String url = request.getRequestURI();
        LocalDateTime time = LocalDateTime.now();
        log.info("요청한 사용자의 ID: {}, API 요청 URL: {}, API 요청 시각: {}", userId, url, time);
    }
}
