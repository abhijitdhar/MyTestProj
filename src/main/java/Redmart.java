import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by abhidhar on 8/14/15.
 */
public class Redmart {

    public static void main(String[] args) {
        Redmart redmart = new Redmart();

        redmart.process();

    }

    private void process() {


        /*try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/test.txt"))) {
            stream
                    .map(String::trim)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        try {
            List<String> fileContents = Files.readAllLines(Paths.get("src/main/resources/test.txt"));

            String[] ij = fileContents.get(0).split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);

            System.out.println("i="+i+", j="+j);


            int matrix[][] = new int[i][j];
            int maxNum = Integer.MIN_VALUE;
            int minNum = Integer.MAX_VALUE;

            for(int p=1; p<fileContents.size(); p++) {
                String line = fileContents.get(p);
                String[] nums = line.split(" ");

                for(int q=0; q<nums.length; q++) {
                    int num = Integer.parseInt(nums[q]);
                    if(num > maxNum) maxNum = num;
                    if(num < minNum) minNum = num;
                    matrix[p-1][q] = num;
                }
            }

            // print

            for(int p=0; p<i; p++) {
                for(int q=0; q<j; q++) {
                    System.out.print(matrix[p][q] + " ");
                }
                System.out.println("");
            }
            System.out.println("maxNum = " + maxNum + ", minNum = " + minNum);




        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
