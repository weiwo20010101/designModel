package action.store;

/**
 * @Author weiwo
 * @Created on 2021/9/9
 */
public class TestInner {
    private  int number=20;
    public class Inner{
        private  int number =200;
        public void paint(){
          int  number=400;
            System.out.println(number);
            System.out.println(this.number);
            System.out.println(TestInner.this.number);
        }
    }

    public static void main(String[] args) {
        TestInner inner=new TestInner();
        TestInner.Inner in=inner.new Inner();
        System.out.println(in.number);

        in.paint();

    }
}
