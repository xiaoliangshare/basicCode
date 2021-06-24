import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
        Throwable体系
                Error：程序不能处理的错误（Virtual MachineError：OutOfMemoryError和StackOverflowError）
                        StackOverflowError：当应用程序递归太深而发生堆栈溢出时，抛出该错误。
                        OutOfMemoryError：虚拟机在扩展栈时无法申请到足够的内存空间，就是内存满了。
                Exception: 是程序本身可以处理的异常
                        （1）编译时期异常:checked异常。在编译时期,就会检查,如果没有处理异常,则编译失败。(如日期格式化异常)
                             处理方式：
                                    1、throws给JVM处理，就是中断程序（中断处理），报出异常，在throws后面可以写多个异常类，用逗号隔开。
                                       如果抛出的多个异常对象有子父类关系，那么直接声明父类异常即可。
                                    2、使用try-catch代码块
                        （2）运行时期异常:runtime异常。在运行时期,检查异常.在编译时期,运行异常不会编译器检测(不报错)。(如数学异常，数组越界等)
                             处理方式：
                                    无需处理，交给JVM处理。
*/
public class MyException {
    public static void main(String[] args) /*throws ParseException*/ {
        //int[] arr=new int[1024*1024*1024];//java.lang.OutOfMemoryError: Java heap space
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date parse = null;
        try {//try中放可能出现异常的代码
            parse = sdf.parse("2020-1226");
        } catch (ParseException e) {//catch中放处理异常的代码
            System.out.println("您输入的日期格式不匹配");
            e.printStackTrace();//java.text.ParseException: Unparseable date: "2020-1226" at MyException.main(MyException.java:26)（类型-原因-位置）
            //包含了异常的类型,异常的原因,还包括异常出现的位置,在开发和调试阶段,都得使用printStackTrace。
        }
        System.out.println(parse);
        int element = getElement(new int[]{1, 2, 3}, 20);
        System.out.println(element);

        
    }

    /*
        用throw来抛出一个指定的异常对象。将这个异常对象传递到调用者处，并结束当前方法的执行。
               注意：throw必须写在方法内部
                     throw后面new的对象必须是Exception或者Exception的子类对象
                     throw抛出的指定的异常对象，我们就必须处理这个异常对象
                     以后工作中我们必须对传递过来的参数进行合法性的校验，告知方法的调用者
    */
    public static int getElement(int[] arr,int index){
        if (arr==null){
            throw new NullPointerException("数组为空！");//等价于 Objects.requireNonNull(arr,"数组为空！");
        }
        if (index<0||index>arr.length-1){
            throw new ArrayIndexOutOfBoundsException("数组越界啦~");
        }
        return arr[index];
    }

}
/*
try-catch的使用方式：
     1.多个异常分别处理；
     2.多个异常一次捕获，多次处理：
            catch (IOException ex) {
                 logger.error(ex);
                 throw new MyException(ex.getMessage());
            catch (SQLException ex) {
                 logger.error(ex);
                 throw new MyException(ex.getMessage());
            }catch (Exception ex) {
                 logger.error(ex);
                 throw new MyException(ex.getMessage());
             }
           注意:这种异常处理方式，要求多个catch中的异常不能相同，并且若catch中的多个异常之间有子父类异常的关系，
                那么子类异常要求在上面的catch处理，父类异常在下面的catch处理。


     3.多个异常一次捕获，一次处理（在Java7中）：
            catch(IOException | SQLException ex){
                 logger.error(ex);
                 throw new MyException(ex.getMessage());
            }
            说明：
                如果用一个catch块处理多个异常，可以用管道符将它们分开，在这种情况下异常参数变量ex是定义为final的，
                所以不能被修改，这一特性将生成更少的字节码并减少代码冗余。
            注意：
                如果所有异常都属于同一个类层次结构，则可以简单地捕获该基本异常类型。
                如果ExceptionB直接或间接地继承ExceptionA，则无法在同一块中捕获ExceptionA和ExceptionB。编译器会报：
                Types in multi-catch must be disjoint: "java.io.IOException" is subclass of "java.lang.Exception"
*/