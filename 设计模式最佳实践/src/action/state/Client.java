package action.state;

/**
 * @Author weiwo
 * @Created on 2021/9/8
 */
public class Client {


    interface Istate{
       void  handle();
    }
    static  class State1 implements Istate{

        @Override
        public void handle() {
            System.out.println("state1");
        }
    }
    static  class State2 implements Istate{

        @Override
        public void handle() {
            System.out.println("state2");
        }
    }
    static  class State3 implements Istate{

        @Override
        public void handle() {
            System.out.println("state3");
        }
    }
    static class Context{
        Istate istate=new State1();

        public void setIstate(Istate istate){
            this.istate=istate;
        }
        public void handle(){
            this.istate.handle();
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setIstate(new State3());
        context.handle();
        context.setIstate(new State2());
        context.handle();
    }
}
