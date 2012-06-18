package ar.com.odea.frontend.contactos.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import ar.com.odea.backend.contacto.Contacto;
/**
 * 
 * @author fwermus
 *
 */
public class ModeloListaContactos implements Serializable{
	private static final long serialVersionUID = 6490444784091642664L;
	
	private List<Contacto> contactos=new ArrayList<Contacto>(); 

	public IModel<List<Contacto>> getContactosAsModel(){
		return new PropertyModel<List<Contacto>>(this, "contactos");
	}

	public void agregarSiNoExiste(IModel<ModeloContacto> model) {
		if (contactos.contains(model.getObject().getContacto())){
			return;
		}
		contactos.add(model.getObject().getContacto());
	}

	protected List<Contacto> load() {
		return contactos;
	}

	
}
