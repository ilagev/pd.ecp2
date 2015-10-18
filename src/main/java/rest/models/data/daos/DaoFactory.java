package rest.models.data.daos;

public abstract class DaoFactory {

    public abstract ThemeDao getThemeDao();
    
    public abstract VoteDao getVoteDao();
    
    public static void setFactory(DaoFactory daoFactory) {
        
    }

}
