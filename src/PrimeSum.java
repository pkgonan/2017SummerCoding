
public class PrimeSum {
    public static void main(String[] args){
        int[] num = {1,2,3,4};
        System.out.println(solution(num));

    }
    static int solution(int[] nums) {
        boolean[] check = getPrimeArr();
        int cnt = 0;

        for(int i=0; i<nums.length; i++)
            for(int j=i+1; j<nums.length; j++)
                for(int k=j+1; k<nums.length; k++)
                    if(!check[nums[i]+nums[j]+nums[k]])
                        cnt++;
        return cnt;
    }

    static boolean[] getPrimeArr(){
        boolean[] arr = new boolean[100000];
        arr[0] = arr[1] = true;

        for(int i=2; i<Math.sqrt(arr.length); i++)
            for(int j=i+i; j<arr.length; j=j+i)
                arr[j] = true;
        return arr;
    }
}