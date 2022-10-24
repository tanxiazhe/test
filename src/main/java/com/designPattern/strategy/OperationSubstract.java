/**
 * 
 */
package com.designPattern.strategy;

/**
 * @author 
 *
 */
public class OperationSubstract implements Strategy {

    /*
     * (non-Javadoc)
     * 
     * @see com.designPattern.strategy.Strategy#doOperation()
     */
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }

}
