package prj.manager;

import static prj.util.Constant.MAZE1_SUCCESS_POINTX;
import static prj.util.Constant.MAZE1_SUCCESS_POINTY;
import static prj.util.Constant.START_ICON;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author：wangXinYu
 * @date：2021/7/24 2:23 下午
 */
public class MazeManager {

  private static final int offSet = 30;

  /**
   * 存放当前迷宫坐标点
   */
  public static final List<int[]> mazePoints = new CopyOnWriteArrayList<>();

  // 初始化迷宫墙坐标
  static {
    initMaze1Point();
  }

  public static void paintMaze(Graphics g) {
    // 设置线宽
    Graphics2D g2d = (Graphics2D) g;
    BasicStroke basicStroke = new BasicStroke(2.0f);
    g2d.setStroke(basicStroke);

    paintMaze1(g);
  }

  /**
   * 迷宫1
   *
   * @param g
   */
  public static void paintMaze1(Graphics g) {
    // 开始图标
    g.drawString(START_ICON, 10, 22);
    // 结束图标
    g.drawString(START_ICON, MAZE1_SUCCESS_POINTX, MAZE1_SUCCESS_POINTY);
    // 1
    g.drawLine(0, offSet, offSet * 2, offSet);
    // 2
    g.drawLine(offSet * 3, offSet, offSet * 5, offSet);
    // 3
    g.drawLine(offSet * 5, offSet, offSet * 5, offSet * 4);
    // 4
    g.drawLine(offSet * 6, 0, offSet * 6, offSet * 3);
    // 5
    g.drawLine(offSet * 6, offSet * 3, offSet * 7, offSet * 3);
    // 6
    g.drawLine(offSet * 7, offSet, offSet * 7, offSet * 3);
    // 7
    g.drawLine(offSet * 8, offSet, offSet * 8, offSet * 3);
    // 8
    g.drawLine(offSet * 9, 0, offSet * 9, offSet * 2);
    // 9
    g.drawLine(offSet * 9, offSet * 2, offSet * 10, offSet * 2);
    // 10
    g.drawLine(offSet * 10, offSet, offSet * 11, offSet);
    // 11
    g.drawLine(offSet * 11, offSet, offSet * 11, offSet * 3);
    // 12
    g.drawLine(offSet * 12, offSet, offSet * 12, offSet * 3);
    // 13
    g.drawLine(offSet * 12, offSet * 3, offSet * 13, offSet * 3);
    // 14
    g.drawLine(offSet, offSet * 2, offSet * 2, offSet * 2);
    // 15
    g.drawLine(offSet * 2, offSet * 2, offSet * 2, offSet * 5);
    // 16
    g.drawLine(offSet * 2, offSet * 5, offSet * 3, offSet * 5);
    // 17
    g.drawLine(offSet * 3, offSet, offSet * 3, offSet * 6);
    // 18
    g.drawLine(offSet * 3, offSet * 6, offSet * 4, offSet * 6);
    // 19
    g.drawLine(offSet * 4, offSet * 2, offSet * 4, offSet * 6);
    // 20
    g.drawLine(offSet * 4, offSet * 5, offSet * 6, offSet * 5);
    // 21
    g.drawLine(offSet * 6, offSet * 4, offSet * 6, offSet * 5);
    // 22
    g.drawLine(offSet * 6, offSet * 4, offSet * 9, offSet * 4);
    // 23
    g.drawLine(offSet * 9, offSet * 3, offSet * 9, offSet * 4);
    // 23-1
    g.drawLine(offSet * 8, offSet * 3, offSet * 9, offSet * 3);
    // 24
    g.drawLine(offSet * 10, offSet * 3, offSet * 11, offSet * 3);
    // 25
    g.drawLine(offSet * 10, offSet * 3, offSet * 10, offSet * 5);
    // 26
    g.drawLine(offSet * 11, offSet * 4, offSet * 13, offSet * 4);
    // 27
    g.drawLine(0, offSet * 3, offSet, offSet * 3);
    // 28
    g.drawLine(offSet, offSet * 3, offSet, offSet * 6);
    // 29
    g.drawLine(offSet, offSet * 6, offSet * 2, offSet * 6);
    // 30
    g.drawLine(offSet, offSet * 7, offSet * 5, offSet * 7);
    // 31
    g.drawLine(offSet * 5, offSet * 6, offSet * 5, offSet * 7);
    // 32
    g.drawLine(offSet * 5, offSet * 6, offSet * 7, offSet * 6);
    // 33
    g.drawLine(offSet * 7, offSet * 5, offSet * 7, offSet * 6);
    // 34
    g.drawLine(offSet * 8, offSet * 4, offSet * 8, offSet * 10);
    // 35
    g.drawLine(offSet * 9, offSet * 5, offSet * 9, offSet * 6);
    // 35-1
    g.drawLine(offSet * 8, offSet * 6, offSet * 10, offSet * 6);
    // 36
    g.drawLine(offSet * 9, offSet * 5, offSet * 11, offSet * 5);
    // 37
    g.drawLine(offSet * 11, offSet * 5, offSet * 11, offSet * 6);
    // 38
    g.drawLine(offSet * 11, offSet * 6, offSet * 12, offSet * 6);
    // 39
    g.drawLine(offSet * 12, offSet * 4, offSet * 12, offSet * 6);
    // 40
    g.drawLine(offSet * 6, offSet * 7, offSet * 8, offSet * 7);
    // 41
    g.drawLine(offSet * 10, offSet * 6, offSet * 10, offSet * 8);
    // 42
    g.drawLine(offSet * 11, offSet * 7, offSet * 13, offSet * 7);
    // 43
    g.drawLine(0, offSet * 9, offSet, offSet * 9);
    // 44
    g.drawLine(offSet, offSet * 8, offSet, offSet * 9);
    // 45
    g.drawLine(offSet * 2, offSet * 7, offSet * 2, offSet * 10);
    // 46
    g.drawLine(offSet, offSet * 10, offSet * 2, offSet * 10);
    // 47
    g.drawLine(offSet * 3, offSet * 8, offSet * 3, offSet * 9);
    // 48
    g.drawLine(offSet * 3, offSet * 9, offSet * 5, offSet * 9);
    // 49
    g.drawLine(offSet * 4, offSet * 7, offSet * 4, offSet * 8);
    // 50
    g.drawLine(offSet * 4, offSet * 8, offSet * 6, offSet * 8);
    // 51
    g.drawLine(offSet * 6, offSet * 8, offSet * 6, offSet * 9);
    // 52
    g.drawLine(offSet * 6, offSet * 9, offSet * 7, offSet * 9);
    // 53
    g.drawLine(offSet * 7, offSet * 7, offSet * 7, offSet * 9);
    // 54
    g.drawLine(offSet * 9, offSet * 7, offSet * 9, offSet * 9);
    // 55
    g.drawLine(offSet * 9, offSet * 9, offSet * 11, offSet * 9);
    // 56
    g.drawLine(offSet * 10, offSet * 8, offSet * 12, offSet * 8);
    // 57
    g.drawLine(offSet * 12, offSet * 8, offSet * 12, offSet * 9);
    // 58
    g.drawLine(0, offSet * 11, offSet * 3, offSet * 11);
    // 59
    g.drawLine(offSet * 3, offSet * 10, offSet * 3, offSet * 11);
    // 60
    g.drawLine(offSet * 3, offSet * 10, offSet * 4, offSet * 10);
    // 61
    g.drawLine(offSet * 5, offSet * 9, offSet * 5, offSet * 11);
    // 62
    g.drawLine(offSet * 5, offSet * 10, offSet * 10, offSet * 10);
    // 63
    g.drawLine(offSet * 10, offSet * 10, offSet * 10, offSet * 12);
    // 64
    g.drawLine(offSet * 11, offSet * 9, offSet * 11, offSet * 13);
    // 65
    g.drawLine(offSet * 12, offSet * 10, offSet * 13, offSet * 10);
    // 66
    g.drawLine(offSet * 12, offSet * 10, offSet * 12, offSet * 12);
    // 67
    g.drawLine(offSet, offSet * 12, offSet * 4, offSet * 12);
    // 68
    g.drawLine(offSet * 4, offSet * 11, offSet * 4, offSet * 12);
    // 69
    g.drawLine(offSet * 4, offSet * 11, offSet * 6, offSet * 11);
    // 70
    g.drawLine(offSet * 6, offSet * 11, offSet * 6, offSet * 12);
    // 71
    g.drawLine(offSet * 7, offSet * 10, offSet * 7, offSet * 11);
    // 72
    g.drawLine(offSet * 7, offSet * 11, offSet * 8, offSet * 11);
    // 73
    g.drawLine(offSet * 8, offSet * 11, offSet * 8, offSet * 12);
    // 74
    g.drawLine(offSet * 9, offSet * 11, offSet * 9, offSet * 13);
    // 75
    g.drawLine(offSet * 5, offSet * 12, offSet * 5, offSet * 13);
    // 76
    g.drawLine(offSet * 7, offSet * 12, offSet * 7, offSet * 13);
  }

