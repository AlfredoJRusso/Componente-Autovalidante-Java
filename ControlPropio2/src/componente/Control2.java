package componente;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.Logica;

public class Control2 extends JPanel {


	private JTextField tbCajaText;
	private JLabel lblIndicador;
	private JLabel lblValidacion;
	private Logica logica;
	//indica que va a validar el control
	public String tipo;
	//dos atributos que puede utilizar el usuario
	public boolean correcto = false;
	public String mensaje = "No se ha validado";
	
	public Control2() {
		setLayout(null);
		
		lblIndicador = new JLabel("Validacion de "+ tipo);
		lblIndicador.setBounds(36, 42, 138, 14);
		add(lblIndicador);
		
		
		
		lblValidacion = new JLabel(" ");
		lblValidacion.setBounds(389, 42, 129, 14);
		add(lblValidacion);

		tbCajaText = new JTextField();
		tbCajaText.addFocusListener(new FocusAdapter() {
			//valida el campo cuando se pierde el foco
			@Override
			public void focusLost(FocusEvent arg0) {
				if(tbCajaText.getText().equals("")) {
					lblValidacion.setText("La caja esta vacía");
				}else {
					logica.Validar(tipo, lblValidacion, tbCajaText, correcto, mensaje);
				}
			}
		});
		tbCajaText.setBounds(233, 39, 94, 20);
		add(tbCajaText);
		tbCajaText.setColumns(10);
	}
	//getters y setter utilizados por el usuario que utilize el control
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public boolean isCorrecto() {
		return correcto;
	}

	public String getMensaje() {
		return mensaje;
	}

}
