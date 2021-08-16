package src.main.java.day7;

public class PolyTest6
{
	//需求：电脑运行
	//功能实现：鼠标
	//定义接口解耦
	public static void main(String[] args)
	{
		NoteBook thinkpad = new NoteBook();
		thinkpad.run();
		thinkpad.useUsb(null);
		thinkpad.useUsb(new USBMouse());
	}
}

class NoteBook
{
	void run()
	{
		System.out.println("notebook run");
	}

	//接口类型变量
	void useUsb(USB usb)
	{
		if (usb != null)
		{
			usb.open();
			usb.close();		
		}
	}
}

//定义规则
interface USB
{
	void open();
	void close();
}

class USBMouse implements USB
{
	public void open()
	{
		System.out.println("usbmouse open");
	}
	public void close()
	{
		System.out.println("usbmouse close");
	}
}