/**
 * 
 */
package com.designPattern.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 
 *
 */
public class FilterChain {
    private final List<Filter> filters = new ArrayList<Filter>();
    private Target target;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void execute(String request) {
        for (Filter filter : filters) {
            filter.execute(request);
        }
        target.execute(request);
    }

    public void setTarget(Target target) {
        this.target = target;
    }

}
