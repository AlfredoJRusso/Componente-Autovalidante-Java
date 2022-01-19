package logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Logica {
	
	//Pasa un patron a otro metodo segun que se quiere validar
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
	
	//Utiliza la expresion regular para validar y cambiar los componentes graficos recibidos ademas de los atributos
	private void patron(String patron, JLabel etiqueta, JTextField caja,  boolean correcto, String mensaje) {
		Pattern pat = Pattern.compile(patron);
		Matcher match = pat.matcher(caja.getText());
		if (match.matches()) {
			etiqueta.setText("Validacion exitosa");
			mensaje += " es valido";
			correcto = true;
		}else {
			etiqueta.setText("Error de validacion");
			mensaje += " no es valido";
			correcto = false;
		}	
	}
}
