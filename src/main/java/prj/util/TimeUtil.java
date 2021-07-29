package prj.util;

/**
 * @author：wangXinYu
 * @date：2021/7/29 11:24 上午
 */
public class TimeUtil {

  public static String toStringTime(long time) {
    long second = time / 1000;
    String minute = String.valueOf(second / 60);
    String s = String.valueOf(second % 60);
    return minute + "分" + s + "秒";
  }

}
