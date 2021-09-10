package action.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author weiwo
 * @Created on 2021/9/10
 */
public class Client2 {
    public static void main(String[] args) {
        SubObserver<String>subObserver=new SubObserver<>();
        subObserver.add(new ObserverA<String>());
        subObserver.add(new ObserverB<String>());
        subObserver.add(new ObserverC<String>());
        subObserver.add(new ObserverD<String>());
        subObserver.notify("a event");


        SubObserver<Integer> subObserver1=new SubObserver<>();
        subObserver1.add(new ObserverA<Integer>());
        subObserver1.add(new ObserverB<Integer>());
        subObserver1.add(new ObserverC<Integer>());
        subObserver1.add(new ObserverD<Integer>());
        subObserver1.notify(3);
    }
    interface  ISubObserver<E>{
        void  add(Observer observer);
        void  remove(Observer observer);
        void notify(E Event);
    }
    static class SubObserver<E> implements  ISubObserver<E>{
        private List<Observer<E>> list=new ArrayList<>();

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
        public void notify(E event) {
            System.out.println(this.getClass().getSimpleName()+ event);
            for(Observer<E> observer:this.list){
                observer.update(event);
            }
        }
    }
    interface  Observer<E>{
        void  update(E event);
    }
    static class ObserverA<E> implements  Observer<E>{
        @Override
        public void update(E event){
            System.out.println(this.getClass().getSimpleName()+"收到消息,正在响应"+event);
        }
    }
    static class ObserverB<E> implements  Observer<E>{
        @Override
        public void update(E  event){
            System.out.println(this.getClass().getSimpleName()+"收到消息,正在响应"+event);
        }
    }
    static class ObserverC<E> implements  Observer<E>{
        @Override
        public void update(E event){
            System.out.println(this.getClass().getSimpleName()+"收到消息,正在响应"+event);
        }
    }
    static class ObserverD<E> implements  Observer<E>{
        @Override
        public void update(E event){
            System.out.println(this.getClass().getSimpleName()+"收到消息,正在响应"+event);
        }
    }
}
