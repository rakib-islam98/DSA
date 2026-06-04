import java.util.Arrays;

public class CarFleet {
    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] positionSpeed = new int[n][2]; //0:pos,1:speed
        for (int i = 0; i < n; i++) {
            positionSpeed[i][0] = position[i];
            positionSpeed[i][1] = speed[i];
        }
        Arrays.sort(positionSpeed, (a, b) -> Integer.compare(a[0], b[0]));
        // for(int[] x:pair) {
        //     System.out.println(x[0]+" "+x[1]);
        // }

        double lastFleetTime = (double) (target - positionSpeed[n - 1][0]) / positionSpeed[n - 1][1];    //time to reach target
        int fleet = 1;
        for (int i = n - 2; i >= 0; i--) {
            double currCarTime = (double) (target - positionSpeed[i][0]) / positionSpeed[i][1]; //current car time to reach target
            if (currCarTime > lastFleetTime) {
                fleet++;
                lastFleetTime = currCarTime;
            }
        }
        return fleet;
    }
    public static void main(String[] args) {
        int[] position = new int[]{10,8,0,5,3};
        int[] speed = new int[]{2,4,1,1,3};
        int target = 12;
        System.out.println(carFleet(target, position, speed));  //3

        position = new int[]{0,2,4};
        speed = new int[]{4,2,1};
        target = 100;
        System.out.println(carFleet(target, position, speed));  //1

    }
}