/**
 * 
 */
package com.test;

/**
 * @author
 * @param <T>
 *
 */
public class BoxImpl<T> implements Box<T> {
    public void unbox(Box<?> box) {
        System.out.println(box.get());
    }

    public static void main(String[] args) {
        BoxImpl<String> b = new BoxImpl<String>();
        b.put("a");
        b.unbox(b);

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.test.Box#get()
     */
    @Override
    public T get() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void put(T element) {
        // TODO Auto-generated method stub

    }
}
