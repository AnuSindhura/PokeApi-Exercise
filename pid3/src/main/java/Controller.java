import manager.*;
import pokemon.*;


import javax.swing.text.View;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class of the application
 */

   public class Controller
{
      public Viewer viewer;
      public JsonManager jsonManager;
      public Scanner scan;

    /**
     * Constructor of the  controller class
     */
    public Controller()
    {
            viewer = new Viewer();
            jsonManager = new JsonManager();
            scan = new Scanner(System.in);
    }
    /**
     * until user wants to quit
     */
    private void start()
    {
        viewer.printWelcome();
        while (true)
        {
            viewer.printOptions();
            switch (userInput())
            {
                case "1":
                    //search a pokemon
                  viewer.printSearchPokemonMessage();
                    searchPokemon(userInput());
                  break;
                case "2":
                    // search a location
                  viewer.printSearchLocationMessage();
                  searchLocation(userInput());
                case "3":
                  return;
                default:
                    viewer.printInvalidInput();
                  
            }
            viewer.printReturnMenu();
            userInput();
        }
    }

    /**
     * Method that allows user  to search for location
     * @param location to be  searched
     */
    private void searchLocation(String location)
    {
        String response = RequestHandler.makeHTTPRequest("location",
                location.trim().replace(".","").replace(" ",
                        "-").toLowerCase());
                Location locationFromApi = jsonManager.readJsonLocations(response);
                if (locationFromApi !=null)
                {
                    viewer.printLocationRegion(locationFromApi.getRegionOfLocation());
                    locationFromApi.getLocationName().stream().forEach(locationFinal -> viewer.printLocation(locationFinal));
                }
                else
                {
                    viewer.printNoLocationFound();
                }
    }

    /**
     * Method that allows user to search for Pokemon
     * @param pokemon to be searched
     */
    private void searchPokemon(String pokemon)
    {
        String response = RequestHandler.makeHTTPRequest("pokemon" ,
                pokemon.trim().replace(".","").replace(" ",
                        "-").toLowerCase());
        pokemon pokemonFromApi = jsonManager.readJsonPokemons(response);
        if (pokemonFromApi != null)
        {
            viewer.printPokemon(pokemonFromApi.toString());

        }
        else{
            viewer.printNoPokemonFound();
        }
    }

    /**
     * collect user input
     * @return user input as String
     */
    public String userInput()
    {
        return scan.nextLine();
    }

    /**
     * start of the application
     * @param args
     */
    public static void main(String[] args)
    {
        Controller controller = new Controller();
        controller.start();
    }

}



