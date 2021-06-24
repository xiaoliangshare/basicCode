import java.util.Scanner;

/*
       要求：使用刚才的模拟用户注册操作，如果用户名已存在，则抛出异常并提示：该用户名已经被注册！
*/
public class PracticeException {
    public static String[] usernames={"a","b","c","d"};

    public static void main(String[] args) throws RegisterException {
        Scanner input=new Scanner(System.in);
        System.out.println("请输入用户名：");
        String username = input.next();
        checkUsername(username);

    }
    //对用户名进行有无判断
    public static void checkUsername(String username) throws RegisterException {
        for(String s:usernames){
            if (username.equals(s)){
                throw new RegisterException("该用户名已经被注册！");
            }
        }
        System.out.println("注册成功！");
    }
}
