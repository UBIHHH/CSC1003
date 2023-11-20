import java.util.Scanner;


public class AsciiArt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String[][] alphabet = {
                {"   ###    ", "  ## ##   ", " ##   ##  ", "##     ## ", "######### ", "##     ## ", "##     ## "}, // A
                { "########  ", "##     ## ", "##     ## ", "########  ", "##     ## ", "##     ## ", "########  " }, // B
                { " ######  ", "##    ## ", "##       ", "##       ", "##       ", "##    ## ", " ######  " }, // C
                { "########  ", "##     ## ", "##     ## ", "##     ## ", "##     ## ", "", "########  " }, // D
                { "######## ", "##       ", "##       ", "######   ", "##       ", "##       ", "######## " }, // E
                { "######## ", "##       ", "##       ", "######   ", "##       ", "##       ", "##       " }, // F
                { " ######   ", "##    ##  ", "##        ", "##   #### ", "##    ##  ", "##    ##  ", " ######   " }, // G
                { "##     ## ", "##     ## ", "##     ## ", "######### ", "##     ## ", "##     ## ", "##     ## " }, // H
                { "#### ", " ##  ", " ##  ", " ##  ", " ##  ", " ##  ", "#### " }, // I
                { "      ## ", "      ## ", "      ## ", "      ## ", "##    ## ", "##    ## ", " ######  " }, // J
                { "##    ## ", "##   ##  ", "##  ##   ", "#####    ", "##  ##   ", "##   ##  ", "##    ## " }, // K
                { "##       ", "##       ", "##       ", "##       ", "##       ", "##       ", "######## " }, // L
                { "##     ## ", "###   ### ", "#### #### ", "## ### ## ", "##     ## ", "##     ## ", "##     ## " }, // M
                { "##    ## ", "###   ## ", "####  ## ", "## ## ## ", "##  #### ", "##   ### ", "##    ## " }, // N
                { " #######  ", "##     ## ", "##     ## ", "##     ## ", "##     ## ", "##     ## ", " #######  " }, // O
                { "########  ", "##     ## ", "##     ## ", "########  ", "##        ", "##        ", "##        " }, // P
                { " #######  ", "##     ## ", "##     ## ", "##     ## ", "##  ## ## ", "##    ##  ", " ##### ## " }, // Q
                { "########  ", "##     ## ", "##     ## ", "########  ", "##   ##   ", "##    ##  ", "##     ## " }, // R
                { " ######  ", "##    ## ", "##       ", " ######  ", "      ## ", "##    ## ", " ######  " }, // S
                { "######## ", "   ##    ", "   ##    ", "   ##    ", "   ##    ", "   ##    ", "   ##    " }, // T
                { "##     ## ", "##     ## ", "##     ## ", "##     ## ", "##     ## ", "##     ## "," #######  "}, // U
                { "##     ## ", "##     ## ", "##     ## ", "##     ## ", " ##   ##  ", "  ## ##   ", "   ###    " }, // V
                { "##      ## ", "##  ##  ## ", "##  ##  ## ", "##  ##  ## ", "##  ##  ## ", "##  ##  ## ", " ###  ###  " }, // W
                { "##     ## ", " ##   ##  ", "  ## ##   ", "   ###    ", "  ## ##   ", " ##   ##  ", "##     ## " }, // X
                { "##    ## ", " ##  ##  ", "  ####   ", "   ##    ", "   ##    ", "   ##    ", "   ##    " }, // Y
                { "######## ", "     ##  ", "    ##   ", "   ##    ", "  ##     ", " ##      ", "######## " }, // Z
        };

        int n = sc.nextInt();
        sc.nextLine();
        String[] rows = new String[7];
        while (n != 0) {
            sc.nextLine();
            for (int ind = 0; ind < 7; ind++) {
                rows[ind] = sc.nextLine();
            }
            while (rows[0] != "") {
                int m = 0;
                while (m < 26) {
                    int cnt = 0;
                    while (rows[cnt].startsWith(alphabet[m][cnt])) {
                        cnt++;
                        if (cnt == 7) {
                            break;
                        }
                    }
                    if (cnt == 7) {
                        for (int q = 0; q < 7; q++) {
                            rows[q] = rows[q].replaceFirst(alphabet[m][q], "");
                        }
                        System.out.print((char) (m + 65));
                        m = -1;
                    }
                    m++;

                }
            }
            if (n != 1) {
                System.out.print("\n");
            }
            n--;
        }
        //System.out.println("\nend");
    }
}