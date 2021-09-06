package structure.flyweight;

/**
 * @Author weiwo
 * @Created on 2021/9/6
 */
public class StringTest {
    public static void main(String[] args) {
   String s1="hello";
   String s2="he"+"llo";
   String s3=new String("hello");
   String s5="he"+new String("llo");
   String s6=s5.intern();
   String s7=s3.intern();
   String s8="h";
   String s9="ello";
   String s10=s8+s9;
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s1==s5);
        System.out.println(s1==s6);
        System.out.println(s1==s7);
        System.out.println(s1==s10);
        System.out.println(s5==s6);
        System.out.println(s6==s7);

        System.out.println(s6==s2);

    }
}
