import com.netMusic.utils.CharacterUtils;

import java.util.Random;

public class TestRunnable implements Runnable{

//    public Integer ticketCount;
    private static Integer ticketCount = 10;

    public TestRunnable() {
    }

    public TestRunnable(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public void saleTicket(){
        if(ticketCount>0){
            ticketCount--;
            System.out.println(Thread.currentThread().getName()+"售票一张,余票数为："+ticketCount);
        }
    }

    @Override
    public void run() {

        synchronized (ticketCount){
            while(ticketCount>0){
                saleTicket();
//                System.out.println(Thread.currentThread().getName()+"标志位："+ticketCount);
            }
        }


    }


    public static void main(String[] args){

        System.out.println(Thread.currentThread().getName());
//        for(int i=0;i<5;i++){//启动5个线程，每个线程有3张票可售
//            new Thread(new TestRunnable(3),"售票线程"+(i+1)).start();
//        }

        for(int i=0;i<5;i++){//启动5个线程，此时共享一个变量，即总共10张票
            new Thread(new TestRunnable(),"售票线程"+(i+1)).start();
        }



    }


}
