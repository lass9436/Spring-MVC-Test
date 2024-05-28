package spring.mvc.test.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

@Slf4j
public class LogDispatcherServlet extends DispatcherServlet {

    @Override
    protected HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        HandlerExecutionChain handler = (HandlerExecutionChain) super.getHandler(request);
        if (handler.getHandler() instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler.getHandler();
            Class<?> handlerClass = handlerMethod.getBeanType();
            log.info("getHandler 호출 -> handlerMappings 을 순회하며 찾은 handler (Controller) : {}", handlerClass.getSimpleName());
        }
        return handler;
    }

    @Override
    protected HandlerAdapter getHandlerAdapter(Object handler) throws ServletException {
        HandlerAdapter ha = super.getHandlerAdapter(handler);
        log.info("getHandlerAdapter 호출 -> handlerAdapters 를 순회하며 찾은 handlerAdapter : {}", ha.getClass().getSimpleName());
        if (ha instanceof RequestMappingHandlerAdapter){
            RequestMappingHandlerAdapter rmha = (RequestMappingHandlerAdapter) ha;
        }
        return ha;
    }

    @Override
    protected View resolveViewName(String viewName, @Nullable Map<String, Object> model, Locale locale, HttpServletRequest request) throws Exception {
        log.info("view Resolver 호출");
        return super.resolveViewName(viewName, model, locale, request);
    };

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.info("doDispatch 호출");
        super.doDispatch(request, response);
    }
}
