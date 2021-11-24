public class SortingAlgorithm {
    public static void main(String[] args) {
        int[] array = new int[]{12,3,21,1, 2, 3, 45, 6, 7, 6, 5, 3};
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        sortingAlgorithm.sortingAlgorithm(array);
        for (int e:array) {
            System.out.println(e);
        }

    }
    public int[] sortingAlgorithm(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int min = array[i];
            int indeks = 0;
            for (int j = i+1; j < array.length; j++) {
                if(min>array[j]){
                    min=array[j];
                    indeks=j;
                }
            }
            int temp = array[i];
            array[i]=array[indeks];
            array[indeks]=temp;
        }


        return array;
    }
}

