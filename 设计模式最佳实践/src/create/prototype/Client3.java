package create.prototype;

import java.io.*;
/**
 * @Author weiwo
 * @Created on 2021/9/4
 * @Content 序列化实现深复制
 */
public class Client3{


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

        public Prototype deepClone(){
            try {
                ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(this);

                ObjectInputStream objectInputStream=new ObjectInputStream(new ByteArrayInputStream(outputStream.toByteArray()));
                Object o = objectInputStream.readObject();
                return (Prototype) o;
            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                return  null;
            }
        }
    }
}
