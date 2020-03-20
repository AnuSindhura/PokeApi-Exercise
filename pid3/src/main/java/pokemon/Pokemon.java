package pokemon;

   /** Representing a Pokemon class
    *
    */
    public class Pokemon
{
    private long pokemonId;
    private String pokemonName;
    private long pokemonHeight;
    private long pokemonWeight;


    /**
     * Pokemon constructor
     * @param pokemonId
     * @param pokemonName
     * @param pokemonHeight
     * @param pokemonWeight
     */
    public Pokemon(long pokemonId,String pokemonName,long pokemonHeight,long pokemonWeight)
    {
        this.pokemonId = pokemonId;
        this.pokemonName = pokemonName;
        this.pokemonHeight = pokemonHeight;
        this.pokemonWeight = pokemonWeight;

    }


    public String toString()
    {
        return ">> Pokemon" +
                "{" +
                "Id = " + pokemonId +
                " , Name = '"+pokemonName +
                " , Height = '" +pokemonHeight +
                " , Weight = ' " +pokemonWeight +
                 '}' ;
    }

}
