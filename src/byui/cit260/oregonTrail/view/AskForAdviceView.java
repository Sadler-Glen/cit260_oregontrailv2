/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

/**
 *
 * @author Ignacio
 */
public class AskForAdviceView extends View {

    public AskForAdviceView() {
        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                            "
                + "\n You attend a public meeting held for 'folks with           "
                + "\n the California Oregon fever'. You´re told:                 "
                + "\n If you leave too early, there won´t be any                 "
                + "\n grass for your oxen to eat. If you leave too late,         "
                + "\n you may not get to Oregon before winter comes.             "
                + "\n    **************   ***************                           "
                + "\n However, if you leave at just the right time,              "
                + "\n there will be green grass, and the weather                 "
                + "\n would still be cool. It´s your call.                       "
                + "\n                                                            "
                + "\n=================================================",
                "\nPress 'C' to continue: ");
    }

    @Override
    public boolean doAction(String text) {
        ErrorView.display(this.getClass().getName(), "***Invalid selection - Try again***");
        return false;
    }
}
