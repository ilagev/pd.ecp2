package web.presentation.views;

import web.presentations.models.Model;

public class VotingView implements View {

    @Override
    public void show(Model model) {
        System.out.print("Voting Page\n\t[");
        for (String name : model.getMap().keySet()) {
            System.out.print(model.getMap().get(name).toString() + ", ");
        }
        System.out.println("]");
    }

}
