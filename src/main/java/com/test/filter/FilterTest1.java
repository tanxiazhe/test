/**
 * 
 */
package com.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author 
 *
 */
public class FilterTest1 implements Filter {

    static {
        System.out.println("Filter test1 static.");

    }

    @Override
    public void destroy() {
        System.out.println("Filter test1 destoryed.");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filter)
            throws IOException, ServletException {
        System.out.println("Test1 dofilter start");
        filter.doFilter(request, response);
        System.out.println("Test1 dofilter end..");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("Filter test1 init.");
    }

}
