package rest.business.controllers;

import rest.business.models.entities.Theme;
import rest.business.views.ThemeTransfer;
import rest.models.data.daos.DaoFactory;
import rest.models.data.daos.ThemeDao;

public class Controller {

    public void createTheme(ThemeTransfer tt) {
        ThemeDao tDao = DaoFactory.getFactory().getThemeDao();
        int id = tDao.findAll().size();
        tDao.create(new Theme(id, tt.getName()));
    }
    
    

}
