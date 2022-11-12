package aev01;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class Lanzadora {

	private JFrame frmFabricadorDeCroquetas;
	private JTextField jamon_Tf;
	private JTextField pollo_Tf;
	private JTextField bacalao_Tf;
	private JTextField queso_Tf;
	private long tiempoInicio,tiempoFinaliz;


	/**
	 * Construye y lanza un proceso con el número de croquetas de cada tipo.
	 * @param Número de croquetas de jamón.
	 * @param Número de croquetas de pollo.
	 * @param Número de croquetas de bacalao.
	 * @param Número de croquetas de queso.
	 */
	public void ejecutar(int jamon, int pollo, int bacalao, int queso) {
		String clase = "aev01.Procesadora";

	       try {
	            String javaHome = System.getProperty("java.home");
	            String javaBin  = javaHome + File.separator + "bin" + File.separator + "java";
	            String classPath = System.getProperty("java.class.path");
	            String className = clase;
	            
	            List<String> command  =new ArrayList<>();
	            command.add(javaBin);
	            command.add("-cp");
	            command.add(classPath);
	            command.add(className);
	            command.add(String.valueOf(jamon));
	            command.add(String.valueOf(pollo));
	            command.add(String.valueOf(bacalao));
	            command.add(String.valueOf(queso));
	            
	            Process p;
	            ProcessBuilder builder = new ProcessBuilder(command);
	            // Recoge el tiempo cuando se inicia el proceso.
	            tiempoInicio=System.currentTimeMillis();
	            p=builder.inheritIO().start();
	            p.waitFor();
	            // Recoge el tiempo cuando se finaliza el proceso.
	            tiempoFinaliz=System.currentTimeMillis();
	            
	            // Resta el tiempo de cuando inicia y finaliza los procesos para devolver la diferencia en una ventana emergente.
	            JOptionPane.showMessageDialog(null, "Tiempo de fabricacion: "+(tiempoFinaliz-tiempoInicio)/1000 +"segundos");
	        }catch (Exception e) {
	            e.printStackTrace();
	        }}

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadora window = new Lanzadora();
					window.frmFabricadorDeCroquetas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Lanzadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFabricadorDeCroquetas = new JFrame();
		frmFabricadorDeCroquetas.setTitle("Fabricador de croquetas");
		frmFabricadorDeCroquetas.setBounds(100, 100, 383, 353);
		frmFabricadorDeCroquetas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFabricadorDeCroquetas.getContentPane().setLayout(null);

		jamon_Tf = new JTextField();
		jamon_Tf.setBounds(170, 82, 96, 28);
		frmFabricadorDeCroquetas.getContentPane().add(jamon_Tf);
		jamon_Tf.setColumns(10);

		JLabel lblNewLabel = new JLabel("Jamón:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(100, 79, 60, 28);
		frmFabricadorDeCroquetas.getContentPane().add(lblNewLabel);

		JLabel lblPollo = new JLabel("Pollo:");
		lblPollo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPollo.setBounds(100, 120, 60, 28);
		frmFabricadorDeCroquetas.getContentPane().add(lblPollo);

		pollo_Tf = new JTextField();
		pollo_Tf.setColumns(10);
		pollo_Tf.setBounds(170, 123, 96, 28);
		frmFabricadorDeCroquetas.getContentPane().add(pollo_Tf);

		JLabel lblBacalao = new JLabel("Bacalao:");
		lblBacalao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBacalao.setBounds(100, 158, 60, 28);
		frmFabricadorDeCroquetas.getContentPane().add(lblBacalao);

		bacalao_Tf = new JTextField();
		bacalao_Tf.setColumns(10);
		bacalao_Tf.setBounds(170, 161, 96, 28);
		frmFabricadorDeCroquetas.getContentPane().add(bacalao_Tf);

		JLabel lblQueso = new JLabel("Queso:");
		lblQueso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQueso.setBounds(100, 196, 60, 28);
		frmFabricadorDeCroquetas.getContentPane().add(lblQueso);

		queso_Tf = new JTextField();
		queso_Tf.setColumns(10);
		queso_Tf.setBounds(170, 199, 96, 28);
		frmFabricadorDeCroquetas.getContentPane().add(queso_Tf);

		JLabel lblNewLabel_1 = new JLabel("Croquequinator-6700");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(10, 0, 359, 69);
		frmFabricadorDeCroquetas.getContentPane().add(lblNewLabel_1);

		JButton btnIniciar = new JButton("Encroquetar");
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIniciar.setBounds(100, 250, 166, 41);
		frmFabricadorDeCroquetas.getContentPane().add(btnIniciar);

		// Lanzar
		btnIniciar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				/*Una vez pulsado el botón comprueba si los campos están vacios para que no de error a la hora de hacer un parse,
				 * en el caso de estar vacío el valor será de 0.*/

				String jamonTxt = jamon_Tf.getText();
				String polloTxt = pollo_Tf.getText();
				String bacalaoTxt = bacalao_Tf.getText();
				String quesoTxt = queso_Tf.getText();
				int jamonNo, polloNo, bacalaoNo, quesoNo;
				
				if (jamonTxt.isEmpty() == true) {
					jamonNo = 0;
				}
				else
				{jamonNo = Integer.parseInt(jamonTxt); }
				
				if (polloTxt.isEmpty() == true) {
					polloNo = 0;
				}
				else
				{polloNo = Integer.parseInt(polloTxt); }
				
				if (bacalaoTxt.isEmpty() == true) {
					bacalaoNo = 0;
				}
				else
				{bacalaoNo = Integer.parseInt(bacalaoTxt); }
				
				if (quesoTxt.isEmpty() == true) {
					quesoNo = 0;
				}
				else
				{quesoNo = Integer.parseInt(quesoTxt); }
				
				
				ejecutar(jamonNo,polloNo,bacalaoNo,quesoNo);

			}
		});
	}
}
