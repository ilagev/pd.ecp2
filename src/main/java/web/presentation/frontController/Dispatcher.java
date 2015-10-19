package web.presentation.frontController;

import web.http.HttpRequest;
import web.http.HttpResponse;
import web.presentation.presenters.ThemeManagerPresenter;
import web.presentation.presenters.VotingPresenter;
import web.presentations.models.Model;
import web.presentation.views.ErrorView;
import web.presentation.views.ThemeManagerView;
import web.presentation.views.View;
import web.presentation.views.VotingView;

public class Dispatcher {

    public void doGet(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String path = request.getPath();
        String nextView = "";
        
        switch (path) {
        case "ThemeManager":
            ThemeManagerPresenter tmPresenter = new ThemeManagerPresenter();
            nextView = tmPresenter.process(model);
            break;
        case "Voting":
            VotingPresenter vPresenter = new VotingPresenter();
            nextView = vPresenter.process(model);
            break;
        }
        this.show(nextView, model);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        Model model = new Model();
        String controller = request.getPath();
        String action = request.getParams().get("action");
        String theme = request.getParams().get("themeName");
        String vote = request.getParams().get("value");
        String nextView = request.getPath() + "View";

        switch (controller) {
        case "ThemeManager":
            ThemeManagerPresenter tmPresenter = new ThemeManagerPresenter();
            model.put("themeName", theme);
            if ("createTheme".equals(action)) {
                nextView = tmPresenter.createTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        case "Voting":
            VotingPresenter vPresenter = new VotingPresenter();
            model.put("themeName", theme);
            model.put("voteValue", vote);
            if ("voteTheme".equals(action)) {
                nextView = vPresenter.voteTheme(model);
            } else {
                model.put("error", "Acción no permitida: " + action);
            }
            break;
        }
        this.show(nextView, model);
    }
    
    private void show(String nextView, Model model) {
        View view;
        switch (nextView) {
        case "ThemeManagerView":
            view = new ThemeManagerView();
            break;
        case "VotingView":
            view = new VotingView();
            break;
        default:
            view = new ErrorView();
            model.put("error", "Vista no encontrada: " + nextView);
        }
        view.show(model);
    }

}
