package action.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author weiwo
 * @Created on 2021/9/8
 */
public class Client2 {

    interface   ICommand{
        void cmd();
    }
    static  class Receiver {
        public void add(){
            System.out.println("add");
    }
       public void speed(){
           System.out.println("speed");}
        public void stop(){
            System.out.println("stop");
        }
        public void pause(){
            System.out.println("pause");
        }
    }
    static class addCommand implements  ICommand{
        Receiver receiver=new Receiver();
        @Override
        public void cmd(){
            receiver.add();
        }
    }
    static class speedCommand implements  ICommand{
        Receiver receiver=new Receiver();
        @Override
        public void cmd(){
            receiver.speed();
        }
    }
    static class pauseCommand implements  ICommand{
        Receiver receiver=new Receiver();
        @Override
        public void cmd(){
            receiver.pause();
        }
    }
    static class stopCommand implements  ICommand{
        Receiver receiver=new Receiver();
        @Override
        public void cmd(){
            receiver.stop();
        }
    }
    static  class Controller{
        private List<ICommand> list=new ArrayList<>();

        public void add(ICommand iCommand){
            list.add(iCommand);
        }
        public void clear(ICommand iCommand){
            list.clear();
        }
        public void execute(ICommand iCommand){
            iCommand.cmd();
        }
        public void executes(){
            for(ICommand iCommand:list){
                iCommand.cmd();
            }
        }
    }

    public static void main(String[] args) {
     //绑定receiver
        //执行单条命令
        Controller controller=new Controller();
        controller.execute(new addCommand());
        //执行多条命令
        controller.add(new addCommand());
        controller.add(new speedCommand());
        controller.add(new stopCommand());
        controller.add(new stopCommand());
        controller.executes();
    }
}
