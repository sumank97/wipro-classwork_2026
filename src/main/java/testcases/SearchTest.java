package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.SearchPage;

public class SearchTest extends BaseClass {

    @Test
    public void verifySearch() {

        SearchPage sp = new SearchPage(driver);

        sp.searchProduct();
    }
}