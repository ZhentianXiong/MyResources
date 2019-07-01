package LintCode;

public class T2_447_SearchBigSortedArray {

//从一个不知道长度的递增数组中找到某个值

    /*public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        public int searchBigSortedArray(ArrayReader reader, int target) {
            // write your code here
            if(target == reader.get(0)){
                return 0;
            }

            int k = 1;
            while(reader.get(k) != Integer.MAX_VALUE && target > reader.get(k)){
                k = 2*k;
            }

            return binarySearch(k/2,k,reader,target);

        }

        public int binarySearch(int start, int end, ArrayReader reader, int target){
            while(start < end){
                int mid = start + (end-start)/2;
                if(reader.get(mid) == Integer.MAX_VALUE){
                    end = mid;
                }else{
                    if(reader.get(mid) < target){
                        start = mid+1;
                    }else{
                        end = mid;
                    }
                }
            }

            if(reader.get(end) != target){
                return -1;
            }else{
                return end;
            }
        }
    }*/

}
