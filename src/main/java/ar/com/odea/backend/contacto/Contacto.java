package ar.com.odea.backend.contacto;

import java.io.Serializable;
/**
 * 
 * @author fwermus
 *
 */
public class Contacto implements Serializable{
	private static final long serialVersionUID = 1665676492803399347L;
	public String apellido;
	public String nombre;
	
	public Contacto(String nombre, String apellido) {
		this.nombre=nombre;
		this.apellido=apellido;
	}

	public Contacto() {
		this.nombre="";
		this.apellido="";
	}
	public boolean equals(Object o){
		if (o instanceof Contacto){
			Contacto contacto=(Contacto)o;
			return (getNombre().equals(contacto.getNombre()) && getApellido().equals(contacto.getApellido()));
		}
		return false;
	}

	@Override
	public int hashCode() {
		return (nombre + apellido).hashCode();
	}
	
	private String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return nombre + " " + apellido;
	}
}
