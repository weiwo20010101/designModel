package structure.bridge;

/**
 * @Author weiwo
 * @Created on 2021/9/8
 */
public class Client {

    public static void main(String[] args) {
        abs1 abs1 = new abs1(new Implement1());
        abs1.operation();

        Client.abs1 abs11 = new abs1(new Implement2());
        abs11.operation();

    }

    interface  Iimplement{
        void operation();
    }
    static  class Implement1 implements  Iimplement{

        @Override
        public void operation(){
            System.out.println("operation 1");
        }
    }
    static  class Implement2 implements  Iimplement{

        @Override
        public void operation(){
            System.out.println("operation 2");
        }
    }
    public static abstract class  abs {
       private Iimplement iimplement;
       public abs(Iimplement iimplement){
           this.iimplement=iimplement;
       }
       public void operation(){
           this.iimplement.operation();
       }
    }
      static class abs1 extends  abs{
          public abs1(Iimplement iimplement){
            super(iimplement);
        }

          @Override
          public void operation() {
              System.out.println("abs1");
              super.operation();
          }
      }

    
}
