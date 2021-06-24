package Lambda.PersonPractice;

import java.util.Arrays;

/*
     需求:
         使用数组存储多个Person对象
         对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
*/
public class TestPerson {
    public static void main(String[] args) {
        //我擦！居然还能这样创建数组
        Person[] pArr=new Person[3];
        pArr[0]=new Person("a",22);
        pArr[1]=new Person("b",13);
        pArr[2]=new Person("c",24);

        /*Arrays.sort(pArr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });*/

        //使用Lambda简化匿名内部类,这个就是有参数的
        Arrays.sort(pArr,(Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        //遍历数组
        for(Person p:pArr){
            System.out.println(p);
        }
    }
}
