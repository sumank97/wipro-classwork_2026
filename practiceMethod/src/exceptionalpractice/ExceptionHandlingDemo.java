package exceptionalpractice;

public class ExceptionHandlingDemo {

	public static void main(String[] args) {
		
		ExceptionHandlingDemo e1=new ExceptionHandlingDemo();
         e1.method1();
	}
	
    private void method1() {
    	method2();
    }
    
    private void method2() {
    	method3();
    }
	private void method3() {
		int a=5/0;
	}

}
