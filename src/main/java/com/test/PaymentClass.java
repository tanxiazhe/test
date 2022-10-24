/**
 * 
 */
package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ConsultResult {

    /** 咨询结果是否可用 */

    private boolean isEnable;

    /** 错误码 */

    private String errorCode;

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}

public class PaymentClass {

    /**
     * 
     * 过滤不可用支付方式类型
     * 
     * @param paymentTypeList
     *            原始支付方式类型列表
     * 
     * @return 可用支付方式类型列表
     * 
     */

    public List<String> filterDisablePayment(List<String> allPaymentList) {

        List<String> resultList = new ArrayList<String>();

        // 创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        /*
         * for (i = 0; i < allPaymentList.size(); i++) {
         * fixedThreadPool.execute(new Runnable() {
         * 
         * @Override
         * public void run() {
         * try {
         * // 打印正在执行的缓存线程信息
         * System.out.println(Thread.currentThread().getName() + "正在被执行");
         * // String paymentType = allPaymentList.get(i);
         * try {
         * PaymentRemoteSerivce s = new PaymentRemoteSerivce() {
         * };
         * ConsultResult cr = PaymentRemoteSerivce.isEnabled(paymentType);
         * if (cr.isEnable()) {
         * resultList.add(allPaymentList.get(i));
         * }
         * } catch (Exception e) {
         * e.printStackTrace();
         * }
         * 
         * Thread.sleep(2000);
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * }
         * });
         * }
         */
        return resultList;
    }

    static class PaymentRemoteSerivce {

        /**
         * @param paymentType
         * @return
         */
        public static ConsultResult isEnabled(String paymentType) {
            return null;
        }

    }
}
