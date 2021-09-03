package create.simplefactory;

/**
 * @Author weiwo
 * @Created on 2021/9/3
 * @content 简单工厂模式的通用写法
 */
public class Client {
    public static void main(String[] args) {
        new simpleFactory().makeProduct(1);
        new simpleFactory().makeProduct(2);
        new simpleFactory().makeProduct(3);
    }
    public interface  IProduct{
        void saySomething();
    }
    static class ProductA implements IProduct{
        @Override
        public void saySomething(){
            System.out.println("i am productA");
        }
    }
    static class ProductB implements IProduct{
        @Override
        public void saySomething(){
            System.out.println("i am productB");
        }
    }
    static class ProductC implements IProduct{
        @Override
        public void saySomething(){
            System.out.println("i am productC");
        }
    }

    static class simpleFactory{
        public static IProduct makeProduct(int kind){
          switch (kind){
              case 1:
                  return new ProductA();
              case 2:
                  return new ProductB();
              case 3:
                  return new ProductC();
          }
          return  null;
        }
    }

}
