package src.main.java.pra.old;

/**
 * ���ֲ���
 * 1.���ֲ����ֳ��۰���ң�����һ��Ч�ʽϸߵĲ��ҷ�����
 * 2.���ֲ���Ҫ�󣺣�1���������˳��洢�ṹ ��2��.���밴�ؼ��ִ�С��������
 * 3.ԭ���������Ϊ�����֣���������ֵ����ν����ֵ���������м�λ�õ��Ǹ�ֵ��ǰ����ֵ����ֵ��
 * ��Ҫ���ҵ�ֵ���������ֵ���бȽϣ���С����ֵ������ֵǰ ���ң���������ֵ������ֵ�����ң�
 * ������ֵʱֱ�ӷ��ء�Ȼ��������һ���ݹ���̣���ǰ�벿�ֻ��ߺ�벿�ּ����ֽ�Ϊ�����֡�
 * 4.ʵ�֣����ֲ��ҵ�ʵ���õݹ��ѭ�����ַ�ʽ
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println("ѭ������:" + binarySearch(arr, 87));
        System.out.println("�ݹ����:" + Search(arr, 0, arr.length - 1, 87));
    }

    //ѭ��ʵ�ֶ��ֲ����㷨arr ���ź��������x ��Ҫ���ҵ���-1 �޷��鵽����
    public static int binarySearch(int[] srcArray, int des) {
        //�����ʼ��С���������
        int low = 0;
        int high = srcArray.length - 1;
        //ȷ����������ظ����ң�Խ��
        while (low <= high) {
            //������м�����ֵ
            int middle = (high + low) /2;//��ֹ���
            if (des == srcArray[middle]) {
                return middle;
                //�ж�����
            } else if (des < srcArray[middle]) {
                high = middle - 1;
                //�ж�����
            } else {
                low = middle + 1;
            }
        }
        //��û�У��򷵻�-1
        return -1;
    }

    /**
     * ���ֲ��ҵݹ�ʵ�֡�
     * @param srcArray ��������
     * @param start    ����͵�ַ�±�
     * @param end      ����ߵ�ַ�±�
     * @param key      ����Ԫ��
     * @return ����Ԫ�ز����ڷ���-1
     */
    public static int Search(int srcArray[], int start, int end, int key) {
        int mid = (end - start) / 2 + start;
        //int mid = (end - start) >>> 1;
        if (srcArray[mid] == key) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return Search(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return Search(srcArray, start, mid - 1, key);
        }
        return -1;
    }
}
