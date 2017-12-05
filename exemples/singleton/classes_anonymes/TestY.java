public class TestY {
    public static void main(String args[]) {
	I v1 = new I() {
		public int operation(int a){
		    return a+1;
		}
	    };
	I v2 = new I() {
		public int operation(int a){
		    return a*a;
		}
	    };
	System.out.println(v1.operation(10));
	System.out.println(v2.operation(10));
    }
}
