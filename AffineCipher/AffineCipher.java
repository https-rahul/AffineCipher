/*   CRYPTO ASSIGNMENT
 *   AFFINE CIPHER
 *   
 *   DONE BY:
 *   NEHA MANGHNANI (2016A7PS0010U)
 *   NIYATI SOKHI (2016A7PS0229U)
 *   ANJALI GOLLAPALLI (2016A7PS0050U)
 * 
 * 
 */
public class AffineCipher
{
    String p;
    String c;
    int key1,key2,inversekey1;
    public AffineCipher()
    {
        
    }
    
    public AffineCipher(String plaintext,int multiplicativekey,int additivekey)
    {
        this.p=plaintext;
        this.key1=multiplicativekey;
        this.key2=additivekey;
    }
    
    public AffineCipher(int inversemultiplicativekey,int additivekey,String ciphertext)
    {
        this.c=ciphertext;
        this.inversekey1=inversemultiplicativekey;
        this.key2=additivekey;
    }
    
    public String encryption(String plaintext,int key1,int key2)
    {
        
        char array[];
        array=new char[plaintext.length()];
        int numberarray[];
        numberarray=new int[array.length];
        int cryptnumberarray[];
        cryptnumberarray=new int[numberarray.length];
        char cryptarray[];
        cryptarray=new char[array.length];
        
        System.out.println("Key 1:" +key1);
        System.out.println("Key 2:" +key2);
        
        // Array of letters of plaintext
        for (int i = 0; i < plaintext.length(); i++) { 
            array[i] = plaintext.charAt(i); 
             
        }
        
        
            for(int i=0;i<array.length;i++)
            {
                int number=assignnumbertoletter(array[i]);
                numberarray[i]=number;
               
                int newcryptnumber = encryptnumber(numberarray[i]);
                cryptnumberarray[i]=newcryptnumber;
                
                char cryptletter=assignlettertonumber(cryptnumberarray[i]);
                cryptarray[i]=cryptletter;
            }
           
          
            StringBuilder sbf=new StringBuilder();
            sbf.append(cryptarray);
            String crypttext=sbf.toString();
        
            return crypttext;
    }
    
    public String decryption(String ciphertext,int inversekey1,int key2)
    {
        String plaintextback;
        char array[];
        array=new char[ciphertext.length()];
        int numberarray[];
        numberarray=new int[array.length];
        int decryptnumberarray[];
        decryptnumberarray=new int[numberarray.length];
        char decryptarray[];
        decryptarray=new char[array.length];
        
        System.out.println("Inverse key: "+inversekey1);
        System.out.println("Key 2: "+key2);
        
        
        // Array of letters of plaintext
        for (int i = 0; i < ciphertext.length(); i++) { 
            array[i] = ciphertext.charAt(i); 
             
        }
        
         for(int i=0;i<array.length;i++)
            {
                int number=assignnumbertoletter(array[i]);
                numberarray[i]=number;
               
                int newdecryptnumber = decryptnumber(numberarray[i]);
                decryptnumberarray[i]=newdecryptnumber;
                
                char decryptletter=assignlettertonumber(decryptnumberarray[i]);
                decryptarray[i]=decryptletter;
              
            }
            
        StringBuilder sbf=new StringBuilder();
            sbf.append(decryptarray);
            plaintextback=sbf.toString();
        
            return plaintextback;
    }
    
    public int assignnumbertoletter(char letter)
    {
        int asciinumber;
        int number=0;
        
        asciinumber=(int)letter;
        if(asciinumber>=65&&asciinumber<=90)
        {
            number=asciinumber-'A';
        }
        
        if(asciinumber>=97&&asciinumber<=122)
        {
            number=asciinumber-'a';
        }
        
        
        return number;
    }
    
    public char assignlettertonumber(int number)
    {
        
        char letter=(char)(number+65);
        return letter;
        
        
    }
    
    public int encryptnumber(int number)
    {
        int cryptnumber;
        
        
        int m=number*key1;
        int n=m%26;
        int o=n+key2;
        cryptnumber=o%26;
        
        
        return cryptnumber;
    }
    
  
    
    public int decryptnumber(int number)
    {
        int decryptnumber;
        
        int m=number-key2;
        int n=m%26;
        if(n<0)
        n=n+26;
        int o=n*inversekey1;
        decryptnumber=o%26;
        
        return decryptnumber;
        
    }
   
}

 