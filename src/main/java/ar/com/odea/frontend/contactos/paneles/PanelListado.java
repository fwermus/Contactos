package ar.com.odea.frontend.contactos.paneles;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import ar.com.odea.backend.contacto.Contacto;
import ar.com.odea.frontend.contactos.modelos.ModeloContacto;
import ar.com.odea.frontend.contactos.modelos.ModeloListaContactos;
/**
 * 
 * @author fwermus
 *
 */
public abstract class PanelListado extends Panel {
	private static final long serialVersionUID = -8315632128973190536L;

	public PanelListado(String id, IModel<ModeloListaContactos> modelo) {
		super(id);
	    setDefaultModel(modelo);
	    ModeloListaContactos mc=modelo.getObject();
	    
		add(new AjaxLink<ModeloListaContactos>("btnNuevoArriba"){
			private static final long serialVersionUID = -5438504169616257789L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				PanelListado.this.nuevo(target);
			}
			
		});


		add(new ListView<Contacto>("grid", mc.getContactosAsModel()){
			private static final long serialVersionUID = -2192871996516628494L;

			@Override
			protected void populateItem(ListItem<Contacto> item) {
				item.add(new ItemContacto("itemContacto", new Model<ModeloContacto>(new ModeloContacto(item.getDefaultModelObject()))){
					private static final long serialVersionUID = 6561539083557720184L;

					@Override
					public void editar(AjaxRequestTarget target, IModel<ModeloContacto> model) {
						PanelListado.this.editar(target, model);
					}
					
				});
			}
			
		});
		
		add(new AjaxLink<ModeloListaContactos>("btnNuevoAbajo"){
			private static final long serialVersionUID = -5438504169616257789L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				PanelListado.this.nuevo(target);
			}
			
		});
	}
	protected abstract void nuevo(AjaxRequestTarget target);
	protected abstract void editar(AjaxRequestTarget target, IModel<ModeloContacto> modelo);
}
