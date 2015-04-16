package br.com.mystudies.jsf.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validatorPerson")
public class FacesValidatorPerson implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		HtmlInputText htmlInputText = (HtmlInputText) component;
		
		if(value == null){
			htmlInputText.setStyleClass(htmlInputText.getStyleClass().concat(" error"));
			throw new ValidatorException(new FacesMessage());
		}else{
			htmlInputText.setStyleClass("form-control");
		}
	}

}
