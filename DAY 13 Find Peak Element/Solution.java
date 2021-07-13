class Solution {
    public int findPeakElement(int[] arr) {
        
//         int n = arr.length;
//         int low = 0;
//         int high = n-1;
        
//         while(low <= high) {
//             int mid = low + (high-low)/2;
//             if(mid > 0 && mid < n-1) {
//                 if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
//                 else if(arr[mid] < arr[mid-1]) high = mid-1;
//                 else low = mid+1;
//             } else if(mid == 0) {
//                 if(arr[0] > arr[mid]) return 0;
//                 else return 1;
//             } else if(mid == n-1) {
//                 if(arr[mid] > arr[n-1]) return n-2;
//                 else return n-1;
//             }
//         }
//         return low;
        // int low = 0, mid = 0, high = arr.length - 1;
        // while(low < high) {
        //     mid = low + (high-low)/2;
        //     if(arr[mid] < arr[mid+1]) low = mid+1;
        //     else high = mid;
        // }
        // return low;
        int n = arr.length;
        int start=0,end=n-1;
while(start<=end)
{
int mid=(start+end)/2;
if((mid==0||arr[mid-1]<=arr[mid])&&(mid==n-1||arr[mid+1]<=arr[mid]))
return mid;
if(mid>0&&arr[mid-1]>=arr[mid])
{
end=mid-1;
}
else
{
start=mid+1;
}
}
return -1;
    }
}
