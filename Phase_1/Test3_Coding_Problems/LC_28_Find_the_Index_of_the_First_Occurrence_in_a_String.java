package Test3_Coding_Problems;

public class LC_28_Find_the_Index_of_the_First_Occurrence_in_a_String {

    public static void main(String[] args) {
        // Input strings
        String haystack = "sadbutsad";  // The main string to search in
        String needle = "sad";          // The substring to search for

        // Using the built-in indexOf() method to find the first occurrence
        // indexOf() returns the starting index of the first occurrence of 'needle' in 'haystack'
        // If 'needle' is not found, it returns -1
        System.out.println(haystack.indexOf(needle));
    }

}
