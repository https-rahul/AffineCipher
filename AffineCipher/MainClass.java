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

import java.util.*;
import java.lang.*;

public class MainClass
{
    static String plaintext,ciphertext,returnplaintext;
     static Scanner sc=new Scanner(System.in);
    static int mkey1,akey2; //2 keys for multiplicative and additive cipher
    static int inverse_key1;
    
    public static void main(String[] args)
    {
            int flag=0;
            char choice='0';
     
            do
            {
            System.out.println();
            System.out.println("AFFINE CIPHER");
            System.out.println();
            System.out.println("Enter plaintext(one word) and keys");
            getPlaintextAndKeys();
            
            System.out.println("Do you want to encrypt the plaintext?");
            System.out.println("Please answer with Yes(Y/y) or No(N/n)");
            choice=sc.next().charAt(0);
           
            if(choice=='y'||choice=='Y')
            {encryptPlaintext();}
            
            if(choice=='n'||choice=='N')
            {   System.out.println("Do you wish to exit?");
                System.out.println("Please answer with Yes(Y/y) or No(N/n)");
                choice=sc.next().charAt(0);
                if(choice=='y'||choice=='Y')
                  {   System.out.println("Exiting program");
                      flag=1; break; }
                  else
                     continue;
               
                }
                
            System.out.println("Do you want to decrypt the ciphertext?");
            System.out.println("Please answer with Yes(Y/y) or No(N/n)");
            choice=sc.next().charAt(0);
            
            if(choice=='y'||choice=='Y')
            {decryptCiphertext();}
            
             if(choice=='n'||choice=='N')
            {   System.out.println("Do you wish to exit?");
                System.out.println("Please answer with Yes(Y/y) or No(N/n)");
                choice=sc.next().charAt(0);
                if(choice=='Y'||choice=='y')
                  { flag=1; break; }
                  
                else
                   continue;
            
                }
           
            
            System.out.println("Do you want to exit the program?");
             choice=sc.next().charAt(0);
             if(choice=='Y'||choice=='y')
                  { flag=1; break; }
                  
             
        
    }while(flag==0);
    
}
    public static void getPlaintextAndKeys()
    {
        System.out.println("Enter plain text:");
        plaintext=sc.next();
        //plaintext=plaintext.replaceAll(" ","");
        
        System.out.println("Enter two keys:");
        System.out.println("Choose key 1 from the set of key numbers given below:");
        gettingkey1();
        
        
        System.out.println("Enter key 2 (from 0-25)");
        akey2=sc.nextInt();
        
    }
    
          public static void gettingkey1()
          {
              ArrayList<Integer> possiblekeys = new ArrayList<Integer>(); 
              ArrayList<Integer> inverses = new ArrayList<Integer>();
              boolean containskey;
              
              
              int i; int j;
            
              for(i=1;i<26;i++)
              {
                  for(j=1;j<26;j++)
                  {
                      if((i*j)%26==1)
                      {System.out.println(i);
                      possiblekeys.add(i);
                      inverses.add(j);}
                    }
                }
                
                 do
                 {
                 System.out.println("Choose key 1(from options above)");
                 mkey1=sc.nextInt();
                 
                 containskey=possiblekeys.contains(mkey1);
                 //System.out.println(containskey);
                 if(containskey==false)
                 {
                     System.out.println("Please select a key from the numbers above:");
                     
                    }
                    
                 if(containskey==true)
                 {
                     int index=possiblekeys.indexOf(mkey1);
                     inverse_key1=inverses.get(index);
                    }
                }while(containskey==false);
            }
    
            public static void encryptPlaintext()
            {
             System.out.println("Encrypting plaintext which is most recently added");
             AffineCipher a=new AffineCipher(plaintext,mkey1,akey2);
             ciphertext=a.encryption(plaintext,mkey1,akey2);
             System.out.println("Crypted text: "+ ciphertext);
                  
            }
            
            public static void decryptCiphertext()
            {
                 System.out.println("Decrypting the recent encrypted text");
                AffineCipher a1=new AffineCipher(inverse_key1,akey2,ciphertext);
                returnplaintext=a1.decryption(ciphertext,inverse_key1,akey2);
                System.out.println("Decrypted text: "+ returnplaintext);
        
            }
}

 