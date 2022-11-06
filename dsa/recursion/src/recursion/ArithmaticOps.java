package recursion;

public class ArithmaticOps {
	
	static int multiply(int m, int n) {
		if (m < 0 || n < 0) {
			m = Math.abs(m);
			n = Math.abs(n);
		}
		if (m < n) {
			m = m + n;
			n = m - n;
			m = m - n;
		}
		
		if (n == 1) return m;
		return m + multiply(m, n-1);
	}
	
	static int divide(int m, int n) {
		if (n == 0) return (int)Math.random();
		if (m < 0 || n < 0) {
			m = Math.abs(m);
			n = Math.abs(n);
		}
		
		if (m < n) return 0;
		return 1 + divide(m - n, n);
	}
	
	static int remainder(int m, int n) {
		if (n == 0) return (int)Math.random();
		if (m < 0 || n < 0) {
			m = Math.abs(m);
			n = Math.abs(n);
		}
		
		if (m < n) return m;
		return remainder(m - n, n);
	}
	
	public static void main(String[] args) {
		System.out.println(multiply(100,4));
		System.out.println(divide(100,4));
		System.out.println(remainder(101,4));
	}
	
}
