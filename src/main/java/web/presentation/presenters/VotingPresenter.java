package web.presentation.presenters;

import java.util.List;

import rest.business.controllers.Controller;
import rest.business.views.ThemeTransfer;
import rest.business.views.VoteTransfer;
import web.presentations.models.Model;

public class VotingPresenter {

    public String process(Model model) {
        List<ThemeTransfer> themes = (new Controller()).getVotes();
        for (ThemeTransfer theme : themes) {
            model.put(theme.getName(), theme);
        }
        return "VotingView";
    }

    public String voteTheme(Model model) {
        Controller controller = new Controller();
        double note = Integer.valueOf((String) model.get("voteValue"));
        VoteTransfer vt = new VoteTransfer((String)model.get("themeName"), note);
        controller.vote(vt);
        model.getMap().clear();
        this.process(model);
        return "VotingView";
    }

}
