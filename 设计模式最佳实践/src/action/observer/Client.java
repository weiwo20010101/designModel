package action.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author weiwo
 * @Created on 2021/9/10
 */
public class Client {
    public static void main(String[] args) {
        SubObserver subObserver=new SubObserver();
        subObserver.add(new ObserverA());
        subObserver.add(new ObserverB());
        subObserver.add(new ObserverC());
        subObserver.add(new ObserverD());

        subObserver.notify("I am ing");
    }
    interface  ISubObserver{
      void  add(Observer observer);
      void  remove(Observer observer);
        void notify(String Event);
    }
    static class SubObserver implements  ISubObserver{
         private List<Observer> list=new ArrayList<>();

        @Override
        public void add(Observer observer) {
            if(!list.contains(observer)){
                list.add(observer);
            }
        }

        @Override
        public void remove(Observer observer) {
            if (list.contains(observer)) {
                list.remove(observer);
            }
        }

        @Override
        public void notify(String event) {
            System.out.println(this.getClass().getSimpleName()+ event);
            for(Observer observer:list){
                observer.update(event);
            }
        }
    }
    interface  Observer{
        void  update(String event);
    }
    static class ObserverA implements  Observer{
        @Override
        public void update(String event){
            System.out.println(this.getClass().getSimpleName()+"收到消息,正在响应"+event);
        }
    }
    static class ObserverB implements  Observer{
        @Override
        public void update(String event){
            System.out.println(this.getClass().getSimpleName()+"收到消息,正在响应"+event);
        }
    }
    static class ObserverC implements  Observer{
        @Override
        public void update(String event){
            System.out.println(this.getClass().getSimpleName()+"收到消息,正在响应"+event);
        }
    }
    static class ObserverD implements  Observer{
        @Override
        public void update(String event){
            System.out.println(this.getClass().getSimpleName()+"收到消息,正在响应"+event);
        }
    }
}
