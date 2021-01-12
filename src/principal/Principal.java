package principal;

/*Chamado de Produtor e o Consumidor (também conhecido como o problema do buffer limitado),
consiste em um conjunto de processos que compartilham um mesmo buffer.
Os processos chamados produtores põem informação no buffer.
Os processos chamados consumidores retiram informação deste buffer.*/
public class Principal {

	private static class ExecutaSemaforo implements Runnable {

		private Semaforo s;

		public ExecutaSemaforo(Semaforo s) {

			this.s = s;
		}

		@Override
		public void run() {

			while (true) {

				try {

					s.consumir();
					Thread.sleep(1500);

				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {

		Buffer b = new Buffer();

		Semaforo s = new Semaforo(b, new Produtor(b), new Consumidor(b));

		new Thread(s).start();

		new Thread(new ExecutaSemaforo(s)).start();
	}
}