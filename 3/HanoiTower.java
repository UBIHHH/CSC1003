import java.util.Scanner;

public class HanoiTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int from = sc.nextInt();
        int to = sc.nextInt();
        int mid = sc.nextInt();
        hanoi_tower(N, from, mid, to);
    }

    public static void hanoi_tower(int N, int from, int mid, int to){
        if (N == 1) {
            System.out.println(from + "->" + to);
        } else {
            hanoi_tower(N - 1, from, to, mid);
            System.out.println(from + "->" + to);
            hanoi_tower(N-1, mid, from, to);
        }
    }
}
