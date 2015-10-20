package web.presentation.presenters;

import java.util.List;

import rest.business.controllers.Controller;
import rest.business.views.ThemeTransfer;
import web.presentations.models.Model;

public class VotingPresenter {

    public String process(Model model) {
        List<ThemeTransfer> themes = (new Controller()).getVotes();
        for (ThemeTransfer theme : themes) {
            model.put(theme.getName(), theme);
        }
        return "Voting";
    }

    public String voteTheme(Model model) {
        Controller controller = new Controller();
        ThemeTransfer tt = new ThemeTransfer((String)model.get("themeName"), (Double)model.get("voteValue"));
        controller.vote(tt);
        model.getMap().clear();
        this.process(model);
        return "Voting";
    }

}
