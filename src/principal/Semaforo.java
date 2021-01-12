package principal;

public class Semaforo implements Runnable {

	private Buffer b;
	private Produtor p;
	private Consumidor c;

	public Semaforo(Buffer b, Produtor p, Consumidor c) {

		this.b = b;
		this.p = p;
		this.c = c;
	}

	private synchronized void produzir() throws InterruptedException {

		if (b.getBuffer().size() == b.getTamanhoBuffer())
			wait();

		p.produzir();
		notify();
	}

	public synchronized void consumir() throws InterruptedException {

		if (b.getBuffer().size() == 0)
			wait();

		c.consumir();
		notify();
	}

	@Override
	public void run() {

		while (true) {

			try {

				produzir();
				Thread.sleep(500);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}