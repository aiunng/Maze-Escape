package prj.util;

import java.util.List;
import prj.model.PointMode;

/**
 * 碰撞检测
 *
 * @author：wangXinYu
 * @date：2021/7/24 2:13 下午
 */
public class CollisionCheckUtil {

  public static boolean checkCollision4Lines(List<int[]> lines, PointMode point) {
    boolean collision = false;

    for (int[] line : lines) {
      boolean b = checkCollision4Line(line[0], line[1], line[2], line[3], point);
      if (b) {
        collision = b;
        break;
      }
    }
    return collision;
  }


  /**
   * 碰撞检测，点对线， x1=x2 竖线， y1=y2 横线
   *
   * @param x1    线头
   * @param y1    线头
   * @param x2    线尾
   * @param y2    线尾
   * @param point 待检测点
   * @return 碰撞true
   */
  public static boolean checkCollision4Line(int x1, int y1, int x2, int y2, PointMode point) {
    boolean collision = false;

    if (x1 == x2) {
      // 先判断x是否相等,再判断y是否在范围内
      if (x1 == point.getxPoint() && (y1 <= point.getyPoint() && point.getyPoint() <= y2)) {
        collision = true;
      }
    }

    if (y1 == y2) {
      // 先判断y是否相等,再判断x是否在范围内
      if (y1 == point.getyPoint() && (x1 <= point.getxPoint() && point.getxPoint() <= x2)) {
        collision = true;
      }
    }

    return collision;
  }

  /**
   * 碰撞检测，点对点，慎用，数据量大性能差
   *
   * @param pointList 检测点集合
   * @param point     待检测点
   * @return
   */
  public static boolean checkCollision4Point(List<int[]> pointList, PointMode point) {
    boolean collision = false;
    for (int[] ints : pointList) {
      if (ints[0] == point.getxPoint() &&
          ints[1] == point.getyPoint()) {
        collision = true;
        break;
      }
    }
    return collision;
  }
}
