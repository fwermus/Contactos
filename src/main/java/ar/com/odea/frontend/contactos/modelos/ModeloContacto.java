package ar.com.odea.frontend.contactos.modelos;

import java.io.Serializable;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import ar.com.odea.backend.contacto.Contacto;
/**
 * 
 * @author fwermus
 *
 */
public class ModeloContacto implements Serializable{
	private static final long serialVersionUID = -4808113123476897583L;
	
	private Contacto contacto;

	public ModeloContacto(Contacto contacto){
		this.contacto=contacto;
	}
	public ModeloContacto(Object contacto){
		this.contacto=(Contacto) contacto;
	}
	
	public Contacto getContacto() {
		return contacto;
	}

	public void setContacto(Contacto contacto) {
		this.contacto = contacto;
	}

	public IModel<Contacto> getNombreAsModel() {
		return new PropertyModel<Contacto>(this, "contacto.nombre");
	}

	public IModel<Contacto> getApellidoAsModel() {
		return new PropertyModel<Contacto>(this, "contacto.apellido");
	}
	
}
