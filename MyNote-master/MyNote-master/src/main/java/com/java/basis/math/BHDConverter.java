/*
 * Written by wei.Li and released to the public domain
 * Welcome to correct discussion as explained at
 *
 * -----------------------------------------------------------------
 *
 * GitHub:  https://github.com/GourdErwa
 * CSDN  :	http://blog.csdn.net/xiaohulunb
 * WeiBo :	http://www.weibo.com/xiaohulunb  	@GourdErwa
 * Email :	gourderwa@163.com
 *
 * Personal home page: http://grouderwa.com
 */

package com.java.basis.math;

/**
 * 进制转换器
 *
 * @author wei.Li by 14/10/8.
 */
public class BHDConverter {

    public static final double HEX = 0x1000_0000_0000_0000L;

    private static void hex() {

        String s = "01FF";

        System.out.println(Integer.toOctalString(11));
        System.out.println(Double.toHexString(HEX));
        System.out.println(Integer.parseInt("0x1.65a0bcp33", 16));

    }

    public static void main(String[] args) {

        System.out.println(HEX);
    }
}
/**
 * 转换
 * <p>
 * 二进制转换十进制
 * <p>
 * 二进制数第0位的权值是2的0次方，第1位的权值是2的1次方……
 * 所以，设有一个二进制数：101100100，转换为10进制为：356
 * 用横式计算
 * 0×20+0×21+1×22+0×23+0×24+1×25+1×26+0×27+1×28=356
 * 0乘以多少都是0，所以我们也可以直接跳过值为0的位：
 * 1×22+1×25+1×26+1×28=356
 * 4+32+64+256 =356
 * <p>
 * <p>
 * 八进制转换十进制
 * <p>
 * 八进制就是逢8进1。
 * 八进制数采用 0～7这八数来表达一个数。
 * 八进制数第0位的权值为8的0次方，第1位权值为8的1次方，第2位权值为8的2次方……
 * 所以，设有一个八进制数：1507，转换为十进制为：839，具体方法如下：
 * 可以用横式直接计算：
 * 7×80+0×81+5×82+1×83=839
 * 也可以用竖式表示
 * 第0位 7×80=7
 * 第1位 0×81=0
 * 第2位 5×82=320
 * 第3位 1×83=512
 * <p>
 * <p>
 * 十六进制转换十进制
 * <p>
 * 16进制就是逢16进1，但我们只有0~9这十个数字，所以我们用A，B，C，D，E，F这六个字母来分别表示10，11，12，13，14，15。字母不区分大小写。
 * 十六进制数的第0位的权值为16的0次方，第1位的权值为16的1次方，第2位的权值为16的2次方……
 * 所以，在第N（N从0开始）位上，如果是数β （β大于等于0，并且β小于等于 15，即：F）表示的大小为 β×16的N次方。
 * 假设有一个十六进数 2AF5
 * 直接计算就是：
 * 5×160+F×161+A×162+2×163=10997[1]
 * 也可以用竖式表示：
 * 第0位： 5×160=5
 * 第1位： F×16^1=240
 * 第2位： A×162=2560
 * 第3位： 2×163=8192
 * -------------------------------
 * 10997
 * 此处可以看出，所有进制换算成10进制，关键在于各自的权值不同。
 * 假设有人问你，十进数 1234 为什么是 一千二百三十四？你尽可以给他这么一个算式：
 * 1234 = 1×103+2×102+3×101+4×100
 * <p>
 * <p>
 * 十六进制互相转换
 * <p>
 * 首先我们来看一个二进制数：1111，它是多少呢？
 * 你可能还要这样计算：1×20+1×21+1×22+1×23=1×1+1×2+1×4+1×8=15。
 * 然而，由于1111才4位，所以我们必须直接记住它每一位的权值，并且是从高位往低位记，：8、4、2、1。即，最高位的权值为23=8，然后依次是 22=4，21=2，20=1。
 * 记住8421，对于任意一个4位的二进制数，我们都可以很快算出它对应的10进制值。
 * 下面列出四位二进制数 xxxx 所有可能的值（中间略过部分）
 * 仅4位的2进制数 快速计算方法 十进制值 十六进制
 * 1111 = 8 + 4 + 2 + 1 = 15 =F
 * 1110 = 8 + 4 + 2 + 0 = 14= E
 * 1101 = 8 + 4 + 0 + 1 = 13= D
 * 1100 = 8 + 4 + 0 + 0 = 12 =C
 * 1011 = 8 + 0 + 2 + 1 = 11= B
 * 1010 = 8 + 0 + 2 + 0 = 10 =A
 * 1001 = 8 + 0 + 0 + 1 =9 =9
 * ……
 * 0001 = 0 + 0 + 0 + 1 = 1= 1
 * 0000 = 0 + 0 + 0 + 0 = 0= 0
 * 二进制数要转换为十六进制，就是以4位一段，分别转换为十六进制。
 * 如（上行为二制数，下面为对应的十六进制）：
 * 1111 1101 ， 1010 0101 ， 1001 1011
 * F D ， A 5 ， 9 B
 * 反过来，当我们看到 FD时，如何迅速将它转换为二进制数呢？
 * 先转换F：
 * 看到F，我们需知道它是15（可能你还不熟悉A～F这五个数），然后15如何用8421凑呢？应该是8 + 4 + 2 + 1，所以四位全为1 ：1111。
 * 接着转换D
 * 看到D，知道它是13，13如何用8421凑呢？应该是：8 + 4 + 1，即：1101。
 * 所以，FD转换为二进制数，为：1111 1101
 * 由于十六进制转换成二进制相当直接，所以，我们需要将一个十进制数转换成2进制数时，也可以先转换成16进制，然后再转换成2进制。
 * 比如，十进制数 1234转换成二制数，如果要一直除以2，直接得到2进制数，需要计算较多次数。所以我们可以先除以16，得到16进制数：
 * 被除数  计算过程  商 余数
 * 1234   1234/16 77  2
 * 77     77/16   4   13 (D)
 * 4      4/16    0   4
 * 结果16进制为：4D2
 * 然后我们可直接写出4D2的二进制形式：
 * 0100
 * 1101
 * 0010
 * 其中对映关系为：
 * 0100 -- 4
 * 1101 -- D
 * 0010 -- 2
 * 同样，如果一个二进制数很长，我们需要将它转换成10进制数时，除了前面学过的方法是，我们还可以先将这个二进制转换成16进制，然后再转换为10进制。
 * 下面举例一个int类型的二进制数：
 * 01101101
 * 11100101
 * 10101111
 * 00011011
 * 我们按四位一组转换为16进制：6D E5 AF 1B
 * 十进制转十六进制
 * 采余数定理分解，例如将487710转成十六进制：
 * <p>
 * [2]
 * 487710÷16=30481....14(E)
 * 30481÷16=1905....1
 * 1905÷16=119....1
 * 119÷16=7....7
 * 7÷16=0....7
 * 这样就计到487710（10）=7711E（16）
 **/