  /**
   * 初始化迷宫1的坐标
   */
  public static void initMaze1Point() {
    // 1
    mazePoints.add(new int[]{0, offSet, offSet * 2, offSet});
    // 2
    mazePoints.add(new int[]{offSet * 3, offSet, offSet * 5, offSet});
    // 3
    mazePoints.add(new int[]{offSet * 5, offSet, offSet * 5, offSet * 4});
    // 4
    mazePoints.add(new int[]{offSet * 6, 0, offSet * 6, offSet * 3});
    // 5
    mazePoints.add(new int[]{offSet * 6, offSet * 3, offSet * 7, offSet * 3});
    // 6
    mazePoints.add(new int[]{offSet * 7, offSet, offSet * 7, offSet * 3});
    // 7
    mazePoints.add(new int[]{offSet * 8, offSet, offSet * 8, offSet * 3});
    // 8
    mazePoints.add(new int[]{offSet * 9, 0, offSet * 9, offSet * 2});
    // 9
    mazePoints.add(new int[]{offSet * 9, offSet * 2, offSet * 10, offSet * 2});
    // 10
    mazePoints.add(new int[]{offSet * 10, offSet, offSet * 11, offSet});
    // 11
    mazePoints.add(new int[]{offSet * 11, offSet, offSet * 11, offSet * 3});
    // 12
    mazePoints.add(new int[]{offSet * 12, offSet, offSet * 12, offSet * 3});
    // 13
    mazePoints.add(new int[]{offSet * 12, offSet * 3, offSet * 13, offSet * 3});
    // 14
    mazePoints.add(new int[]{offSet, offSet * 2, offSet * 2, offSet * 2});
    // 15
    mazePoints.add(new int[]{offSet * 2, offSet * 2, offSet * 2, offSet * 5});
    // 16
    mazePoints.add(new int[]{offSet * 2, offSet * 5, offSet * 3, offSet * 5});
    // 17
    mazePoints.add(new int[]{offSet * 3, offSet, offSet * 3, offSet * 6});
    // 18
    mazePoints.add(new int[]{offSet * 3, offSet * 6, offSet * 4, offSet * 6});
    // 19
    mazePoints.add(new int[]{offSet * 4, offSet * 2, offSet * 4, offSet * 6});
    // 20
    mazePoints.add(new int[]{offSet * 4, offSet * 5, offSet * 6, offSet * 5});
    // 21
    mazePoints.add(new int[]{offSet * 6, offSet * 4, offSet * 6, offSet * 5});
    // 22
    mazePoints.add(new int[]{offSet * 6, offSet * 4, offSet * 9, offSet * 4});
    // 23
    mazePoints.add(new int[]{offSet * 9, offSet * 3, offSet * 9, offSet * 4});
    // 23-1
    mazePoints.add(new int[]{offSet * 8, offSet * 3, offSet * 9, offSet * 3});
    // 24
    mazePoints.add(new int[]{offSet * 10, offSet * 3, offSet * 11, offSet * 3});
    // 25
    mazePoints.add(new int[]{offSet * 10, offSet * 3, offSet * 10, offSet * 5});
    // 26
    mazePoints.add(new int[]{offSet * 11, offSet * 4, offSet * 13, offSet * 4});
    // 27
    mazePoints.add(new int[]{0, offSet * 3, offSet, offSet * 3});
    // 28
    mazePoints.add(new int[]{offSet, offSet * 3, offSet, offSet * 6});
    // 29
    mazePoints.add(new int[]{offSet, offSet * 6, offSet * 2, offSet * 6});
    // 30
    mazePoints.add(new int[]{offSet, offSet * 7, offSet * 5, offSet * 7});
    // 31
    mazePoints.add(new int[]{offSet * 5, offSet * 6, offSet * 5, offSet * 7});
    // 32
    mazePoints.add(new int[]{offSet * 5, offSet * 6, offSet * 7, offSet * 6});
    // 33
    mazePoints.add(new int[]{offSet * 7, offSet * 5, offSet * 7, offSet * 6});
    // 34
    mazePoints.add(new int[]{offSet * 8, offSet * 4, offSet * 8, offSet * 10});
    // 35
    mazePoints.add(new int[]{offSet * 9, offSet * 5, offSet * 9, offSet * 6});
    // 35-1
    mazePoints.add(new int[]{offSet * 8, offSet * 6, offSet * 10, offSet * 6});
    // 36
    mazePoints.add(new int[]{offSet * 9, offSet * 5, offSet * 11, offSet * 5});
    // 37
    mazePoints.add(new int[]{offSet * 11, offSet * 5, offSet * 11, offSet * 6});
    // 38
    mazePoints.add(new int[]{offSet * 11, offSet * 6, offSet * 12, offSet * 6});
    // 39
    mazePoints.add(new int[]{offSet * 12, offSet * 4, offSet * 12, offSet * 6});
    // 40
    mazePoints.add(new int[]{offSet * 6, offSet * 7, offSet * 8, offSet * 7});
    // 41
    mazePoints.add(new int[]{offSet * 10, offSet * 6, offSet * 10, offSet * 8});
    // 42
    mazePoints.add(new int[]{offSet * 11, offSet * 7, offSet * 13, offSet * 7});
    // 43
    mazePoints.add(new int[]{0, offSet * 9, offSet, offSet * 9});
    // 44
    mazePoints.add(new int[]{offSet, offSet * 8, offSet, offSet * 9});
    // 45
    mazePoints.add(new int[]{offSet * 2, offSet * 7, offSet * 2, offSet * 10});
    // 46
    mazePoints.add(new int[]{offSet, offSet * 10, offSet * 2, offSet * 10});
    // 47
    mazePoints.add(new int[]{offSet * 3, offSet * 8, offSet * 3, offSet * 9});
    // 48
    mazePoints.add(new int[]{offSet * 3, offSet * 9, offSet * 5, offSet * 9});
    // 49
    mazePoints.add(new int[]{offSet * 4, offSet * 7, offSet * 4, offSet * 8});
    // 50
    mazePoints.add(new int[]{offSet * 4, offSet * 8, offSet * 6, offSet * 8});
    // 51
    mazePoints.add(new int[]{offSet * 6, offSet * 8, offSet * 6, offSet * 9});
    // 52
    mazePoints.add(new int[]{offSet * 6, offSet * 9, offSet * 7, offSet * 9});
    // 53
    mazePoints.add(new int[]{offSet * 7, offSet * 7, offSet * 7, offSet * 9});
    // 54
    mazePoints.add(new int[]{offSet * 9, offSet * 7, offSet * 9, offSet * 9});
    // 55
    mazePoints.add(new int[]{offSet * 9, offSet * 9, offSet * 11, offSet * 9});
    // 56
    mazePoints.add(new int[]{offSet * 10, offSet * 8, offSet * 12, offSet * 8});
    // 57
    mazePoints.add(new int[]{offSet * 12, offSet * 8, offSet * 12, offSet * 9});
    // 58
    mazePoints.add(new int[]{0, offSet * 11, offSet * 3, offSet * 11});
    // 59
    mazePoints.add(new int[]{offSet * 3, offSet * 10, offSet * 3, offSet * 11});
    // 60
    mazePoints.add(new int[]{offSet * 3, offSet * 10, offSet * 4, offSet * 10});
    // 61
    mazePoints.add(new int[]{offSet * 5, offSet * 9, offSet * 5, offSet * 11});
    // 62
    mazePoints.add(new int[]{offSet * 5, offSet * 10, offSet * 10, offSet * 10});
    // 63
    mazePoints.add(new int[]{offSet * 10, offSet * 10, offSet * 10, offSet * 12});
    // 64
    mazePoints.add(new int[]{offSet * 11, offSet * 9, offSet * 11, offSet * 13});
    // 65
    mazePoints.add(new int[]{offSet * 12, offSet * 10, offSet * 13, offSet * 10});
    // 66
    mazePoints.add(new int[]{offSet * 12, offSet * 10, offSet * 12, offSet * 12});
    // 67
    mazePoints.add(new int[]{offSet, offSet * 12, offSet * 4, offSet * 12});
    // 68
    mazePoints.add(new int[]{offSet * 4, offSet * 11, offSet * 4, offSet * 12});
    // 69
    mazePoints.add(new int[]{offSet * 4, offSet * 11, offSet * 6, offSet * 11});
    // 70
    mazePoints.add(new int[]{offSet * 6, offSet * 11, offSet * 6, offSet * 12});
    // 71
    mazePoints.add(new int[]{offSet * 7, offSet * 10, offSet * 7, offSet * 11});
    // 72
    mazePoints.add(new int[]{offSet * 7, offSet * 11, offSet * 8, offSet * 11});
    // 73
    mazePoints.add(new int[]{offSet * 8, offSet * 11, offSet * 8, offSet * 12});
    // 74
    mazePoints.add(new int[]{offSet * 9, offSet * 11, offSet * 9, offSet * 13});
    // 75
    mazePoints.add(new int[]{offSet * 5, offSet * 12, offSet * 5, offSet * 13});
    // 76
    mazePoints.add(new int[]{offSet * 7, offSet * 12, offSet * 7, offSet * 13});
  }

  public static List<int[]> getMazePoints() {
    return mazePoints;
  }

  public static void main(String[] args) {

  }
}
