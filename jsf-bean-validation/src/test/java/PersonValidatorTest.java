import static junit.framework.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.validator.Validator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import br.com.mystudies.jsf.Person;


public class PersonValidatorTest {

	
	
	private Validator validator;
	
	@Mock
	private UIComponent uiComponent; 
	
	@Mock
	private UIInput uiInput;
	
	// cara tem aquele lib que da um up no JSF acho que é prittyfaces tá no backlog na base..
	@Before
	public void setUp() throws Exception {
		validator = new FacesValidatorPerson();
		initMocks(this);
	}

	
	
	@Test(/*expected=ValidatorException.class*/)
	public void test() {
		
		HtmlInputText htmlInputText = new HtmlInputText();
		
		htmlInputText.setId("name");
		
		try {
			validator.validate(null, htmlInputText, new Person());
		} catch (Exception exception) {
			
		}
		
		assertEquals(htmlInputText.getStyleClass(), "error");
	}

	
}
