package structure.decorator;

/**
 * @Author weiwo
 * @Created on 2021/9/6
 */
public class Client2 {
      static abstract  class Cake{
          abstract String getMsg();
          abstract int getPrice();
      }
      static class RealCake extends  Cake{
          @Override
          String getMsg() {
            return "a cake contains ";
          }
          @Override
          int getPrice() {
              return 5;
          }
      }
      static  abstract  class DecoratorCake extends  Cake{
          private Cake cake;
          public DecoratorCake(Cake cake){
              this.cake=cake;
          }
          public abstract void doSomething();

          @Override
          String getMsg() {
           return this.cake.getMsg();
          }

          @Override
          int getPrice() {
              return this.cake.getPrice();
          }
      }
      static  class EggCake extends  DecoratorCake{
          public EggCake(Cake cake) {
              super(cake);
          }

          @Override
          public void doSomething() {

          }

          @Override
          String getMsg() {
              return super.getMsg()+" a egg ";
          }

          @Override
          int getPrice() {
              return super.getPrice()+1;
          }
      }
    static  class RouCake extends  DecoratorCake{
        public RouCake(Cake cake) {
            super(cake);
        }

        @Override
        public void doSomething() {

        }

        @Override
        String getMsg() {
            return super.getMsg()+"a roul ";
        }

        @Override
        int getPrice() {
            return super.getPrice()+2;
        }
    }
    public static void main(String[] args) {
        RealCake cake=new RealCake();
        EggCake eggCake = new EggCake(cake);
        RouCake rouCake=new RouCake(eggCake);

        System.out.println(rouCake.getMsg()+"all cost "+rouCake.getPrice());
    }
}
