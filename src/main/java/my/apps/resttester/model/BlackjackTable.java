package my.apps.resttester.model;

import my.apps.resttester.games.blackjack.model.*;
import org.json.JSONObject;

public class BlackjackTable implements iGameSurface {
    private Shoe shoe;
    private DiscardTray discardTray;

    public void passParameters(JSONObject json){
        
    }
    
}