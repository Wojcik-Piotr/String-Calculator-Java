package Calculator;

public class GetMedian {

    int getMedian(int[] array) {
        if (array.length == 0) {
            return -1;
        } else if (array.length % 2 == 0) {
            return ((array[array.length / 2] + array[(array.length - 1) / 2]) / 2);
        } else {
            return array[(array.length - 1) / 2];
        }
    }

}
