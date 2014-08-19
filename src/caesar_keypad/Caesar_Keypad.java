package caesar_keypad;

import java.util.Scanner;

/**
 *
 * @author todyertuz @ plainintricacy.wordpress.com
 * 
 * Java code that simulates a simple encrypted keypad, using the Caesar cipher.
 * 
 * Input: your message and the desired encryption key (an integer)
 * Output: list of encrypted telephone keypad numbers and encrypted version of your message
 * 
 * Based on this reddit daily challenge: http://goo.gl/SdX0Z4
 * And on the Caesar cipher: http://goo.gl/3bJUwq
 */

public class Caesar_Keypad {

    public static String alphabet = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
    
    public static void main(String[] args) {
    
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your message:");
        String in = input.nextLine();
        System.out.println("Please enter your key:");
        int key = Integer.parseInt(input.nextLine());
        input.close();
        
        String[] kpad = new String[8];
        kpad[0] = "ABC";
        kpad[1] = "DEF";
        kpad[2] = "GHI";
        kpad[3] = "JKL";
        kpad[4] = "MNO";
        kpad[5] = "PQRS";
        kpad[6] = "TUV";
        kpad[7] = "WXYZ";
        
        String[] words = in.toUpperCase().split(" ");
        String keypad_input = new String();
        
        System.out.println("Encryption complete.");
        System.out.println("Encrypted keypad numbers:");
        for(int i=0; i<words.length; i++){
            for(int j=0; j<words[i].length(); j++){
                for(int q=0; q<kpad.length; q++){
                    if(kpad[q].indexOf(words[i].charAt(j))>=0){
                        for(int z=0; z<=kpad[q].indexOf(words[i].charAt(j)); z++){
                            System.out.print(check_keypad(q+2,key));
                            keypad_input += check_keypad(q+2,key);
                        }
                        keypad_input += " ";
                        System.out.print(" ");
                    }
                }
            }
        }
        System.out.println();
        String[] numbers = keypad_input.split(" ");
        int nums[] = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            nums[i] = Integer.parseInt(numbers[i]);
        }
        System.out.println("Encrypted message:");
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0){
                if(numsize(nums[i])>kpad[nums[i]%10-2].length()){
                    System.out.print(kpad[nums[i]%10-2].charAt(numsize(nums[i])-(kpad[nums[i]%10-2].length())-1));
                }else{
                    System.out.print(kpad[nums[i]%10-2].charAt(numsize(nums[i])-1));
                }
            }
        }
        System.out.println();
    }
    
    public static int check_keypad(int x, int q){
        if((x+q)%8>9){
            return (x+q)%8-8;
        }
        if((x+q)%8<2){
            return (x+q)%8+8;
        }
        return (x+q)%8;
    }
    
    public static int numsize(int q){
        int x=0;
        while(q>0){
            x++;
            q/=10;
        }
        return x;
    }

}

