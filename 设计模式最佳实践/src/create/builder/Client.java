package create.builder;

/**
 * @Author weiwo
 * @Created on 2021/9/5
 * @Content 建造者模式模板
 */
public class Client {
    public static void main(String[] args) {

    }

    static class Product{
        private  String name;

        @Override
        public String toString(){
            return "product.name= "+name;
        }
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name=name;
        }
    }
    interface IBuilder{
        Product build();
    }
    static class  ConcreteBuilder implements  IBuilder{
        private  Product product=new Product();
        @Override
        public Product build(){
            return product;
        }
    }
}
