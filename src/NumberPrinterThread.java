


public class NumberPrinterThread extends Thread{
    
    private int maxNumber;
    
    public NumberPrinterThread(int maxNumber, String threadName){
        super(threadName);
        this.maxNumber = maxNumber;
    } 
    
    @Override
    public void run(){
        for (int i = 1; i<= maxNumber; i++){
            System.out.println(getName()+ ": "+ i);
            try {
                Thread.sleep(1000);
            }catch(InterruptedException e) {
                System.out.println(Thread.currentThread().getName()+ " was interrupted.");
                Thread.currentThread().interrupt();
                break;
            }
        }
    
    }
    
    public static void main(String[] args) {
        NumberPrinterThread numberPrinterThread =  new NumberPrinterThread(10, "Number Printer Thread");
        numberPrinterThread.start();
    }
    
}
