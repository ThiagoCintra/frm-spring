package br.com.cintra.test_pages.herokuapp;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Scope;
import br.com.cintra.helper.page.PageBuilder;
import br.com.cintra.interfaces.annotation.element.SearchAll;
import br.com.cintra.interfaces.annotation.element.SearchWith;
import br.com.cintra.interfaces.annotation.page.Page;

@Page(name = "homePage")
@Scope("prototype")
public class HomePage extends PageBuilder{
		
	@SearchAll()
	List<WebElement> todos_os_elementos_ignorando_elementos;
	
}
