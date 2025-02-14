public class Rotor {

    
    private String rotorValues;
    private char startChar;
        
    public Rotor(String v, char c){
        this.rotorValues = new String(v);
        this.startChar = c;
        
        while(!this.rotate());
            
    }
    
    public boolean rotate()
    {
        this.rotorValues = rotorValues.substring(rotorValues.length()-1,rotorValues.length()) + rotorValues.substring(0,rotorValues.length()-1);
        if(!String.valueOf(startChar).equals(rotorValues.substring(0,1)))
        {
            return false;
        }
        return true;
    }
    

    public int indexOf(char c)
    {
        for(int i=0; i<rotorValues.length();i++)
        {
            if(String.valueOf(c).equals(rotorValues.substring(i,i+1)))
            {
                return i;
            }
        }
        return -1;
    }

    public char charAt(int idx)
    {
        return rotorValues.charAt(idx);
    }
}
    
