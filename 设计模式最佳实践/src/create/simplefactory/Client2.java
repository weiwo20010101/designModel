package create.simplefactory;

import sun.security.krb5.internal.tools.Klist;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @Author weiwo
 * @Created on 2021/9/3
 * @content 对不符合开闭原则的代码进行优化
 */
public class Client2 {
    public static void main(String[] args) {

        IProduct2 iProduct20 = simpleFactory.makeProduct(ProductA.class);
        iProduct20.saySomething();
        IProduct2 iProduct21 = simpleFactory.makeProduct(ProductB.class);
        iProduct21.saySomething();
        IProduct2 iProduct22 = simpleFactory.makeProduct(ProductC.class);
        iProduct22.saySomething();

    }

    public interface IProduct2 {
        void saySomething();
    }

    static class ProductA implements IProduct2 {
        @Override
        public void saySomething() {
            System.out.println("i am productA");
        }
    }

    static class ProductB implements IProduct2 {
        @Override
        public void saySomething() {
            System.out.println("i am productB");
        }
    }

    static class ProductC implements IProduct2 {
        @Override
        public void saySomething() {
            System.out.println("i am productC");
        }
    }

    static class simpleFactory {
        public static IProduct2 makeProduct(Class<? extends IProduct2> claszz) {
            try {
                if (claszz != null) {
                    IProduct2 iProduct2 = claszz.newInstance();
                    return iProduct2;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }


    }
}
