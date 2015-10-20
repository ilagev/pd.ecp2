package web.presentation.views;

import web.presentations.models.Model;

public class VotingView implements View {

    @Override
    public void show(Model model) {
        System.out.print("Voting Page\n\t[");
        int size = model.getMap().keySet().size(), i = 0;
        for (String name : model.getMap().keySet()) {
            System.out.print(model.getMap().get(name).toString());
            if (i < size - 1) {
                System.out.print(", ");
                i++;
            }
        }
        System.out.println("]");
    }

}
