package principal;

public class Consumidor {

	private Buffer buffer;

	public Consumidor(Buffer buffer) {

		this.buffer = buffer;
	}

	public void consumir() {

		buffer.getBuffer().remove(0);
		System.out.println(buffer.getBuffer());
	}
}