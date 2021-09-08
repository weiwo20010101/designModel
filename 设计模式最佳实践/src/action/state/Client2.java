package action.state;

/**
 * @Author weiwo
 * @Created on 2021/9/8
 */
public class Client2 {
    static   int value=0;
    static abstract  class IState{
        protected Context context;

        public void setContext(Context context){
            this.context=context;
        }
        public abstract void handle();
    }
    static class State1 extends IState{
        @Override
        public void handle(){
            System.out.println("state1");
            //切换状态
         this.context.setState(Context.STATE2);
         this.context.getState().handle();

        }
    }
    static class State2 extends IState{
        @Override
        public void handle(){
            System.out.println("state2");
            this.context.setState(Context.STATE1);
            value++;
            System.out.println(value);
            if(value==3000){
                return;
            }
            this.context.getState().handle();


        }
    }
    static class Context{
   //context上下文中维护状态常量
        private static final IState STATE1=new State1();
        private static final IState STATE2=new State2();


       //语句块，在构造函数之前执行,一般用于对静态属性进行复制,每次new对象都会执行
       {
           STATE1.setContext(this);
           STATE2.setContext(this);
       }
        private IState iState;

        public void  setState(IState iState){
            this.iState=iState;
        }

        public void handle(){
            this.iState.handle();
        }

        public IState getState(){
            return this.iState;
        }
    }

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(Context.STATE1);
        context.handle();
    }
}
