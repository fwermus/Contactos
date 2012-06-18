package ar.com.odea.frontend.contactos.paneles;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import ar.com.odea.frontend.contactos.modelos.ModeloContacto;
/**
 * 
 * @author fwermus
 *
 */
public abstract class ItemContacto extends Panel {
	private static final long serialVersionUID = 4141810391797287052L;

	public ItemContacto(String id, IModel<ModeloContacto> model) {
		super(id);
		setOutputMarkupId(true);
		setDefaultModel(model);
		ModeloContacto mc=(ModeloContacto) model.getObject();
		add(new Label("txtNombre", mc.getNombreAsModel()));
		add(new Label("txtApellido", mc.getApellidoAsModel()));
		add(new AjaxLink<ModeloContacto>("btnEditar", model){
			private static final long serialVersionUID = -5438504169616257789L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				ItemContacto.this.editar(target, (IModel<ModeloContacto>) getDefaultModelObject());
			}
			
		});
	}
	public abstract void editar(AjaxRequestTarget target, IModel<ModeloContacto> model);
}
