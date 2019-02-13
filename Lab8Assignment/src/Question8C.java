
class GenRandom implements Runnable{

	@Override
	public void run() {
		
		int n = (int) (10*Math.random());
		System.out.print(n + " : ");
		FindFact ff = new FindFact(n);
		Thread subThread = new Thread(ff);
		subThread.start();
	}
	
}

class FindFact implements Runnable{

	int n;
	public FindFact(int n) {
		this.n = n; 
	}
	@Override
	public void run() {
		int f=1;
		while(n>0) {
			f = f*n--;
		}
		System.out.println(f);
		
	}
	
}
public class Question8C {
	public static void main(String[] args) {
		
		GenRandom gr = new GenRandom();
		Thread thread = new Thread(gr);
		thread.start();
	}
}