package br.com.senai.fatesg.primefaces.util;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;	
import br.com.senai.fatesg.primefaces.entidade.Liga;
import br.com.senai.fatesg.primefaces.persistencia.LigaDaoJpa;



@FacesConverter("generic")
public class LigaConverter implements Converter{
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
	    if (value != null && value.trim().length() > 0) {
	        
	            return new LigaDaoJpa().consultar(Integer.parseInt(value));
	      
	    } else {
	        return null;
	    }
	}
	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object object) {
	    if (object != null && object instanceof Liga) {
	    	  return String.valueOf(((Liga) object).getId());
	    }
	    return null;

	}
}