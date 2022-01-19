package ventana;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import control.ControlAutovalidante;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 555, 421);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Formulario Prueba");
		lblTitulo.setBounds(226, 11, 87, 14);
		frame.getContentPane().add(lblTitulo);
		
		ControlAutovalidante cvDNI = new ControlAutovalidante();
		cvDNI.tipo = "DNI";
		cvDNI.setBounds(10, 36, 519, 93);
		frame.getContentPane().add(cvDNI);
		
		ControlAutovalidante cvCP = new ControlAutovalidante();
		cvCP.tipo = "CP";
		cvCP.setTipo("CP");
		cvCP.setBounds(10, 127, 519, 93);
		frame.getContentPane().add(cvCP);
		
		ControlAutovalidante cvtlf = new ControlAutovalidante();
		cvtlf.tipo = "tlf";
		cvtlf.setTipo("tlf");
		cvtlf.setBounds(10, 219, 519, 93);
		frame.getContentPane().add(cvtlf);
		
		JButton btnValidar = new JButton("Validar Formulario");
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cvDNI.isCorrecto()&&cvCP.isCorrecto()&&cvtlf.isCorrecto()) {
					ResultadoValidacion ventana = new ResultadoValidacion("Las validaciones se han ejecutado sin errores");
					ventana.show();
				}else {
					String errores = cvDNI.getMensaje() +"\n"+cvCP.getMensaje() +"\n"+cvtlf.getMensaje();
					ResultadoValidacion ventana = new ResultadoValidacion(errores);
					ventana.show();
				}
			}
		});
		btnValidar.setBounds(214, 323, 123, 23);
		frame.getContentPane().add(btnValidar);
	}
}
