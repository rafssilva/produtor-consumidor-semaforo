package principal;

import java.util.Vector;

public class Buffer {

	private final int tamanhoBuffer = 10;
	private Vector<String> buffer;	// Vector � como um List thread-safe (sincronizado para concorr�ncia)

	public Buffer() {

		buffer = new Vector<String>(tamanhoBuffer);
	}

	public Vector<String> getBuffer() {

		return buffer;
	}

	public int getTamanhoBuffer() {

		return tamanhoBuffer;
	}
}