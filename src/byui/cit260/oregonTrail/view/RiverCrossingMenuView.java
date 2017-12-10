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
class RiverCrossingMenuView extends View{
    
        public RiverCrossingMenuView() {
        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n                                                 "
                + "\n             River Crossing Menu                 "
                + "\n                                                 "
                + "\n1 - Attempt to ford the river                     "
                + "\n2 - Caulk the wagon and float it across          "
                + "\n3 - Take a ferry across                          "
                + "\n4 - Wait to see if conditions improve            "
                + "\n5 - Ask a local Indian to guide you across       "
                + "\n6 - Get helpful information                      "
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
                this.fordRiver();
                break;
            case "2":
                this.caulkWagon();
                break;
            case "3":
                 this.takeFerry();               
                break;
            case "4":
                this.waitForImprovements();                
                break;
            case "5":
                this.askForHelp();
                break;        
            case "6":
                this.helpInfo();
                break; 
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
        return false;
    }  

    private void fordRiver() {
        this.console.println("***fordRiver() function stub called***");
    }

    private void caulkWagon() {
        this.console.println("***caulkwagon() function stub called***");
    }

    private void takeFerry() {
        TakeFerryView takeFerry = new TakeFerryView();
        takeFerry.display();
    }

    private void waitForImprovements() {
        this.console.println("***waitForImprovements() function stub called***");
    }

    private void helpInfo() {
        RiverCrossingHelpInfoView helpInfo = new RiverCrossingHelpInfoView();
        helpInfo.display();
    }

    private void askForHelp() {
        this.console.println("***You have been guided safely across the river***");
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
          
    }
}
