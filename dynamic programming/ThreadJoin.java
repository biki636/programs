// Suppose one thread is printing 1 3  5 7 9
// Another thread is printing 2 4 6 8 10
// Run these two threds such that the output will be 1 2 3 4 5 6 7 8 9 10
class ThreadJoin {
    public static void main(String[] args) {
        SimpleThread1 t1 = new SimpleThread1();
        SimpleThread2 t2 = new SimpleThread2();

        SimpleThread1.otherThread = t2;
        SimpleThread2.otherThread = t1;

        t1.start();
        t2.start();
    }
}

class SimpleThread1 extends Thread {
    public static SimpleThread2 otherThread;

    @Override
    public void run() {
        
        for(int i = 1 ; i <= 10 ; i += 2) {
            System.out.println(i);

            try {
                otherThread.join(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SimpleThread2 extends Thread {
    public static SimpleThread1 otherThread;

    @Override
    public void run() {
        
        for(int i = 2 ; i <= 10 ; i += 2) {
            System.out.println(i);
            try {
                otherThread.join(100);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}