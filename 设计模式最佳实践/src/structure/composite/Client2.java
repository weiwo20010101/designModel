package structure.composite;

import sun.nio.cs.ext.MacArabic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author weiwo
 * @Created on 2021/9/7
 */
public class Client2 {

    static abstract class Component{
        private String position;
        private String job;
        public Component(String position,String job){
            this.job=job;
            this.position=position;
        }
        public void work(){
            System.out.println("我是"+position+"我正在"+job);
        }
        abstract  void check();
    }
    static class Manager extends Component{
        private List<Component> list =new ArrayList<>();

        public Manager(String position, String job) {
            super(position, job);
        }

        @Override
        public void work() {
          super.work();
        }

        @Override
        void check() {
             work();
             for(Component component:list){
                 component.check();
             }
        }
        public void addComponent(Component component){
            list.add(component);
        }
        public void removeComponent(Component component){
            list.remove(component);
        }

    }
    static class Employee extends Component{
        public Employee(String position, String job) {
            super(position, job);
        }

        @Override
        public void work() {
            super.work();
        }

        @Override
        void check() {
       work();
        }
    }

    public static void main(String[] args) {
      Employee employee=new Employee("c","d");
      Manager manager=new Manager("a","b");
      manager.addComponent(employee);
      manager.check();
    }
}
