/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.oregonTrail.view;

import byui.cit260.oregonTrail.control.GameControl;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ignacio
 */
public class ChooseMonthView extends View {

    public ChooseMonthView() {
        super("\n"
                + "\n===============Oregon Trail Game================="
                + "\n  It is 1848. Your jumping off place for         "
                + "\n  Oregon is Independence, Missouri. You must     "
                + "\n  decide which month to leave Independence.      "
                + "\n                                                 "
                + "\n  Choose Your Month                              "
                + "\n                                                 "
                + "\n  1 - March                                      "
                + "\n  2 - April                                      "
                + "\n  3 - May                                        "
                + "\n  4 - June                                       "
                + "\n  5 - July                                       "
                + "\n  6 - Ask For Advice                             "
                + "\n  X - Exit                                       "
                + "\n=================================================",
                "\nPlease enter your choice: ");

    }

    @Override
    public void display() {

        boolean done = false; // set flag to not done
        try{
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
        } catch(NumberFormatException nfe){
            ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
        }
    }

    @Override
    public boolean doAction(String menu) {
        menu = menu.toUpperCase(); // convert choice to upper cas

        switch (menu) {
            case "1": //Select March
                
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String strdate = "01-MAR-1848";
		try {
			Date startDate = sdf.parse(strdate);
//                        this.console.println("StringDate: " + strdate); // test
			GameControl.setStartDate(startDate);
//                        this.console.println("Start Date2: " + GameControl.getStartDate()); // test
		} catch (Exception e) {
			e.printStackTrace();
		}
                GameControl.setWeather("Cold");
                this.monthStartGame();
                break;
            case "2": //Select April
                Date date2 = new Date();
                SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yyyy");
		String strdate2 = "01-APR-1848";
		try {
			Date startDate = sdf2.parse(strdate2);
//                        this.console.println("Start Date1: " + startDate);// test
			GameControl.setStartDate(startDate);
//                        this.console.println("Start Date2: " + GameControl.getStartDate());// test
		} catch (Exception e) {
			e.printStackTrace();
		}
                GameControl.setWeather("Cold");
                this.monthStartGame();
                break;
            case "3": //Select May
                Date date3 = new Date();
                SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MMM-yyyy");
		String strdate3 = "01-MAY-1848";
		try {
			Date startDate = sdf3.parse(strdate3);
//                        this.console.println("Start Date1: " + startDate);// test
			GameControl.setStartDate(startDate);
//                        this.console.println("Start Date2: " + GameControl.getStartDate());// test
		} catch (Exception e) {
			e.printStackTrace();
		}
                GameControl.setWeather("Freezing");
                this.monthStartGame();
                break;
            case "4": //Select June
                Date date4 = new Date();
                SimpleDateFormat sdf4 = new SimpleDateFormat("dd-MMM-yyyy");
		String strdate4 = "01-JUNE-1848";
		try {
			Date startDate = sdf4.parse(strdate4);
//                        this.console.println("Start Date1: " + startDate);// test
			GameControl.setStartDate(startDate);
//                        this.console.println("Start Date2: " + GameControl.getStartDate());// test
		} catch (Exception e) {
			e.printStackTrace();
		}
                GameControl.setWeather("Cool");
                this.monthStartGame();
                break;
            case "5": //Select July
                Date date5 = new Date();
                SimpleDateFormat sdf5 = new SimpleDateFormat("dd-MMM-yyyy");
		String strdate5 = "01-JUL-1848";
		try {
			Date startDate = sdf5.parse(strdate5);
//                        this.console.println("Start Date1: " + startDate);// test
			GameControl.setStartDate(startDate);
//                        this.console.println("Start Date2: " + GameControl.getStartDate());// test
		} catch (Exception e) {
			e.printStackTrace();
		}
                GameControl.setWeather("Warm");
                this.monthStartGame();
                break;
            case "6": //Go to the advice information page
                this.askAdvice();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "*** Invalid selection *** Try again");
                break;
        }
       
        return false;
    }

    private void monthStartGame() {
        GameControl.setPace("Steady");
        GameControl.setRation("Filling");
        
        GameControl.setHealth("Good");
        StartMonthView startMonth = new StartMonthView();
        startMonth.display();
    }

    private void askAdvice() {
        AskForAdviceView askForAdvice = new AskForAdviceView();
        askForAdvice.display();
    }
}
