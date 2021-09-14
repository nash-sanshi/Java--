package src.main.java.day4;

/**
 定义一个用户操作数组的工具类
 如：获取最大值
 @author 张磊
 @version V1.0
*/

public class Four8_ArrayTool
{
	/*强制不让其他类创建该类的对象，当类中成员都是静态的，记得将构造方法私有化
	因为创建对象没有意义*/

	/**
	 * 该类的空参数构造函数
	 */
	private Four8_ArrayTool(){}

	/**
	 * 获取int数组最大值
	 * @param arr：用于接收一个int类型数组
	 * @return 返回该数组最大值
	 */
	public static int getMax(int[] arr)
	{
		int max = arr[0];
		for (int x =1; x < arr.length; x++)
		{
			if (arr[x] > max)
				max = arr[x];
		}
		return max;
	}

	/**
	 * 对int数组进行从小到大排序
	 * @param arr ：用于接收一个int类型数组
	 * @return
	 */
	public static void bubbleSort(int[] arr)
	{
		for (int i = 0; i < arr.length -1; i++) {
			for (int j = 0; j < arr.length -i-1; j++) {
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}