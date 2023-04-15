package App.DAO;

import App.db.DB;

public class FactoryDAO {
    public static RegisterDAO createRegisterDAO(){
        return new RegisterDaoJDBC(DB.getConnection());
    }
}
