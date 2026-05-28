package practiceMethod;

public class Calculation {
	int stockPrice=28;       //non static
	static int carPrice=40;  // static

	public static int getPricePen() {
		Calculation c1=new Calculation();
		int capPrice=2;
		int penBodyPrice=5;
		
		//carPrice=40;
		return c1.stockPrice+carPrice+capPrice + penBodyPrice;
		

	}
}
