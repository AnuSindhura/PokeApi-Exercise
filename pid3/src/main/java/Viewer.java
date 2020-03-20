public class Viewer
{
    /**
     * Constructor of view class
     */
    public Viewer()
    {

    }

    /**
     * Welcome Message
     */
    public void printWelcome()
    {
        System.out.println("Welcome to Pokemon ");
    }

    /**
     * print main menu
     */

    public void printOptions()
    {
        System.out.println("pick an option :");
        String[] actions = {"(1) Search a Pokemon" , "(2) Search a location" , "(3) Quit"};
        for (int i = 0; i < actions.length; i++)
        {
            System.out.println(actions[i]);
        }
    }

    /**
     * Print a message asking for any input and to return menu
     */
    public void printReturnMenu()
    {
        System.out.println("Please,Press Enter to return to the menu");
    }

    /**
     * Print a message for user to insert pokemon name
     */
    public void printSearchPokemonMessage()
    {
        System.out.println("Insert a Pokemon Name");
    }

    /**
     * print the searched pokemon
     */
    public void printPokemon(String pokemon)
    {
        System.out.println(pokemon);
    }

    /**
     * print a message for user to insert a location name
     */
    public void printSearchLocationMessage()
    {
        System.out.println("Insert a location name");
    }

    /**
     * print the searched location
     */
    public void printLocation(String location)
    {
        System.out.println("Location name = " + location);
    }

    /**
     * print location region
     */

    public void printLocationRegion(String region)
    {
        System.out.println("Region = " + region);
    }

    /**
     * print a message stating invalid input
     */
    public void printInvalidInput()
    {
        System.out.println("Invalid Input");
    }

    /**
     * print a message stating location not found
     */
    public void printNoLocationFound()
    {
        System.out.println("Location not Found : Insert the correct Location");
    }

    /**
     * print a message stating no pokemon found
     */
    public void printNoPokemonFound()
    {
        System.out.println("Pokemon not found : Enter correct Pokemon Name");
    }

}
