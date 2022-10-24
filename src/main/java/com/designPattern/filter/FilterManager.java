/**
 * 
 */
package com.designPattern.filter;

/**
 * @author 
 *
 */
public class FilterManager {
    private final FilterChain filterChain;

    /**
     * 
     */
    public FilterManager(Target target) {
        filterChain = new FilterChain();
        filterChain.setTarget(target);
    }

    public void setFilter(Filter filter) {
        filterChain.addFilter(filter);
    }

    public void filterRequest(String request) {
        filterChain.execute(request);
    }
}
