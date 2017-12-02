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
class RationMenuView extends View {
        public RationMenuView() {
        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n                Hunt Menu                        "
                + "\n                                                 "
                + "\n1 - Filling    - meals are large and generous    "
                + "\n2 - Meagre     - meals are small, but adequate   "
                + "\n3 - Bare bones - meals are very small; everyone  "
                + "\n                 stays hungry                    "
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
                this.fillingRation();
                break;
            case "2":
                this.meagreRation();
                break;
            case "3":
                this.bareBonesRation();
                break;      
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        return false;
    }  

    private void fillingRation() {
        this.console.println("***fillingRation() function stub called***");
    }

    private void meagreRation() {
        this.console.println("***meagreRation() function stub called***");
    }
    
    private void bareBonesRation() {
        this.console.println("***bareBonesRation() function stub called***");
        
    }


}
