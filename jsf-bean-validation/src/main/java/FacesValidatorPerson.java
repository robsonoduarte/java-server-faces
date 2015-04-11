
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;

@FacesValidator(value="validatorPerson")
public class FacesValidatorPerson implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
		
		HtmlInputText htmlInputText = (HtmlInputText) component;
		
		
		javax.validation.Validator validator = 
				Validation.buildDefaultValidatorFactory().getValidator();
		
		Set<ConstraintViolation<Object>> constraints = validator.validateProperty(value, component.getId());
		
		if(constraints.size() > 0){
			htmlInputText.setStyleClass("error");			
			throw new ValidatorException(new FacesMessage());
		}
		
		
	}

}
