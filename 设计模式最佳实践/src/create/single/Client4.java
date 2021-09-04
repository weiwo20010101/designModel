package create.single;

/**
 * @Author weiwo
 * @Created on 2021/9/4
 * @Content 饿汉式 优化  解决了线程安全问题
 */
public class Client4 {

    static  class  Singleton{
        private Singleton(){};
        private  static  Singleton singleton=null;

        public  static synchronized  Singleton getInstance(){
            if(singleton==null){
                singleton=new Singleton();
            }
            return singleton;
        }
    }
}
