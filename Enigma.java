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
        int index;
        char temp;

        for(int j=0; j<message.length(); j++)
        {
            index = rotors[2].indexOf(message.charAt(j));
            temp = rotors[1].charAt(index);
            index = rotors[2].indexOf(temp);
            temp = rotors[0].charAt(index);
            decrypted = decrypted + String.valueOf(temp);
            rotate();
        }

        return decrypted;

        // 2-1-2-0
    }


    
    public String encrypt(String message)
    {
        String encrypted = "";
        int index;
        char temp;

        for(int j=0; j<message.length(); j++)
        {
            index = rotors[0].indexOf(message.charAt(j));
            temp = rotors[2].charAt(index);
            index = rotors[1].indexOf(temp);
            temp = rotors[2].charAt(index);
            encrypted = encrypted + String.valueOf(temp);
            rotate();
        }
        
        return encrypted;
        // 0-2-1-2
    }

    
    private void rotate(){
        if(rotors[0].rotate()){
            if(rotors[1].rotate()){
                rotors[2].rotate();
            }
        }
    }
    // 이건 뭐임
    
}
