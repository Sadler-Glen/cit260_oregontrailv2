/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

/**
 *
 * @author sadss
 */
public class RiverCrossingHelpInfoView extends View {

    public RiverCrossingHelpInfoView() {
        super("\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n          River Crossing Information             "
                + "\n                                                 "
                + "\n                **FORD**                         "
                + "\n  To ford a river means to pull your wagon       "
                + "\n  across a shallow part of the river, with       "
                + "\n  the oxen still attached.                       "
                + "\n"
                + "\n                **CAULK**                        "
                + "\n  To caulk the wagon means to seal it so that    "
                + "\n  no water can get in. The wagon can then be     "
                + "\n  floated across like a boat.                    "
                + "\n"
                + "\n                **FERRY**"
                + "\n  To use a ferry means to put your wagon on top  "
                + "\n  of a flat boat that belongs to someone else.   "
                + "\n  The owner of the ferry will take your wagon    "
                + "\n  across the river."
                + "\n                                                 "
                + "\n                                                 "
                + "\n=================================================",
                "\nPress 'C' to continue: ");
    }

    @Override
    public boolean doAction(String choice) {
        ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        return false;
    }    
}
