package create.single;

/**
 * @Author weiwo
 * @Created on 2021/9/4
 * @Content 懒汉式写法
 */
public class Client3 {

    static  class  Singleton{
        private Singleton(){};

        private static Singleton instance=null;
        public static  Singleton getInstance(){
          if(instance==null){
              instance=new Singleton();
          }
          return instance;
        }
    }
}
