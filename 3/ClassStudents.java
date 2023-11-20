import java.util.ArrayList;
import java.util.Scanner;

public class ClassStudents {
    public static void main(String[] args) {
        ArrayList<String> students_info = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            s = s.replaceFirst(",", ":");
            students_info.add(s);
        }
        for (int i = 0; i < n; i++) {
            String[] mid = students_info.get(i).split(":");
            names[i] = mid[0];
        }
        
        int m = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            String find = sc.nextLine();
            boolean judge = false;
            for (int j = 0; j < n; j++) {
                if (names[j].equals(find)) {
                    System.out.println(students_info.get(j));
                    judge = true;
                }
            }
            if (!judge) {
                System.out.println(find + ": None");
            }
        }

    }
}