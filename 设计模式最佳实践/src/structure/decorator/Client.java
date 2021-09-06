package structure.decorator;

import java.awt.*;

/**
 * @Author weiwo
 * @Created on 2021/9/6
 */
public class Client {

   static abstract class Component{
         abstract  void operation();
    }
    static  abstract  class Decorator extends Component{

        private Component component;
        public Decorator(Component component){
            this.component=component;
        }

        public void operation(){
           component.operation();
        }
    }
    static class ConcreteDecoratorA extends Decorator{
       public ConcreteDecoratorA(Component component){
           super(component);
       }
       public void after(){
           System.out.println("after");
       }
        public void before(){
            System.out.println("before");
        }

        @Override
        public void operation() {
            before();
            super.operation();
            after();
        }
    }
    static class ConcreteDecoratorB extends Decorator{
        public ConcreteDecoratorB(Component component){
            super(component);
        }
        public void after(){
            System.out.println("after");
        }
        public void before(){
            System.out.println("before");
        }

        @Override
        public void operation() {
            before();
            super.operation();
            after();
        }
    }
     static class ConcreteComponent extends Component{


         @Override
         void operation() {
             System.out.println("playing");
         }
     }
    public static void main(String[] args) {
        ConcreteComponent component=new ConcreteComponent();
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(component);
        concreteDecoratorA.operation();

    }

}
