package web.presentation.presenters;

import web.presentations.models.Model;
import rest.business.controllers.Controller;
import rest.business.views.ThemeTransfer;

public class ThemeManagerPresenter {

    public String process(Model model) {
        // TODO Auto-generated method stub
        return null;
    }

    public String createTheme(Model model) {
        Controller controller = new Controller();
        ThemeTransfer tt = new ThemeTransfer((String) model.get("themeName"));
        controller.createTheme(tt);
        return "ThemeManagerView";
    }

}
