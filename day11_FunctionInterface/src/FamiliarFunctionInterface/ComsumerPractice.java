package FamiliarFunctionInterface;

import java.util.function.Consumer;

/*
       需求：下面的字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来。
*/
public class ComsumerPractice {
    //定义一个方法格式化打印信息
    public static void printFormatMsg(String[] arr, Consumer<String> con1,Consumer<String> con2){
        for (String msg:arr){
            con1.andThen(con2).accept(msg);
        }
    }

    public static void main(String[] args) {
        String[] array = { "迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男" };
        printFormatMsg(array, new Consumer<String>() {
            @Override
            public void accept(String msg) {
                String[] split = msg.split(",");
                System.out.print("姓名："+split[0]+"。");
            }
        }, new Consumer<String>() {
            @Override
            public void accept(String msg) {
                String[] split = msg.split(",");
                System.out.println("性别："+split[1]+"。");
            }
        });
    }
}
