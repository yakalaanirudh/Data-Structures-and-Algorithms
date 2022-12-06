//Here we print the first character of every word in a string

public class String2 {

    public static void main(String[] args) {

        String s = "Hello User!! Welcome";

        char a[] = s.toCharArray();

        for(int i = 0; i < a.length; i++) {
            if(a[i] != ' ' && (i == 0 || a[i - 1] == ' ')) {
                System.out.println(a[i]);
            }
        }
    }
}

//HUW

// if(a[i] != ' ' && (i == 0 || a[i - 1] == ' '))
//The above line means if the character is !=' ' and if it is not the first character of the string and
//The character before the given is not ' ' (this is for start of new word as the previous in this case is ' ')