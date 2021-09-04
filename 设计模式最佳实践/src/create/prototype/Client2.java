package create.prototype;

import java.time.Period;

/**
 * @Author weiwo
 * @Created on 2021/9/4
 * @Content 实现cloneable（）
 */

public class Client2 {


    public static void main(String[] args) {
        Prototype prototype=new Prototype("origin");
        Prototype clone = prototype.clone();
        System.out.println(clone.toString());
    }

    static class Prototype implements Cloneable{
        private  String desc;

        public Prototype(String desc){
            this.desc=desc;
        }

        @Override
        public Prototype clone(){
            Prototype prototype=null;
            try{
                prototype=(Prototype) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return prototype;
        }

        @Override
        public String toString(){
            return this.getClass().getSimpleName() +".desc= "+desc;
        }
    }
}
