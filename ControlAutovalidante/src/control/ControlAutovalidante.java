package control;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import logica.Logica;

public class ControlAutovalidante extends JPanel {

	private JTextField tbCajaText;
	private JLabel lblIndicador;
	private JLabel lblValidacion;
	private Logica logica;
	// indica que va a validar el control
	private String tipo;
	// dos atributos que puede utilizar el usuario
	public boolean correcto = false;
	public String mensaje = "No se ha validado";

	// getters y setter utilizados por el usuario que implemente el control
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
		// cambia el indicador cuando recibe un valor
		lblIndicador.setText("Validacion de  " + tipo);
	}

	public ControlAutovalidante() {
		setLayout(null);

		lblIndicador = new JLabel();
		lblIndicador.setBounds(36, 42, 138, 14);
		add(lblIndicador);

		lblValidacion = new JLabel(" ");
		lblValidacion.setBounds(389, 42, 129, 14);
		add(lblValidacion);

		tbCajaText = new JTextField();
		tbCajaText.addFocusListener(new FocusAdapter() {
			// valida el campo cuando se pierde el foco
			@Override
			public void focusLost(FocusEvent arg0) {
				if (tbCajaText.getText().equals("")) {
					lblValidacion.setText("La caja esta vac僘");
				} else {
					Validar(tipo, lblValidacion, tbCajaText, correcto, mensaje);
				}
			}
		});
		tbCajaText.setBounds(233, 39, 94, 20);
		add(tbCajaText);
		tbCajaText.setColumns(10);
	}

	// Pasa un patron a otro metodo segun que se quiere validar
	public void Validar(String tipo, JLabel etiqueta, JTextField caja, boolean correcto, String mensaje) {
		switch (tipo) {
		case "DNI":
			patron("[0-9]{8}[A-Z]", etiqueta, caja, correcto, mensaje);
			mensaje = "El DNI";
			break;
		case "CP":
			patron("0[1-9][0-9]{3}|[1-4][0-9]{4}|5[0-2][0-9]{3}", etiqueta, caja, correcto, mensaje);
			mensaje = "El Codigo Postal";
			break;
		case "tlf":
			patron("(\\+34|0034|34)?[ -]*(6|7)[ -]*([0-9][ -]*){8}", etiqueta, caja, correcto, mensaje);
			mensaje = "El telefono";
			break;
		}
	}

	// Utiliza la expresion regular para validar y cambiar los componentes graficos
	// recibidos ademas de los atributos
	private void patron(String patron, JLabel etiqueta, JTextField caja, boolean correcto, String mensaje) {
		Pattern pat = Pattern.compile(patron);
		Matcher match = pat.matcher(caja.getText());
		if (match.matches()) {
			etiqueta.setText("Validacion exitosa");
			mensaje += " es valido";
			correcto = true;
		} else {
			etiqueta.setText("Error de validacion");
			mensaje += " no es valido";
			correcto = false;
		}
	}

	public boolean isCorrecto() {
		return correcto;
	}

	public String getMensaje() {
		return mensaje;
	}

}