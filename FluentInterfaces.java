import java.util.function.Consumer;

/*
class Mailer {
	public static void print(String msg) { System.out.println(msg); }
	
	public void from(String addr) {
		print("From");
	}
	public void to(String addr) {
		print("to");
	}
	public void subject(String addr) {
		print("subject");
	}
	public void body(String addr) {
		print("body");
	}
	public void send() {
		print("sending...");
	}
}
*/

class Mailer {

	private Mailer() {
	}

	public static void print(String msg) {
		System.out.println(msg);
	}

	public Mailer from(String addr) {
		print("From");
		return this;
	}

	public Mailer to(String addr) {
		print("to");
		return this;
	}

	public Mailer subject(String addr) {
		print("subject");
		return this;
	}

	public Mailer body(String addr) {
		print("body");
		return this;
	}

	public static void send(Consumer<Mailer> block) {

		Mailer mailer = new Mailer();
		block.accept(mailer);

		print("sending...");
	}
}

public class FluentInterfaces {

	public static void main(String[] args) {

		/*
		 * Mailer mailer = new Mailer(); mailer.from("developer.com");
		 * mailer.to("someMail@gamil.com"); mailer.subject("code rewiew");
		 * mailer.send();
		 */

		// can i reuse mailer here? i don't know!!!!

		// would be nice to have only one way to do this

		// cascade method pattern -> aka builder pattern

		// should refactor methods to return Mailer
		/*
		 * new Mailer().from("string").to("string")....send();
		 */

		// and with lambdas ->

		Mailer.send(mailer -> mailer.from("String").to("String").subject("String").body("String"));

	}

}
