package manager;


import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import pokemon.*;

/**
 * A class reads and writes JSON Files
 */

    public class JsonManager
{
    /**
     * constructor of JsonManager
     */
    public JsonManager()
    {

    }

    /**
     * Reads the JSON with locations and retrieves a list.
     * @param locations a location in json format.
     * @return a location.
     */
    public Location readJsonLocations(String locations)
    {
        Location finalLocation = null;

        ArrayList<String> jsonLocations = new ArrayList<>();

        JSONParser parser = new JSONParser();
        try
        {
            JSONObject jsonObject = (JSONObject) parser.parse(locations);
            //Retrieve region
            JSONObject locationRegion = (JSONObject) jsonObject.get("region");
            //get the region name
            String regionName = (String) locationRegion.get("name");

            //loop locations array to retrieve name
            JSONArray locationNames = (JSONArray) jsonObject.get("names");
            Iterator<String> iteratorNames = locationNames.iterator();
            while (iteratorNames.hasNext())
            {
                Object slide = iteratorNames.next();
                JSONObject jsonObject2 = (JSONObject) slide;

                //get name
                String locationName = (String) jsonObject2.get("name");
                //get language
                JSONObject language = (JSONObject) jsonObject2.get("language");
                String languageName = (String) language.get("name");
                jsonLocations.add(locationName + " - " + languageName);
            }
            finalLocation = new Location(jsonLocations, regionName);
        }
        catch (ParseException e)
        {
            return null;
        }
        catch (NullPointerException e)
        {
            return null;
        }
        return finalLocation;

        /**
         * Reads the JSON with pokemons and retrieves a list
         * @param pokemons in Json format
         * @return  a Pokemon
         */
       // public Pokemon readJsonPokemon (String pokemon):
         public Pokemon readJsonPokemons(String pokemon)
        {
            //Pokemon pokemon1 = null;
            Pokemon pokemon1 = null;

            try
            {
                JSONObject jsonObject = (JSONObject) parser.parse(pokemon);
                long id = (long) jsonObject.get("id");
                String name = (String) jsonObject.get("name");
                long height = (long) jsonObject.get("height");
                long weight = (long) jsonObject.get("weight");

                // loop locations array
                JSONArray pokemonName = (JSONArray) jsonObject.get("types");
                Iterator<String> iterator = pokemonName.iterator();
                while (iterator.hasNext())
                {
                    Object slide = iterator.next();
                    JSONObject jsonObject2 = (JSONObject) slide;
                    pokemon1 = new Pokemon(id, name, height, weight);
                }
            }
            catch (ParseException e)
            {

                return null;
            }
            catch (NullPointerException e)
            {
                return null;
            }

            return pokemon1;
        }

    }

}
