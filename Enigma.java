public class Enigma{

    private String rotorInit[] = {"#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"};


    private Rotor rotors[];
        
    public Enigma(int id1, int id2, int id3, String start){

        rotors = new Rotor[3];
        rotors[0] = new Rotor(rotorInit[id1-1], start.charAt(0));
        rotors[1] = new Rotor(rotorInit[id2-1], start.charAt(1));
        rotors[2] = new Rotor(rotorInit[id3-1], start.charAt(2));
        
    }


    public String decrypt(String message)
    {        
        String decrypted = "";
        int i=0;
        int index;
        char temp;

        while(!rotors[2].rotate())
        {
            index = rotors[2].indexOf(message.charAt(i));
            temp = rotors[1].charAt(index);
            index = rotors[2].indexOf(temp);
            temp = rotors[0].charAt(index);
            decrypted = decrypted + String.valueOf(temp);
            i++;
        }

        while(!rotors[1].rotate())
        {
            index = rotors[2].indexOf(message.charAt(i));
            temp = rotors[1].charAt(index);
            index = rotors[2].indexOf(temp);
            temp = rotors[0].charAt(index);
            decrypted = decrypted + String.valueOf(temp);
            i++;
        }

        return decrypted;

        // 2-1-2-0
    }


    
    public String encrypt(String message)
    {
        0-2-1-2
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    
}
