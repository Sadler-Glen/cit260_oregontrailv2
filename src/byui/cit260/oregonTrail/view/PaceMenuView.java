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
public class PaceMenuView extends View{
    

/**
 *
 * @author sadss
 */

    public PaceMenuView() {
        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n                Set Pace Menu                    "
                + "\n                                                 "
                + "\n1 - Steady                                       "
                + "\n2 - Strenuous                                    "
                + "\n3 - Gruelling                                    "
                + "\n4 - Find out what these different paces mean     "
                + "\nX - Exit                                         "
                + "\n"
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
                this.steadyPace();
                break;
            case "2":
                this.strenuousPace();
                break;
            case "3":
                this.gruellingPace();
                break;
            case "4":
                this.paceHelp();
                break; 
            case "5":
                
                break;        
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        return false;
    }  

    private void steadyPace() {
        this.console.println("***steadyPace() function stub called***");
    }

    private void strenuousPace() {
        this.console.println("***strenuousPace() function stub called***");

    }

    private void gruellingPace() {
        this.console.println("***gruellingPace() function stub called***");
    }

    private void paceHelp() {
        this.console.println("***paceHelp() function stub called***");
    }
    
}
