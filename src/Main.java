import exercise.*;

import java.util.ArrayList;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Before...");  // main thread
//


//        Thread writeable = new WriteableV2(arrayList);
//        writeable.start();
//
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//

//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("After..."); // main thread


        // main thread, main thread,  thread1 -> Hello,  thread2,   thread2 -> Hello,  thread1 -> World



        ArrayList<String> arrayList = new ArrayList<>(); // 123

        Thread writeable = new Thread(new Writeable(arrayList));    // 123
        writeable.start(); // thread 1 -> Hello, World  -> 2000 ms

        Thread thread = new Thread(new Printable(arrayList));    // Our thread
        thread.start();  // thread2 -> Hello, World

        ExecutorService executorService = null;

        try {
            executorService = Executors.newSingleThreadExecutor();

//            executorService.execute(new Writeable(arrayList2));
//            executorService.execute(new Printable(arrayList2));
//
//            executorService.execute(() -> System.out.println("Hello"));

//          Future<Integer> future =  executorService.submit( new Calculate(2, 1));
//
//
//          boolean isDone =  future.isDone();
//
//          boolean isCanceled =  future.isCancelled();
//
//          future.cancel(true);
//
//          Integer value = future.get();

//            System.out.println(resposne);

            ArrayList<String> arrayList2 = new ArrayList<>();

            Future<List> futureWrite = executorService.submit(new WriteableCallable(arrayList2));

            List l = futureWrite.get();

            if(futureWrite.isCancelled()) {
                System.out.println("Nu am putu scrie date in lista!");
            }

            if(futureWrite.isDone()) {
                Future<List> futurePrint = executorService.submit(new PrintableCallable(arrayList2));
                futurePrint.get();
            }

        } catch (Exception e) {
            System.out.println("Error on Calculate task ... ");
            System.out.println(e.getMessage());
        } finally {
           if(executorService != null) {
               executorService.shutdown(); // nu mai primim task-uri noi, dar asteptam sa finisam cele deja pornite
               executorService.shutdownNow(); // nu mai primim task-uri noi, dar asteptam sa finisam cele deja pornite

              boolean c =  executorService.isTerminated(); // false

               try {
                   executorService.awaitTermination(2000, TimeUnit.MILLISECONDS ); // false
               } catch (InterruptedException e) {
                   System.out.println("Am oprit forat peste 2 sec pentru ca dura prea mult");
               }
           }
        }

    }
}