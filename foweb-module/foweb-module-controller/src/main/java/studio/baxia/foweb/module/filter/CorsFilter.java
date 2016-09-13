package studio.baxia.foweb.module.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author fireoct
 * @email panhainan@yeah.net
 * @date 2016年9月13日
 * @reference https://my.oschina.net/huangyong/blog/521891
 */
public class CorsFilter implements Filter {

    private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;
    private String allowHeaders;
    private String exposeHeaders;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        Access-Control-Allow-Origin：允许访问的客户端域名，例如：http://web.xxx.com，若为 *，则表示从任意域都能访问，即不做任何限制。
        allowOrigin = filterConfig.getInitParameter("allowOrigin");
//        Access-Control-Allow-Methods：允许访问的方法名，多个方法名用逗号分割，例如：GET,POST,PUT,DELETE,OPTIONS。
        allowMethods = filterConfig.getInitParameter("allowMethods");
//        Access-Control-Allow-Credentials：是否允许请求带有验证信息，若要获取客户端域下的 cookie 时，需要将其设置为 true。
        allowCredentials = filterConfig.getInitParameter("allowCredentials");
//        Access-Control-Allow-Headers：允许服务端访问的客户端请求头，多个请求头用逗号分割，例如：Content-Type。
        allowHeaders = filterConfig.getInitParameter("allowHeaders");
//        Access-Control-Expose-Headers：允许客户端访问的服务端响应头，多个响应头用逗号分割。
        exposeHeaders = filterConfig.getInitParameter("exposeHeaders");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
//        待写一个StringUtil工具类
        if (allowOrigin != null && !allowOrigin.isEmpty()) {
            List<String> allowOriginList = Arrays.asList(allowOrigin.split(","));
//           待写一个CollectionUtil工具类
            if (allowOriginList != null && !allowOriginList.isEmpty()) {
                String currentOrigin = request.getHeader("Origin");
                if (allowOriginList.contains("*") || allowOriginList.contains(currentOrigin)) {
                    response.setHeader("Access-Control-Allow-Origin", currentOrigin);
                }
            }
        }
        if (allowMethods != null && !allowMethods.isEmpty()) {
            response.setHeader("Access-Control-Allow-Methods", allowMethods);
        }
        if (allowCredentials != null && !allowCredentials.isEmpty()) {
            response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
        }
        if (allowHeaders != null && !allowHeaders.isEmpty()) {
            response.setHeader("Access-Control-Allow-Headers", allowHeaders);
        }
        if (exposeHeaders != null && !exposeHeaders.isEmpty()) {
            response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
        }
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
    }
}