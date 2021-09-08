package action.strategy;

/**
 * @Author weiwo
 * @Created on 2021/9/8
 */
public class Client {

    interface  IStrategy{
        void  strategy();
    }
    static class Strategy1 implements  IStrategy{
        @Override
        public void strategy(){
            System.out.println("s1");
        }
    }
    static class Strategy2 implements  IStrategy{
        @Override
        public void strategy(){
            System.out.println("s2");
        }
    }
    static class Strategy3 implements  IStrategy{
        @Override
        public void strategy(){
            System.out.println("s3");
        }
    }
    static  class Context{
        private IStrategy iStrategy;

        public Context(IStrategy iStrategy){
            this.iStrategy=iStrategy;
        }

        public void strategy(){
            this.iStrategy.strategy();
        }
    }

    public static void main(String[] args) {
        Strategy1 strategy1 = new Strategy1();
        Context context = new Context(strategy1);
        context.strategy();
    }
}
