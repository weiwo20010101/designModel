package action.delegate;

import java.util.Random;

public class Client {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Delegate delegate=new Delegate();
            delegate.doTask();
        }
    }
    interface Itask{
       void doTask();
    }
    static class ConcreteA implements  Itask{
        @Override
        public void doTask() {
            System.out.println("a is doing task");
        }
    }
    static  class ConcreteB implements  Itask{
        @Override
        public void doTask() {
            System.out.println("b is doing task");
        }
    }
    static  class Delegate implements  Itask{

        @Override
        public void doTask() {
         Itask itask=null;
            Random random=new Random();
            int v=random.nextInt(2);
            if(v==0){
                itask=new ConcreteA();
                itask.doTask();
            }else{
                itask=new ConcreteB();
                itask.doTask();
            }
        }

    }

}