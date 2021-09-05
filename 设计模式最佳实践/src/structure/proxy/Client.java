package structure.proxy;

/**
 * @Author weiwo
 * @Created on 2021/9/5
 */
public class Client {
    public static void main(String[] args) {
        //真实主题角色作为参数
        Proxy proxy = new Proxy(new RealSubject());
        //调用者不知道 before() 和 after()
        proxy.request();
    }
    //抽象主题角色声明共同接口方法
    interface ISubject{
        void request();
    }
    static class  Proxy implements  ISubject{
        private  ISubject subject;
        public Proxy(ISubject iSubject){
            this.subject=iSubject;
        }
        public void request(){
            before();
            subject.request();
            after();
        }
       private void before(){
           System.out.println("before request()");
       }
       private   void after(){
           System.out.println("after request()");
       }
    }
    static class RealSubject implements ISubject{
        public void request(){
            System.out.println("real service is called");
        }
    }
}
