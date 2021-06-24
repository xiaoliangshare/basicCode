/*
      HashCode(): Object类的一个方法，用于获取对象的哈希值,它是一个int类型的整数
*/

public class MyHashCode {
    public static void main(String[] args) {
        Person p=new Person();
        int hash = p.hashCode();
        System.out.println(hash);//356573597，就是1540e19d的十进制值
        System.out.println(p.toString());//Person@1540e19d；
        // toString()的源码：getClass().getName() + "@" + Integer.toHexString(hashCode());

        Person p2=new Person();
        int hash2 = p2.hashCode();
        System.out.println(hash2);//1735600054

        strHashCode();
    }

    //String类的hashCode值，String类重写了Object类的hashCode()
    public static void strHashCode(){
        String s1=new String("abc");
        String s2=new String("abc");
        System.out.println(s1.hashCode());//96354
        System.out.println(s2.hashCode());//96354

        //两个对象有相同的 hashcode 值，它们也不一定是相等的，如下面两个对象很神奇的就相等了
        System.out.println("重地".hashCode());//1179395
        System.out.println("通话".hashCode());//1179395



    }
}
class Person extends Object{
    /*
            HashCode()的源码：public native int hashCode();
            native：代表该方法调用的是本地操作系统的方法
    */
}