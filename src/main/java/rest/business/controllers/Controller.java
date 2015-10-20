package rest.business.controllers;

import rest.business.models.entities.Theme;
import rest.business.views.ThemeTransfer;
import rest.models.data.daos.DaoFactory;
import rest.models.data.daos.ThemeDao;

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
        // TODO Auto-generated method stub
        return null;
    }

    public void vote(ThemeTransfer tt) {
        // TODO Auto-generated method stub
        
    }

    

}
