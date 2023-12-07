package bo;

import bo.custom.Impl.CustomerBoImpl;
import bo.custom.Impl.ProductBoImpl;
import dao.util.BoType;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){

    }

    public static BoFactory getInstance(){
        return boFactory!=null? boFactory:(boFactory = new BoFactory());
    }

    public <T extends SuperBo>T getBo(BoType boType){
        switch (boType){
            case CUSTOMER:return (T) new CustomerBoImpl();
            case PRODUCTS:return (T) new ProductBoImpl();
        }
        return null;
    }
}
