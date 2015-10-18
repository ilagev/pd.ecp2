package rest.models.data.daos;

import java.util.List;

import rest.business.models.entities.Theme;
import rest.business.models.entities.Vote;

public interface VoteDao {
    
    public List<Vote> findByTheme(Theme theme);

}
