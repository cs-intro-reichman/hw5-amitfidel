/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        //String hello = "hello";
      /*   System.out.println(countChar(hello, 'h'));
        System.out.println(countChar(hello, 'l'));
        System.out.println(countChar(hello, 'z'));
        System.out.println(spacedString(hello));
        */
        //
        //System.out.println(subsetOf("sap","space")); //returns true
        System.out.println(subsetOf("spa","space")); //returns true
        System.out.println(subsetOf("pass","space")); //returns false
        System.out.println(subsetOf("c","space")); //returns true
        //System.out.println(spacedString("abcd")); //"a b c d"
        //System.out.println(spacedString(""));
        //System.out.println(spacedString("a"));
        //System.out.println(spacedString("abcd s"));
        //System.out.println(randomStringOfLetters(7));
        //System.out.println(randomStringOfLetters(0));
        //System.out.println(randomStringOfLetters(1));
        
        //System.out.println(subsetOf("runi","runing"));
        //System.out.println(remove("h a l c c a x t e t","cat")); //ce
        //System.out.println(remove("spa","space")); //ce
        //System.out.println(remove("pass","space")); //ce
        //System.out.println(remove("c","space")); //spae
        //System.out.println(remove("space","space")); //space
        //System.out.println(remove("","space")); //space
        //System.out.println(insertRandomly('!',"space")); //space
       // System.out.println(insertRandomly(' ',"space")); //space
       // System.out.println(insertRandomly('i',"space")); //space
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * Example: countChar("Center",'e') returns 2 and countChar("Center",'c') returns 0. 
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char ch) {
        int counter=0;
        if(str==""||ch=='\u0000')
        return 0;
        for(int i=0;i<str.length();i++)
        {
            if (str.charAt(i)==ch)
            counter++;
        }
        return counter;
    }

    /** Returns true if str1 is a subset string str2, false otherwise
     *  Examples:
     *  subsetOf("sap","space") returns true
     *  subsetOf("spa","space") returns true
     *  subsetOf("pass","space") returns false
     *  subsetOf("c","space") returns true
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) 
    {
        boolean[]l1= new boolean[str1.length()];
        for(int i=0;i<l1.length;i++)
        {
            l1[i]=false;
        }
        for(int i=0;i<str2.length();i++)
        {
                for(int j=0;j<str1.length();j++)
                {
                    
                    if (str2.charAt(i)==str1.charAt(j)) 
                    {
                        l1[j]=true;
                        break;
                    }
                }
        }
        for(int j=0;j<str1.length();j++)
                {
                    if (l1[j]==false) 
                {
                    return false;
                }
                }
                return true;
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for the last character. 
     * Example: spacedString("silent") returns "s i l e n t"
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        if (str=="")
        return "";
        String spaceStr="";
        for(int i=0;i<str.length()-1;i++)
        {
            spaceStr+=str.charAt(i)+" ";
        }
        spaceStr+=str.charAt(str.length()-1);
        return spaceStr;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * Example: randomStringOfLetters(3) can return "zoo"
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
       
       String sen="";
       for(int i=0;i<n;i++)
       {
        int rnd=(int)(Math.random()*26);
        char cRnd=(char)('a'+rnd);
        sen+=cRnd;
       }
        return sen;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: remove("meet","committee") returns "comit" 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String newS1="";
        boolean bingo=false;
        Boolean[] str2B=new Boolean[str2.length()];
        for(int i=0;i<str2B.length;i++)
       {
        str2B[i]=false;
       }
       for(int i=0;i<str1.length();i++)
       {
            for(int j=0;j<str2.length();j++)
            {          
                if (str2.charAt(j)==str1.charAt(i)&&!str2B[j]) 
                {
                    str2B[j]=true;
                    bingo=true;
                    break;
                }
            }
            if (!bingo)
            {
            newS1+=str1.charAt(i);
            }
            bingo=false;
       }
        return newS1;
    }

    /**
     * Returns a string consisting of the given string, with the given 
     * character inserted randomly somewhere in the string.
     * For example, insertRandomly("s","cat") can return "scat", or "csat", or "cast", or "cats".  
     * @param ch - a character
     * @param str - a string
     * @return a string consisting of str with ch inserted somewhere
     */
    public static String insertRandomly(char ch, String str) {
         // Generate a random index between 0 and str.length()
         int randomIndex = (int) (Math.random() * (str.length() + 1));
         // Insert the character at the random index
         String result = str.substring(0, randomIndex) + ch + str.substring(randomIndex);
         return result;
    }    
}
