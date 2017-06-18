package cn.itcast.exceptionHandler;

import cn.itcast.exception.DiyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gaoyu on 2017/6/14.
 * Wish you a good day~
 */
public class LocalExceptionHandler implements HandlerExceptionResolver {
    /**
     * 系统抛出的异常
     *
     * @param request
     * @param response
     * @param handler  就是处理器适配器需要执行的handler对象（只有method）
     * @param ex       解析出的异常类型
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        DiyException exception = null;

        if (ex instanceof DiyException) {
            exception = (DiyException) ex;
        } else {
            exception = new DiyException("未知错误");
        }

        String message = exception.getMessage();

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("message", message);

        modelAndView.setViewName("error");

        return modelAndView;
    }
}
