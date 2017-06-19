package cn.itcast.interceptor;

import cn.itcast.annotation.Authority;
import cn.itcast.authEnum.AuthorityType;
import com.google.gson.Gson;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gaoyu on 2017/6/7.
 * Wish you a good day~
 */
public class AuthorityAnnotationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;

            Class<?> clazz = hm.getBeanType();
            Method m = hm.getMethod();
            try {
                if (clazz != null && m != null) {
                    boolean isClzAnnotation = clazz.isAnnotationPresent(Authority.class);
                    boolean isMethondAnnotation = m.isAnnotationPresent(Authority.class);
                    Authority authority = null;
                    // 如果方法和类声明中同时存在这个注解，那么方法中的会覆盖类中的设定。
                    if (isMethondAnnotation) {
                        authority = m.getAnnotation(Authority.class);
                    } else if (isClzAnnotation) {
                        authority = clazz.getAnnotation(Authority.class);
                    }
                    int code = -1;
                    String msg = "";
                    if (authority != null) {
                        if (AuthorityType.NoValidate == authority.value()) {
                            // 标记为不验证,放行
                            return true;
                        } else if (AuthorityType.NoAuthority == authority.value()) {
                            // 不验证权限，验证是否登录
                            // TODO:
                            return true;
                        } else {
                            // 验证登录及权限
                            // TODO:

                            code = 1;
                            msg = "验证成功！";
                            return true;
                        }
                    }

                    // //跳转
                    // String url = "";
                    // response.getWriter().write("<script>top.location.href='"
                    // + url + "'</script>");
                    // return false;

                    // 未通过验证，返回提示json
                    Map<String, Object> responseMap = new HashMap<String, Object>();
                    responseMap.put("code", code);
                    responseMap.put("msg", msg);
                    responseMap.put("params", "");
                    responseMap.put("rows", "");
                    String json = new Gson().toJson(responseMap);
                    response.setCharacterEncoding("UTF-8");
                    response.setContentType("application/json; charset=utf-8");
                    response.getWriter().write(json);
                    return false;
                }
            } catch (Exception e) {
            }
        }
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
