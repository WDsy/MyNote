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

package designmodel.listener;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author wei.Li by 15/3/19 (gourderwa@163.com).
 */
public class Lights {

    private boolean ok = false;

    private Vector<DemoListener> repository = new Vector<>();//监听自己的监听器队列

    public Lights() {
    }


    protected void addDemoListener(DemoListener dl) {
        repository.addElement(dl);
    }

    protected void removeDemoListener(DemoListener dl) {
        if (repository.size() > 0) {
            repository.remove(dl);
        }
    }

    protected void updateOk(boolean b) {
        ok = b;

        if (!ok) {
            notifyListener();
        }
    }

    private void notifyListener() {
        //通知所有的监听器
        Enumeration<DemoListener> enumeration = repository.elements();
        while (enumeration.hasMoreElements()) {
            DemoListener dl = enumeration.nextElement();
            dl.handleEvent(new DemoEvent(this));
        }
    }
}