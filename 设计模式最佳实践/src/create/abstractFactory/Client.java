package create.abstractFactory;

/**
 * @Author weiwo
 * @Created on 2021/9/4
 */
public class Client {
    public static void main(String[] args) {
        //创建具体工厂  对应我们选择一个品牌
        //选择具体工厂提供的服务  ，可以选择所有的产品
        IFacotryab facotryabA=new FactoryA();
        IProductAab iProductAab = facotryabA.makeProductA();
        IProductBab iProductBab = facotryabA.makeProductB();


        IFacotryab facotryabB=new FactoryB();
        IProductAab iProductAab1 = facotryabB.makeProductA();
        IProductBab iProductBab1 = facotryabB.makeProductB();
    }

    public interface IFacotryab{
        IProductAab makeProductA();
        IProductBab makeProductB();
    }
    //对一类产品对象声明一个接口
    /*
     产品A抽象
     */
    public interface  IProductAab{
       void doA();
    }
    /*
   产品B抽象
     */
    public interface IProductBab{
        void doB();
    }
    //四种具体产品  实现的是产品的抽象
    static  class concreteProductAWithFamilyA implements  IProductAab{
        @Override
        public void doA() {
            System.out.println("be productA part of factoryA");
        }
    }
    static  class concreteProductBWithFamilyA implements  IProductBab{
        @Override
        public void doB() {
            System.out.println("be productA part of factoryA");
        }
    }
    static  class concreteProductAWithFamilyB implements  IProductAab{
        @Override
        public void doA() {
            System.out.println("be productA part of factoryA");
        }
    }
    static  class concreteProductBWithFamilyB implements  IProductBab{
        @Override
        public void doB() {
            System.out.println("be productA part of factoryA");
        }
    }

    static  class  FactoryA implements Client.IFacotryab {
        @Override
        public IProductAab makeProductA(){
             return new concreteProductAWithFamilyA();
        }

        @Override
        public IProductBab makeProductB() {
            return new concreteProductBWithFamilyA();
        }
    }
    static  class  FactoryB implements Client.IFacotryab {
        @Override
        public IProductAab makeProductA(){
            return new concreteProductAWithFamilyA();
        }

        @Override
        public IProductBab makeProductB() {
            return new concreteProductBWithFamilyB();
        }
    }

}
