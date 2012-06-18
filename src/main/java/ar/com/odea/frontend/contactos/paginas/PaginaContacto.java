package ar.com.odea.frontend.contactos.paginas;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import ar.com.odea.backend.contacto.Contacto;
import ar.com.odea.frontend.contactos.modelos.ModeloContacto;
import ar.com.odea.frontend.contactos.modelos.ModeloListaContactos;
import ar.com.odea.frontend.contactos.paneles.PanelEdicion;
import ar.com.odea.frontend.contactos.paneles.PanelListado;

/**
 * 
 * @author fwermus
 *
 */
public class PaginaContacto extends WebPage {
	private static final long serialVersionUID = 784088863912017093L;
	private PanelEdicion edicion;
	private PanelListado listado;
	
	public PaginaContacto(){
		super();
	    Model<ModeloListaContactos> mc=new Model<ModeloListaContactos>(new ModeloListaContactos());
	    setDefaultModel(mc);

		add(new WebMarkupContainer("contenedor").setOutputMarkupId(true));
		
		listado=new PanelListado("abm", mc){
			private static final long serialVersionUID = -786602874493487817L;

			@Override
			protected void nuevo(AjaxRequestTarget target) {
				PaginaContacto.this.mostrarPanelNuevo(target);
			}

			@Override
			protected void editar(AjaxRequestTarget target, IModel<ModeloContacto> model) {
				PaginaContacto.this.mostrarPanelEdicion(target, model);
			}
			
		};
		
		edicion=new PanelEdicion("abm", new Model<ModeloContacto>(new ModeloContacto(new Contacto()))){
			private static final long serialVersionUID = -2395102301787635397L;

			@Override
			protected void grabar(AjaxRequestTarget target,  IModel<ModeloContacto> model) {
				ModeloListaContactos mc=(ModeloListaContactos) PaginaContacto.this.getDefaultModelObject();
				mc.agregarSiNoExiste(model);
				PaginaContacto.this.mostrarPanelListado(target);
			}

			@Override
			protected void cancelar(AjaxRequestTarget target) {
				PaginaContacto.this.mostrarPanelListado(target);
			}
			
		};
		
		getContenedor().add(listado);

	}
	
	protected void mostrarPanelEdicion(AjaxRequestTarget target, IModel<ModeloContacto> model) {
		ModeloContacto mc=(ModeloContacto) edicion.getDefaultModelObject();
		ModeloContacto o=(ModeloContacto) model.getObject();
		mc.setContacto(o.getContacto());
		getContenedor().replace(edicion);
		target.addComponent(getContenedor());
	}

	protected void mostrarPanelListado(AjaxRequestTarget target) {
		getContenedor().replace(listado);	
		target.addComponent(getContenedor());
	}

	public void mostrarPanelNuevo(AjaxRequestTarget target) {
		ModeloContacto mc=(ModeloContacto) edicion.getDefaultModelObject();
		mc.setContacto(new Contacto());
		edicion.setDefaultModel(new Model<ModeloContacto>(mc));
		getContenedor().replace(edicion);
		target.addComponent(getContenedor());
	}
	
/*
 * GETTERS & SETTERS	
 */
	private WebMarkupContainer getContenedor() {
		return (WebMarkupContainer) get("contenedor");
	}
}
