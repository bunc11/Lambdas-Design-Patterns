import java.util.function.Consumer;

/*
 * 
 * this would be "standard" way of doing it
 * constr is public and resource management is consumer responsibility
 * 
 * 
class Resource {
	public Resource() {
		System.out.println("Created");
	}
	
	public void op1() {
		System.out.println("op1");
	}
	
	public void op2() {
		System.out.println("op1");
	}
	
	/*
	public void finalize() {
		System.out.println("Cleanup....");
	}
	
	public void close() {
		System.out.println("Cleanup....");
	}
	
}
*/

class Resource {

	/*
	 * here constr is private and resource management is taken care of inside class
	 * outside interface is "use" method -> this is execute around method
	 */

	static void use(Consumer<Resource> block) {

		Resource resource = new Resource();

		try {
			block.accept(resource);
		} finally {
			resource.close();
		}
	}

	private Resource() {
		System.out.println("Created");
	}

	public Resource op1() {
		System.out.println("op1");
		return this;
	}

	public Resource op2() {
		System.out.println("op1");
		return this;
	}

	private void close() {
		System.out.println("Cleanup....");
	}

}

public class ExecuteAroundMethod {

	public static void main(String[] args) {

		/*
		 * "standard" way
		 */

		// Resource resource = new Resource();
		// resource.op1();
		// resource.op2();

		// resource.close();

		// easy to forget close.... what if exception is thorwn

		// can we reuse resource? we don't know

		// execute around
		// aka loan pattern

		Resource.use(resource -> resource.op1().op2());
	}

}
