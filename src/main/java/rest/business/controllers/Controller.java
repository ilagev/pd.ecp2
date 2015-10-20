package rest.business.controllers;

import rest.business.models.entities.Theme;
import rest.business.models.entities.Vote;
import rest.business.views.ThemeTransfer;
import rest.business.views.VoteTransfer;
import rest.models.data.daos.DaoFactory;
import rest.models.data.daos.ThemeDao;
import rest.models.data.daos.VoteDao;

import java.util.ArrayList;
import java.util.List;

public class Controller {

    public List<String> getThemes() {
        List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        List<String> themeNames = new ArrayList<String>();
        
        for (Theme theme : themes) {
            themeNames.add(theme.getName());
        }
        return themeNames;
    }

    public void createTheme(String themeName) {
        ThemeDao tDao = DaoFactory.getFactory().getThemeDao();
        int id = tDao.findAll().size();
        tDao.create(new Theme(id, themeName));
    }

    public List<ThemeTransfer> getVotes() {
        List<Vote> votes = DaoFactory.getFactory().getVoteDao().findAll();
        List<Theme> themes = DaoFactory.getFactory().getThemeDao().findAll();
        List<ThemeTransfer> ttl = new ArrayList<ThemeTransfer>();

        for (Theme theme : themes) {
            ttl.add(new ThemeTransfer(theme.getName(), this.average(votes, theme.getName())));
        }
        return ttl;
    }

    private double average(List<Vote> votes, String theme) {
        double amount = 0.0;
        int numberVotes = 0;
        for (Vote vote : votes) {
            if (vote.getTheme().getName() == theme) {
                amount += vote.getVote();
                numberVotes++;
            }
        }
        return amount / numberVotes;
    }

    public void vote(VoteTransfer vt) {
        VoteDao vDao = DaoFactory.getFactory().getVoteDao();
        ThemeDao tDao = DaoFactory.getFactory().getThemeDao();
        int id = vDao.findAll().size();
        vDao.create(new Vote(id, (int) vt.getNote(), tDao.findByName(vt.getName())));
    }

}
