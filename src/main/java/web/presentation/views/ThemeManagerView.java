package web.presentation.views;

import web.presentations.models.Model;

public class ThemeManagerView implements View {

    @Override
    public void show(Model model) {
        System.out.print("Theme Manager Page\n\t[");
        for (String name : model.getMap().keySet()) {
            System.out.print(model.getMap().get(name) + ", ");
        }
        System.out.println("]");
    }

}
