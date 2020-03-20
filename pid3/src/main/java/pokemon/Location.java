package pokemon;

import java.util.ArrayList;


public class Location
{
    private ArrayList<String> locationName;
    private String regionOfLocation;

    /**
     * Constructor class
     * @param  locationName the names of a location
     * @param  regionOfLocation the region of a location
     */
    public Location(ArrayList<String> locationName , String regionOfLocation)
    {
        this.locationName = locationName;
        this .regionOfLocation = regionOfLocation;
    }

    /**
     * Get location's name
     * @return list of Strings with location names in several languages.
     */
    public ArrayList<String> getLocationName()
    {
        return locationName;
    }

    /**
     * Get location's region
     * @return a region as string.
     */
    public String getRegionOfLocation()
    {
        return regionOfLocation;
    }
}
