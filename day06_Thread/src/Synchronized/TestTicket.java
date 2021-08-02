package Synchronized;

//模拟卖票，创建3个窗口(线程)同时开启卖票模式
public class TestTicket {
    public static void main(String[] args) throws InterruptedException {

        //Synchronized.TicketRunnable runTicket=new Synchronized.TicketRunnable();
        TicketRunnableCodeBlock runTicket=new TicketRunnableCodeBlock();
        //TicketRunnableFunction runTicket=new TicketRunnableFunction();
        //TicketRunnableLock runTicket=new TicketRunnableLock();
        Thread t1=new Thread(runTicket);
        Thread t2=new Thread(runTicket);
        Thread t3=new Thread(runTicket);
        t1.start();
        t2.start();
        t3.start();
        t1.join();//


    }
}
