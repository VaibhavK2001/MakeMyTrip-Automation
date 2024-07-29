package mmt.pages;

import mmt.base.Base;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static mmt.base.Base.driver;

public class HomePage extends Base{

    public HomePage() throws IOException {
        super();
        PageFactory.initElements(driver,this);
    }

}
