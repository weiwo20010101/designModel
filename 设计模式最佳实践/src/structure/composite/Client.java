package structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author weiwo
 * @Created on 2021/9/7
 * @Content 透明方式 并不安全
 */
public class Client {

     static abstract class Component {
        // 职位
        private String position;
        // 工作内容
        private String job;

        public Component(String position, String job) {
            this.position = position;
            this.job = job;
        }

        // 做自己的本职工作
        public void work() {
            System.out.println("我是" + position + "，我正在" + job);
        }

        abstract void addComponent(Component component);

        abstract void removeComponent(Component component);

        abstract void check();
    }
   static class Manager extends Component {
        // 管理的组件
        private List<Component> components = new ArrayList<>();

        public Manager(String position, String job) {
            super(position, job);
        }

        @Override
        public void addComponent(Component component) {
            components.add(component);
        }

        @Override
        void removeComponent(Component component) {
            components.remove(component);
        }

        // 检查下属
        @Override
        public void check() {
            work();
            for (Component component : components) {
                component.check();
            }
        }
    }
    static class Employee extends Component {

        public Employee(String position, String job) {
            super(position, job);
        }

        @Override
        void addComponent(Component component) {
            System.out.println("职员没有管理权限");
        }

        @Override
        void removeComponent(Component component) {
            System.out.println("职员没有管理权限");
        }

        @Override
        void check() {
            work();
        }
    }

    public static void main(String[] args) {
        Component boss=new Manager("产品经理","分析");
        Component em=new Employee("程序员","学习设计模式");
        boss.addComponent(em);
        boss.check();
    }


}
