package rest.models.data.daos.memory;

import rest.models.data.daos.DaoFactory;
import rest.models.data.daos.ThemeDao;
import rest.models.data.daos.VoteDao;

public class DaoFactoryMemory extends DaoFactory {

    private ThemeDao themeDao;

    private VoteDao voteDao;

    public DaoFactoryMemory() {
    }

    @Override
    public ThemeDao getThemeDao() {
        if (themeDao == null) {
            themeDao = new ThemeMemoryDao();
        }
        return themeDao;
    }

    @Override
    public VoteDao getVoteDao() {
        if (voteDao == null) {
            voteDao = new VoteMemoryDao();
        }
        return voteDao;
    }

}
