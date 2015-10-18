package rest.models.data.daos;

import rest.business.models.entities.Theme;
import java.util.List;

public interface ThemeDao {
    
    public Theme findByName(String themeName);
    
    public List<String> findAllNames();

}
