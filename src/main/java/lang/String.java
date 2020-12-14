package lang;

/**
 * @author fanhf
 * @Description 测试自己写的java.lang.String的类加载器
 * @date 2020-12-09 09:22
 */
public class String {
    static{
        System.out.println("我是自定义的String类");
    }

    /**
     * 可以看出下面两个main方法，之后第一个能执行，main里面的参数是自定义的String
     * 可以正常执行
     *
     * 而第二个根本无法执行，甚至无法调用
     **/

    public static void main(java.lang.String[] args){
        java.lang.String str = new java.lang.String();
        System.out.println(str);
        System.out.println("hello,system String");
    }

    public static void main(String[] args){
        System.out.println("hello,system String");
    }
}   
