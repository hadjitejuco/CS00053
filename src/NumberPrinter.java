
//threads -> implements runnable

public class NumberPrinter implements Runnable {
    
    private int maxNumber;
    
    public NumberPrinter(int maxNumber){
        this.maxNumber = maxNumber;
    }
    
    @Override
    public void run(){
        for (int i = 1; i<= maxNumber; i++){
            System.out.println(Thread.currentThread().getName()+ ": " + i);
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+ " was interrupted.");
            }
        }    
    }
    
    public static void main(String[] args) {
        Thread thread = new Thread(new NumberPrinter(10)," Number Printer Thread");
        thread.start();
        
    }
}
