package web.presentation.presenters;

import web.presentations.models.Model;

import java.util.List;

import rest.business.controllers.Controller;

public class ThemeManagerPresenter {

    public String process(Model model) {
        List<String> themes = (new Controller()).getThemes();
        for (String theme : themes) {
            model.put(theme, theme);
        }
        return "ThemeManagerView";
    }

    public String createTheme(Model model) {
        Controller controller = new Controller();
        String themeName = (String) model.get("themeName");
        controller.createTheme(themeName);
        model.getMap().clear();
        this.process(model);
        return "ThemeManagerView";
    }

}
