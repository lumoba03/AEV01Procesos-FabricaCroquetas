package aev01;

public class Procesadora implements Runnable {

	private String tipo;
	
	/**
	 * @param Nombre de la croqueta a procesar.
	 */
	public Procesadora(String tipo) {
		this.tipo=tipo;
	}
	
	/**
	 * A partir del objeto croqueta con el que se invoque establecerá un tiempo de fabricado (simulado) dependiendo del nombre de la croqueta.
	 */
	synchronized public void fabricarCroqueta() {
		switch (tipo) {
		case "jamon":
			try {
				Thread.sleep(5000);
				System.out.println("Croqueta de jamon terminada.");
			} catch (InterruptedException e) {
			}
			break;
		case "pollo":
			try {
				Thread.sleep(6000);
				System.out.println("Croqueta de pollo terminada.");
			} catch (InterruptedException e) {
			}
			break;
		case "bacalao":
			try {
				Thread.sleep(7000);
				System.out.println("Croqueta de bacalao terminada.");
			} catch (InterruptedException e) {
			}
			break;
		case "queso":
			try {
				Thread.sleep(8000);
				System.out.println("Croqueta de queso terminada.");
			} catch (InterruptedException e) {
			}
		}	
			
	}
	
	/**
	 * Pone el número de croquetas del nombre que introduzcas a cocinar, si llega a la capacidad máxima de 100 (101 ya que main es un hilo) hace una espera de tres segundos.
	 * 
	 * @param Número del tipo de croquetas a cocinar.
	 * @param Nombre del tipo de croqueta (jamon,pollo,bacalao,queso).
	 * @param Objeto procesadora.
	 */
	static private void cocinado(int numCroqueta, String nombreCroqueta, Procesadora procesadora) {
		
		for(int i=0;i<numCroqueta;i++) {
			int count=Thread.activeCount();
			while(count==101) {
				try {
					System.out.println("==================MAXIMO=====================");
					Thread.sleep(3000);
					count=Thread.activeCount();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			procesadora=new Procesadora(nombreCroqueta);
			Thread hilo=new Thread(procesadora);
			hilo.start();
			System.out.println("Comienza croqueta de "+nombreCroqueta+" "+i);
		}
	}

	public void run() {
		fabricarCroqueta();
	}

	public static void main(String[] args) {
		

		
		int jamonNo = Integer.parseInt(args[0]);
		int polloNo = Integer.parseInt(args[1]);
		int bacalaoNo = Integer.parseInt(args[2]);
		int quesoNo = Integer.parseInt(args[3]);
	
		Procesadora proc = null;
		
		cocinado(jamonNo, "jamon", proc);
		cocinado(polloNo, "pollo", proc);
		cocinado(bacalaoNo, "bacalao", proc);
		cocinado(quesoNo, "queso", proc);
		
		
}}
