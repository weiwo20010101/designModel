package action.node;

public class node {

    public static void main(String[] args) {
        ConcreteHandlerA concreteHandlerA=new ConcreteHandlerA();
        ConcreteHandlerB concreteHandlerB=new ConcreteHandlerB();
        concreteHandlerA.setNextHandler(concreteHandlerB);

        concreteHandlerA.handleRequest("requestB");
    }
    static abstract class Handler{
       protected Handler nextHandler;

       public void setNextHandler(Handler handler){
        this.nextHandler=handler;
       }
       public abstract void handleRequest(String request);

    }

    static class ConcreteHandlerA extends  Handler{
        @Override
        public void setNextHandler(Handler handler) {
            super.setNextHandler(handler);
        }

        @Override
        public void handleRequest(String request) {
           if(request.equals("requestA")){
               System.out.println(this.getClass().getSimpleName()+"  deal with request"+request);
               return;
           }
           if(this.nextHandler!=null){
               this.nextHandler.handleRequest(request);
           }
        }
    }
    static class ConcreteHandlerB extends  Handler{
        @Override
        public void setNextHandler(Handler handler) {
            super.setNextHandler(handler);
        }

        @Override
        public void handleRequest(String request) {
            if(request.equals("requestB")){
                System.out.println(this.getClass().getSimpleName()+"deal with request"+request);
                return;
            }
            if(this.nextHandler!=null){
                this.nextHandler.handleRequest(request);
            }
        }
    }
}