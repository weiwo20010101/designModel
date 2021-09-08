package action.cmd;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author weiwo
 * @Created on 2021/9/8
 */
public class Client3 {
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
    static class addCommand implements ICommand {
       Receiver receiver;
        public addCommand(Receiver receiver){
            this.receiver=receiver;
        }
        @Override
        public void cmd(){
            receiver.add();
        }
    }
    static class speedCommand implements ICommand {
        Receiver receiver;
        public speedCommand(Receiver receiver){
            this.receiver=receiver;
        }
        @Override
        public void cmd(){
            receiver.speed();
        }
    }
    static class pauseCommand implements ICommand {
        Receiver receiver;
        public pauseCommand(Receiver receiver){
            this.receiver=receiver;
        }
        @Override
        public void cmd(){
            receiver.pause();
        }
    }
    static class stopCommand implements ICommand {
        Receiver receiver;
        public stopCommand(Receiver receiver){
            this.receiver=receiver;
        }
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
        //未直接绑定receiver
        //执行单条命令
        Receiver receiver=new Receiver();
        Controller controller=new Controller();
      controller.execute(new speedCommand(receiver));
        //执行多条命令
        controller.add(new addCommand(receiver));
        controller.add(new speedCommand(receiver));
        controller.add(new stopCommand(receiver));
        controller.add(new stopCommand(receiver));
        controller.executes();
    }
}
