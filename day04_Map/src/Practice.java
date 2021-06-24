import java.util.*;

/*
       遍历字符串的2种方式：
             1、String类的方法toCharArray(),把字符串转换为一个字符数组，遍历数组
             2、String类的方法length()+charAt(int index)
*/
public class Practice {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = input.next();
        char[] strChar = str.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:strChar){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        System.out.println(map);
    }

    //按照权重返回随机资源  1：3     2：2     3：1
    public static int getResource(Map<Integer,Integer> map){
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = entries.iterator();
        int totalWeight=0; //计算所有权重
        while (it.hasNext()){
            Map.Entry<Integer, Integer> entry = it.next();
            totalWeight+=entry.getValue();
        }
        Random random=new Random();
        int weight = random.nextInt(totalWeight);
        //然后你要判断每个资源所属的权重范围

        //再看weight落在那个权重范围内，然后返回该范围对应的资源

        return  0;
    }


}
/*
    Debug调试：
              F8 逐行执行程序
              F7 进入到方法中
              shift+F8 跳出方法
              F9 调到下一个断点，如果没有那么就执行完程序
              Ctrl+F2  退出debug模式，停止执行
 */