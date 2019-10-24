public enum Square{
    //Enum Constants
    walls('#'),
    open_spaces('.'),
    start('o'),
    finish('*'),
	visited('-');

    private final char symbol;
    
    //Constructor
    Square(char symbol){
        this.symbol = symbol;
    }

    //Returns character of the square
    public String toString(){
        return String.valueOf(symbol);
    }

    //Returns square of corresponding character
    public static Square fromChar(char symbol){
        for(Square s : values()){
            if(symbol == s.symbol){
                return s;
            }  
        }
        throw new IllegalArgumentException("The character provided is not an existing square");
    }
}