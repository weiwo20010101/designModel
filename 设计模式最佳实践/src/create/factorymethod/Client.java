package create.factorymethod;

/**
 * @Author weiwo
 * @Created on 2021/9/3
 */
public class Client {
    public static void main(String[] args) {
        //要生成A
        IFactory iFactoryA=new FactoryA();
        iFactoryA.makeProduct().doSth();
        //
        IFactory iFactoryB=new FactoryB();
        iFactoryB.makeProduct().doSth();
        //
        IFactory iFactoryC=new FactoryC();
        iFactoryC.makeProduct().doSth();
    }
    public interface IFactory{
        IProduct makeProduct();
    }
    public interface IProduct{
         void doSth();
    }
    static class  FactoryA implements IFactory{
        @Override
        public IProduct makeProduct(){
            return new ProductA();
        }
    }
    static class  FactoryB implements IFactory{
        @Override
        public IProduct makeProduct(){
            return new ProductB();
        }
    }
    static class  FactoryC implements IFactory{
        @Override
        public IProduct makeProduct(){
            return new ProductC();
        }
    }
    static  class  ProductA implements  IProduct{
        @Override
        public void doSth(){
            System.out.println(" i am productA");
        }
    }
    static  class  ProductB implements  IProduct{
        @Override
        public void doSth(){
            System.out.println(" i am productB");
        }
    }
    static  class  ProductC implements  IProduct{
        @Override
        public void doSth(){
            System.out.println(" i am productC");
        }
    }
}
