package create.single;

/**
 * @Author weiwo
 * @Created on 2021/9/4
 * @Content 饿汉式 使用静态快的机制
 */
public class Client2 {

    static  class HungryStaticsSingleton{
        private static final  HungryStaticsSingleton hungrySingleton;
        static {
            hungrySingleton=new HungryStaticsSingleton();
        }
        private  HungryStaticsSingleton(){};
        public  static  HungryStaticsSingleton getInstance(){
            return hungrySingleton;
        }
    }
}
