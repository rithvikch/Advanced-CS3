class SearchSort{

    private int[] nums;

    public SearchSort(int[] nums){
        this.nums = nums;
    }

    public SearchSort(int size){
        nums = new int[size];
    }
    public void mergeSort(boolean print){
        mergeBOE(nums, nums.length);
    }

    public static void mergeBOE(int[] a, int n){
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
    
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeBOE(l, mid);
        mergeBOE(r, n - mid);
    
        merge(a, l, r, mid, n - mid);
    }

    public static void merge(
  int[] a, int[] l, int[] r, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }


}

    public void print(){
        for (int x : nums){
            System.out.print(x + " ");
        }
    }






public static void main(String[] args) {
    SearchSort thing = new SearchSort(new int[]{5,2,3,4,8,1,2});

    thing.mergeSort(true);
    thing.print();

}

}