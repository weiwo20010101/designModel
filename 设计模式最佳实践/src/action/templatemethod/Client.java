package action.templatemethod;

/**
 * @Author weiwo
 * @Created on 2021/9/8
 */
public class Client {
    public static void main(String[] args) {

    }
    static abstract class AbstractClassA{
        void step1(){
            System.out.println("abstractA step1");
        }
        void step2(){
            System.out.println("abstractA step2");
        }
        void step3(){
            System.out.println("abstractA step3");
        }
        void step4(){
            System.out.println("abstractA step4");
        }
         public   final void doSth(){
            this.step1();
            this.step2();
            this.step3();
            this.step4();
        }
    }
    static  class ConcreteA extends  AbstractClassA{
        @Override
        void step1() {
            super.step1();
        }

        @Override
        void step2() {
            super.step2();
        }

        @Override
        void step3() {
            super.step3();
        }

        @Override
        void step4() {
            super.step4();
        }
    }
}
