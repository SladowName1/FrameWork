package service;

import model.Item;
import static util.Resolver.resolveTemplate;


public class ItemCreator {
    private static final String NAME="testdata.item.%s.name";
    private static final String PRICE="testdata.item.%s.price";
    private static final String URI="testdata.item.%s.uri";

    public static Item withCredentialsFromProperty(String orderNumber){
        orderNumber=orderNumber.toLowerCase();
        return new Item(TestDataReader.getItem(resolveTemplate(NAME,orderNumber)),
                TestDataReader.getItem(resolveTemplate(PRICE,orderNumber)),
                TestDataReader.getItem(resolveTemplate(URI,orderNumber)));
    }
}
