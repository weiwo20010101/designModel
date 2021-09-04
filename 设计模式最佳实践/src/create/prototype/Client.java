package create.prototype;

/**
 * @Author weiwo
 * @Created on 2021/9/4
 */
public class Client {
    public static void main(String[] args) {
        //创建原型对象
        ConcretePrototypeA originalA = new ConcretePrototypeA("originalA");
        System.out.println(originalA);
        ConcretePrototypeA cloneA = originalA.clone();
        cloneA.desc="clone";
        System.out.println(cloneA);


        //创建原型对象
        ConcretePrototypeB originalB = new ConcretePrototypeB("originalB");
        System.out.println(originalB);
        ConcretePrototypeB cloneB = originalB.clone();
        cloneB.desc="clone";
        System.out.println(cloneB);


    }


    interface IPrototype<T>{
        T clone();
    }
    static class  ConcretePrototypeA implements IPrototype<ConcretePrototypeA>{
        private  String desc;
        public ConcretePrototypeA(String desc){
            this.desc=desc;
        }
        @Override
        public ConcretePrototypeA clone() {
            return new ConcretePrototypeA(this.desc);
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName()+".desc ="+desc;
        }
    }
    static class  ConcretePrototypeB implements IPrototype<ConcretePrototypeB>{
        private  String desc;
        public ConcretePrototypeB (String desc){
            this.desc=desc;
        }
        @Override
        public ConcretePrototypeB clone() {
            return new ConcretePrototypeB(this.desc);
        }

        @Override
        public String toString() {
            return this.getClass().getSimpleName()+".desc ="+desc;
        }
    }
}
