package rest.models.data.daos;

public abstract class DaoFactory {
    
    protected static DaoFactory daoFactory;

    public abstract ThemeDao getThemeDao();
    
    public abstract VoteDao getVoteDao();
    
    public static void setFactory(DaoFactory daoFactory) {
        DaoFactory.daoFactory = daoFactory;
    }
    
    public static DaoFactory getFactory() {
        return DaoFactory.daoFactory;
    }

}
