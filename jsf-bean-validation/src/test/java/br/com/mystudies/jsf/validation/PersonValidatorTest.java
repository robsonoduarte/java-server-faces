package br.com.mystudies.jsf.validation;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.MockitoAnnotations.initMocks;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.validator.Validator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


public class PersonValidatorTest {

	
	
	private Validator validator;
	
	@Mock
	private UIComponent uiComponent; 

	
	HtmlInputText htmlInputText;
	
	// cara tem aquele lib que da um up no JSF acho que é prittyfaces tá no backlog na base..
	@Before
	public void setUp() throws Exception {
		validator = new FacesValidatorPerson();
		htmlInputText = new HtmlInputText();
		initMocks(this);
	}

	
	
	@Test()
	public void testAddClassError() {
		
		try {
			htmlInputText.setStyleClass("form-control");
			validator.validate(null, htmlInputText, null);
		} catch (Exception exception) {
			// TODO: handle exception
		}
		
		assertThat(htmlInputText.getStyleClass(), equalTo("form-control error"));		
	}
	
	
	
	@Test()
	public void testRemoveClassErro() {		
		
		try {
			htmlInputText.setStyleClass("form-control error");
			validator.validate(null, htmlInputText, "value");
		} catch (Exception exception) {
			// TODO: handle exception
		}
		
		assertThat(htmlInputText.getStyleClass(), equalTo("form-control"));		
	}
	
	
}
