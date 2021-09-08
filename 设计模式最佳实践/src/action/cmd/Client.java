package action.cmd;

import sun.util.resources.cldr.ii.CalendarData_ii_CN;

/**
 * @Author weiwo
 * @Created on 2021/9/8
 */
public class Client {
    public static void main(String[] args) {

        ConcreteCommandA a=new ConcreteCommandA(new Receiver1());
        Invoker invoker=new Invoker(a);
        invoker.invoke();
    }
    interface  ICommand{
        void request();
    }
    static class ConcreteCommandA implements ICommand{

       IReceiver iReceiver;
       public ConcreteCommandA(IReceiver iReceiver){
           this.iReceiver=iReceiver;
       }

        @Override
        public void request(){
        this.iReceiver.action();
        }
    }
    interface IReceiver{
        void action();
    }
    static class Receiver1 implements IReceiver{
        public void action(){
            System.out.println(" 1 正在处理");
        }
    }
    static class Receiver2 implements IReceiver{
        public void action(){
            System.out.println(" 2 正在处理");
        }
    }

    static class Invoker {
        ICommand iCommand;

        public Invoker(ICommand iCommand){
            this.iCommand=iCommand;
        }

        public void invoke(){
            this.iCommand.request();
        }
    }
}
