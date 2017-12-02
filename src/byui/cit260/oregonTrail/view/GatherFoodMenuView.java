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
public class GatherFoodMenuView extends View{
    
    public GatherFoodMenuView(){
        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n             Gather Food Menu                    "
                + "\n                                                 "
                + "\n1 - Berries                                      "
                + "\n2 - etc                                          "
                + "\n3 - etc                                          "
                + "\n2 - Hunt help information                        "
                + "\nX - Exit                                         "
                + "\n=================================================",
                "\nPlease enter your choice: ");

    }

    @Override
    public void display() {

        boolean done = false; // set flag to not done
        try {
            do {
                // prompt for and get menu option
                String value = this.getInput();
                if (value.toUpperCase().equals("X"))// user wants to exit view                
                // do the requested action and display the next view
                {
                    return; // exit view
                }
                done = this.doAction(value);
            } while (!done);
        } catch (NumberFormatException nfe) {
            ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

    @Override
    public boolean doAction(String menu) {
        menu = menu.toUpperCase(); // convert choice to upper cas

        switch (menu) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                
                break;
            case "4":
                
                break; 
            case "5":
                
                break;        
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        return false;
    }  

}
