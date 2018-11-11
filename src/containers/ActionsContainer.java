package containers;

import java.util.ArrayList;
import java.util.List;

public class ActionsContainer {
    private String checkBreathe = "Check Breathe";
    private String search = "Search";
    private String useNRC = "Use NRC";
    private String doRautek = "Do Rautek";
    private String rightPosition = "Right Pos";
    private int victimType;
    private List<String> allActions;

    public ActionsContainer(int victimType){
        allActions = new ArrayList<>();
        this.victimType = victimType;

    }

    public List<String>getAllActions(){
        if(victimType==1){
            allActions.add(checkBreathe);
            allActions.add(search);
            allActions.add(rightPosition);
            allActions.add(useNRC);

            return allActions;
        }

        return null;
    }

}
