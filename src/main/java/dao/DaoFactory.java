package dao;

import bo.BoFactory;
import bo.SuperBo;
import bo.custom.Impl.CustomerBoImpl;
import dao.custom.impl.CustomerDaoImpl;
import dao.util.BoType;
import dao.util.DaoType;

public class DaoFactory {
    private static DaoFactory daoFactory;
    private DaoFactory(){

    }

    public static DaoFactory getInstance(){
        return daoFactory!=null? daoFactory:(daoFactory = new DaoFactory());
    }

    public <T extends SuperDao>T getDao(DaoType daoType){
        switch (daoType){
            case CUSTOMER:return (T) new CustomerDaoImpl();
        }
        return null;
    }
}
