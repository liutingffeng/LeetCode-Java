package LC2026;

public class LC383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || ransomNote == null)
            return false;
        int[] record = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            record[index] += 1;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i) - 'a';
            if (record[index] <= 0)
                return false;
            record[index] -= 1;
        }
        return true;
    }


}
