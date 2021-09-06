package structure.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author weiwo
 * @Created on 2021/9/5
 * @Content 基于JDK动态代理
 */
public class Client2 {
    public static void main(String[] args) {
        JdkMeipo meipo=new JdkMeipo();
        IPerson instance = meipo.getInstance(new ZhaoLiu());
        instance.findLove();
    }
    interface IPerson{
        void findLove();
    }

    static class  JdkMeipo implements InvocationHandler{

        private IPerson target;
        public IPerson getInstance(IPerson target){
            this.target=target;
            Class<? extends IPerson> clazz = target.getClass();
            return (IPerson) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String name=method.getName();
            Object result=null;
            before();
            if(name.equals("findLove")){

                 result= method.invoke(this.target,args);
                 System.out.println("是这个");
            }
            after();
            return  result;
        }
        public void before(){
            System.out.println("媒婆收到需求，开始物色");
        }
        public void after(){
            System.out.println("多才多亿 开始交往");
        }

    }
    static class ZhaoLiu implements IPerson{
        @Override
        public void findLove(){
            System.out.println("符合老刘的要求");
        }
        public void buyInsure(){

        }
    }
}
