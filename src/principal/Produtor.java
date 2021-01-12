package principal;

public class Produtor {

	private Buffer buffer;

	public Produtor(Buffer buffer) {

		this.buffer = buffer;
	}

	public void produzir() {

		buffer.getBuffer().add("x");
		System.out.println(buffer.getBuffer());
	}
}