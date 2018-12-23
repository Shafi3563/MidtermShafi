package math.problems;

public class MakePyramid {
    public static void main(String[] args) {

        for(int i=0;i<50;i++) {  // took 50 numbers for the size of the pyramid
            for(int j=0;j<50-i;j++) {
                System.out.print(" ");
            }

            for (int k=0;k<=i;k++) {
                System.out.print("* ");
            }
            System.out.println();
        }


    }
}