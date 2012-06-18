package ar.com.odea.frontend;

import org.apache.wicket.protocol.http.WebApplication;

import ar.com.odea.frontend.contactos.paginas.PaginaContacto;

/**
 * 
 * @author fwermus
 *
 */
public class WicketApplication extends WebApplication
{    
    /**
     * Constructor
     */
	public WicketApplication()
	{
	}
	
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	public Class<PaginaContacto> getHomePage()
	{
		return PaginaContacto.class;
	}

}
