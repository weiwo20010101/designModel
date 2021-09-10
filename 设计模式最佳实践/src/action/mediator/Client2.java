package action.mediator;

/**
 * @Author weiwo
 * @Created on 2021/9/10
 */
public class Client2 {

    public static void main(String[] args) {
           Mediator mediator=new ConcreteMediator();
           ConcreteColleagueA concreteColleagueA=new ConcreteColleagueA(mediator);
           ConcreteColleagueB concreteColleagueB=new ConcreteColleagueB(mediator);
           concreteColleagueB.self();
           concreteColleagueB.transfer();
    }
    static abstract  class Mediator{
     protected ConcreteColleagueA concreteColleagueA;
     protected ConcreteColleagueB concreteColleagueB;

       public void setConcreteColleagueA(ConcreteColleagueA concreteColleagueA){
          this.concreteColleagueA=concreteColleagueA;
       }
       public void setConcreteColleagueB(ConcreteColleagueB concreteColleagueB){
          this.concreteColleagueB=concreteColleagueB;

       }
       public abstract void tansferA();
       public abstract  void tansferB();
    }
    static  class ConcreteMediator extends Mediator{
        @Override
        public void tansferA() {
        this.concreteColleagueB.self();
        }

        @Override
        public void tansferB() {
            this.concreteColleagueA.self();
        }

    }

    static abstract  class Colleague {
        protected Mediator mediator;

        public Colleague(Mediator mediator) {
            this.mediator = mediator;
        }
    }
       static class ConcreteColleagueA extends Colleague{
            public ConcreteColleagueA(Mediator mediator){
              super(mediator);
                mediator.setConcreteColleagueA(this);
            }
           public void self(){
               System.out.println(this.getClass().getSimpleName());
           }
           public  void transfer(){
               System.out.println(this.getClass().getSimpleName());
               this.mediator.tansferA();
           }
       }
    static class ConcreteColleagueB extends Colleague{
        public ConcreteColleagueB(Mediator mediator){
            super(mediator);
            mediator.setConcreteColleagueB(this);
        }
        public void self(){
            System.out.println(this.getClass().getSimpleName());
        }
        public  void transfer(){
            System.out.println(this.getClass().getSimpleName());
            this.mediator.tansferB();
        }
    }

}
