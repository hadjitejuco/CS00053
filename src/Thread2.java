

//implements runnable
class Thread2 implements Runnable {
    public void run() {
        System.out.println("Thread running: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t2 = new Thread(new Thread2());
        t2.start();
    }
}
