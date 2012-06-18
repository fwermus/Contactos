package ar.com.odea.frontend.contactos.paneles;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import ar.com.odea.backend.contacto.Contacto;
import ar.com.odea.frontend.contactos.modelos.ModeloContacto;
import ar.com.odea.frontend.contactos.modelos.ModeloListaContactos;
/**
 * 
 * @author fwermus
 *
 */
public abstract class PanelEdicion extends Panel {
	private static final long serialVersionUID = -6051950212520006816L;
	
	public PanelEdicion(String id, final IModel<ModeloContacto> model) {
		super(id);
		setOutputMarkupId(true);
		setDefaultModel(model);
		
		ModeloContacto mc=model.getObject();
		add(new Form<ModeloContacto>("frmEdicion"));
		
		getForm().add(new TextField<Contacto>("txtNombre", mc.getNombreAsModel()));
		getForm().add(new TextField<Contacto>("txtApellido", mc.getApellidoAsModel()));	
		getForm().add(new AjaxButton("btnGrabar") {
			private static final long serialVersionUID = -3805690819431125792L;

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
					PanelEdicion.this.grabar(target,  model);		
			}
		});
		getForm().add(new AjaxLink<ModeloListaContactos>("btnCancelar") {
			private static final long serialVersionUID = 884734496729264100L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				PanelEdicion.this.cancelar(target);
			}
		});
	}
	@SuppressWarnings("unchecked")
	public Form<ModeloListaContactos> getForm(){
		return  (Form<ModeloListaContactos>) get("frmEdicion");
	}

	protected abstract void cancelar(AjaxRequestTarget target);
	protected abstract void grabar(AjaxRequestTarget art, IModel<ModeloContacto> mea);
	


}
