/**
 * 
 */
package com.spring.ioc.springBeanTest;

/**
 * @author 
 *
 */
public class SpringAction2 {
    // 注入对象springDao
    private final SpringDao springDao;
    private final User user;

    public SpringAction2(SpringDao springDao, User user) {
        this.springDao = springDao;
        this.user = user;
        System.out.println("构造方法调用springDao和user");
    }

    public void save() {
        user.setUserName("卡卡");
        springDao.save(user);
    }
}
