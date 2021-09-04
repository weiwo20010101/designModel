package create.single;

/**
 * @Author weiwo
 * @Created on 2021/9/4
 * @Content 饿汉式的标准写法
 */
public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();

    }

    static class Singleton{
        private static  final  Singleton instance=new Singleton();
        private Singleton(){};
        public static Singleton getInstance(){
            return instance;
        }
    }
}
