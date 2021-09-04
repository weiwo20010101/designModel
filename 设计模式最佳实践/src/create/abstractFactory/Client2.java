package create.abstractFactory;

import create.factorymethod.Client;

/**
 * @Author weiwo
 * @Created on 2021/9/4
 * @content 抽象写法
 */
public class Client2 {

    public void test(){
        IFactory javaFactory = new javaFactory();
        INode node = javaFactory.createNode();
        node.write();

        IFactory javaFactory2=new javaFactory();
        IVideo video = javaFactory2.createVideo();
        video.record();
    }

    public  interface IVideo{
        void record();
    }
    public interface  INode{
        void write();
    }

    public abstract class IFactory{
        public void init(){
            System.out.println("初始化数据");
        }
       abstract IVideo createVideo();
        abstract  INode createNode();
    }
    public class  javaFactory extends IFactory{
        @Override
        INode createNode() {
            super.init();
        return new javaNode();
        }

        @Override
        IVideo createVideo() {
            super.init();
            return new javaVedio();
        }
    }
    public class  pythonFactory extends  IFactory{
        @Override
        IVideo createVideo() {
            super.init();
            return new pythonVedio();
        }

        @Override
        INode createNode() {
            super.init();
            return new pythonNode();
        }
    }
    public class javaVedio implements  IVideo{
        @Override
        public void record() {
            System.out.println("java 视频");
        }
    }
    public  class javaNode implements  INode{
        @Override
        public void write() {
            System.out.println("java 笔记");
        }
    }
    public   class pythonVedio implements IVideo {
        @Override
        public void record() {
            System.out.println("python 视频");
        }
    }
    public class  pythonNode implements  INode{
        @Override
        public void  write() {
            System.out.println("python 笔记");
        }
    }
}

