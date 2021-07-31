package prj.manager;

import static prj.manager.SysOptions.getCurrentMaze;
import static prj.util.Constant.MAZE1_SUCCESS_POINTX;
import static prj.util.Constant.MAZE1_SUCCESS_POINTY;
import static prj.util.Constant.START_ICON;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 迷宫图点位
 * @author：wangXinYu
 * @date：2021/7/24 2:23 下午
 */
public class MazeManager {

  private static final int offSet = 30;

  /**
   * 存放迷宫1坐标点
   */
  public static final List<int[]> maze1Points = new CopyOnWriteArrayList<>();
  /**
   * 存放迷宫2坐标点
   */
  public static final List<int[]> maze2Points = new CopyOnWriteArrayList<>();
  /**
   * 所有迷宫
   */
  public static final Map<Integer, List<int[]>> mazeMaps = new ConcurrentHashMap<>();

  // 初始化迷宫墙坐标
  static {
    initMaze1Point();
    initMaze2Point();

    mazeMaps.put(1, maze1Points);
    mazeMaps.put(2, maze2Points);

  }

  public static void paintMaze(Graphics g) {
    // 设置线宽
    Graphics2D g2d = (Graphics2D) g;
    BasicStroke basicStroke = new BasicStroke(2.0f);
    g2d.setStroke(basicStroke);

    Integer currentMaze = getCurrentMaze();
    switch (currentMaze) {
      case 1:
        paintMaze1(g);
        break;
      case 2:
        paintMaze2(g);
        break;
      default:
        paintMaze1(g);
        break;
    }
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
    maze1Points.add(new int[]{0, offSet, offSet * 2, offSet});
    // 2
    maze1Points.add(new int[]{offSet * 3, offSet, offSet * 5, offSet});
    // 3
    maze1Points.add(new int[]{offSet * 5, offSet, offSet * 5, offSet * 4});
    // 4
    maze1Points.add(new int[]{offSet * 6, 0, offSet * 6, offSet * 3});
    // 5
    maze1Points.add(new int[]{offSet * 6, offSet * 3, offSet * 7, offSet * 3});
    // 6
    maze1Points.add(new int[]{offSet * 7, offSet, offSet * 7, offSet * 3});
    // 7
    maze1Points.add(new int[]{offSet * 8, offSet, offSet * 8, offSet * 3});
    // 8
    maze1Points.add(new int[]{offSet * 9, 0, offSet * 9, offSet * 2});
    // 9
    maze1Points.add(new int[]{offSet * 9, offSet * 2, offSet * 10, offSet * 2});
    // 10
    maze1Points.add(new int[]{offSet * 10, offSet, offSet * 11, offSet});
    // 11
    maze1Points.add(new int[]{offSet * 11, offSet, offSet * 11, offSet * 3});
    // 12
    maze1Points.add(new int[]{offSet * 12, offSet, offSet * 12, offSet * 3});
    // 13
    maze1Points.add(new int[]{offSet * 12, offSet * 3, offSet * 13, offSet * 3});
    // 14
    maze1Points.add(new int[]{offSet, offSet * 2, offSet * 2, offSet * 2});
    // 15
    maze1Points.add(new int[]{offSet * 2, offSet * 2, offSet * 2, offSet * 5});
    // 16
    maze1Points.add(new int[]{offSet * 2, offSet * 5, offSet * 3, offSet * 5});
    // 17
    maze1Points.add(new int[]{offSet * 3, offSet, offSet * 3, offSet * 6});
    // 18
    maze1Points.add(new int[]{offSet * 3, offSet * 6, offSet * 4, offSet * 6});
    // 19
    maze1Points.add(new int[]{offSet * 4, offSet * 2, offSet * 4, offSet * 6});
    // 20
    maze1Points.add(new int[]{offSet * 4, offSet * 5, offSet * 6, offSet * 5});
    // 21
    maze1Points.add(new int[]{offSet * 6, offSet * 4, offSet * 6, offSet * 5});
    // 22
    maze1Points.add(new int[]{offSet * 6, offSet * 4, offSet * 9, offSet * 4});
    // 23
    maze1Points.add(new int[]{offSet * 9, offSet * 3, offSet * 9, offSet * 4});
    // 23-1
    maze1Points.add(new int[]{offSet * 8, offSet * 3, offSet * 9, offSet * 3});
    // 24
    maze1Points.add(new int[]{offSet * 10, offSet * 3, offSet * 11, offSet * 3});
    // 25
    maze1Points.add(new int[]{offSet * 10, offSet * 3, offSet * 10, offSet * 5});
    // 26
    maze1Points.add(new int[]{offSet * 11, offSet * 4, offSet * 13, offSet * 4});
    // 27
    maze1Points.add(new int[]{0, offSet * 3, offSet, offSet * 3});
    // 28
    maze1Points.add(new int[]{offSet, offSet * 3, offSet, offSet * 6});
    // 29
    maze1Points.add(new int[]{offSet, offSet * 6, offSet * 2, offSet * 6});
    // 30
    maze1Points.add(new int[]{offSet, offSet * 7, offSet * 5, offSet * 7});
    // 31
    maze1Points.add(new int[]{offSet * 5, offSet * 6, offSet * 5, offSet * 7});
    // 32
    maze1Points.add(new int[]{offSet * 5, offSet * 6, offSet * 7, offSet * 6});
    // 33
    maze1Points.add(new int[]{offSet * 7, offSet * 5, offSet * 7, offSet * 6});
    // 34
    maze1Points.add(new int[]{offSet * 8, offSet * 4, offSet * 8, offSet * 10});
    // 35
    maze1Points.add(new int[]{offSet * 9, offSet * 5, offSet * 9, offSet * 6});
    // 35-1
    maze1Points.add(new int[]{offSet * 8, offSet * 6, offSet * 10, offSet * 6});
    // 36
    maze1Points.add(new int[]{offSet * 9, offSet * 5, offSet * 11, offSet * 5});
    // 37
    maze1Points.add(new int[]{offSet * 11, offSet * 5, offSet * 11, offSet * 6});
    // 38
    maze1Points.add(new int[]{offSet * 11, offSet * 6, offSet * 12, offSet * 6});
    // 39
    maze1Points.add(new int[]{offSet * 12, offSet * 4, offSet * 12, offSet * 6});
    // 40
    maze1Points.add(new int[]{offSet * 6, offSet * 7, offSet * 8, offSet * 7});
    // 41
    maze1Points.add(new int[]{offSet * 10, offSet * 6, offSet * 10, offSet * 8});
    // 42
    maze1Points.add(new int[]{offSet * 11, offSet * 7, offSet * 13, offSet * 7});
    // 43
    maze1Points.add(new int[]{0, offSet * 9, offSet, offSet * 9});
    // 44
    maze1Points.add(new int[]{offSet, offSet * 8, offSet, offSet * 9});
    // 45
    maze1Points.add(new int[]{offSet * 2, offSet * 7, offSet * 2, offSet * 10});
    // 46
    maze1Points.add(new int[]{offSet, offSet * 10, offSet * 2, offSet * 10});
    // 47
    maze1Points.add(new int[]{offSet * 3, offSet * 8, offSet * 3, offSet * 9});
    // 48
    maze1Points.add(new int[]{offSet * 3, offSet * 9, offSet * 5, offSet * 9});
    // 49
    maze1Points.add(new int[]{offSet * 4, offSet * 7, offSet * 4, offSet * 8});
    // 50
    maze1Points.add(new int[]{offSet * 4, offSet * 8, offSet * 6, offSet * 8});
    // 51
    maze1Points.add(new int[]{offSet * 6, offSet * 8, offSet * 6, offSet * 9});
    // 52
    maze1Points.add(new int[]{offSet * 6, offSet * 9, offSet * 7, offSet * 9});
    // 53
    maze1Points.add(new int[]{offSet * 7, offSet * 7, offSet * 7, offSet * 9});
    // 54
    maze1Points.add(new int[]{offSet * 9, offSet * 7, offSet * 9, offSet * 9});
    // 55
    maze1Points.add(new int[]{offSet * 9, offSet * 9, offSet * 11, offSet * 9});
    // 56
    maze1Points.add(new int[]{offSet * 10, offSet * 8, offSet * 12, offSet * 8});
    // 57
    maze1Points.add(new int[]{offSet * 12, offSet * 8, offSet * 12, offSet * 9});
    // 58
    maze1Points.add(new int[]{0, offSet * 11, offSet * 3, offSet * 11});
    // 59
    maze1Points.add(new int[]{offSet * 3, offSet * 10, offSet * 3, offSet * 11});
    // 60
    maze1Points.add(new int[]{offSet * 3, offSet * 10, offSet * 4, offSet * 10});
    // 61
    maze1Points.add(new int[]{offSet * 5, offSet * 9, offSet * 5, offSet * 11});
    // 62
    maze1Points.add(new int[]{offSet * 5, offSet * 10, offSet * 10, offSet * 10});
    // 63
    maze1Points.add(new int[]{offSet * 10, offSet * 10, offSet * 10, offSet * 12});
    // 64
    maze1Points.add(new int[]{offSet * 11, offSet * 9, offSet * 11, offSet * 13});
    // 65
    maze1Points.add(new int[]{offSet * 12, offSet * 10, offSet * 13, offSet * 10});
    // 66
    maze1Points.add(new int[]{offSet * 12, offSet * 10, offSet * 12, offSet * 12});
    // 67
    maze1Points.add(new int[]{offSet, offSet * 12, offSet * 4, offSet * 12});
    // 68
    maze1Points.add(new int[]{offSet * 4, offSet * 11, offSet * 4, offSet * 12});
    // 69
    maze1Points.add(new int[]{offSet * 4, offSet * 11, offSet * 6, offSet * 11});
    // 70
    maze1Points.add(new int[]{offSet * 6, offSet * 11, offSet * 6, offSet * 12});
    // 71
    maze1Points.add(new int[]{offSet * 7, offSet * 10, offSet * 7, offSet * 11});
    // 72
    maze1Points.add(new int[]{offSet * 7, offSet * 11, offSet * 8, offSet * 11});
    // 73
    maze1Points.add(new int[]{offSet * 8, offSet * 11, offSet * 8, offSet * 12});
    // 74
    maze1Points.add(new int[]{offSet * 9, offSet * 11, offSet * 9, offSet * 13});
    // 75
    maze1Points.add(new int[]{offSet * 5, offSet * 12, offSet * 5, offSet * 13});
    // 76
    maze1Points.add(new int[]{offSet * 7, offSet * 12, offSet * 7, offSet * 13});
  }

  /**
   * 迷宫2
   *
   * @param g
   */
  public static void paintMaze2(Graphics g) {
    // 开始图标
    g.drawString(START_ICON, 10, 82);
    // 结束图标
    g.drawString(START_ICON, 360, 145);
    // 1
    g.drawLine(0, offSet * 2, offSet * 2, offSet * 2);
    // 2
    g.drawLine(offSet, offSet, offSet * 3, offSet);
    // 3
    g.drawLine(offSet * 3, offSet, offSet * 3, offSet * 3);
    // 4
    g.drawLine(offSet * 4, 0, offSet * 4, offSet * 2);
    // 5
    g.drawLine(0, offSet * 3, offSet * 5, offSet * 3);
    // 6
    g.drawLine(offSet * 5, offSet, offSet * 5, offSet * 3);
    // 7
    g.drawLine(offSet * 6, 0, offSet * 6, offSet);
    // 8
    g.drawLine(offSet * 6, offSet * 2, offSet * 6, offSet * 6);
    // 9
    g.drawLine(offSet * 6, offSet * 2, offSet * 9, offSet * 2);
    // 10
    g.drawLine(offSet * 7, offSet, offSet * 9, offSet);
    // 11
    g.drawLine(offSet * 9, offSet, offSet * 9, offSet * 2);
    // 12
    g.drawLine(offSet * 10, 0, offSet * 10, offSet * 3);
    // 13
    g.drawLine(offSet * 11, offSet, offSet * 11, offSet * 4);
    // 14
    g.drawLine(offSet * 11, offSet, offSet * 12, offSet);
    // 15
    g.drawLine(offSet * 12, offSet, offSet * 12, offSet * 4);
    // 16
    g.drawLine(offSet * 12, offSet * 4, offSet * 13, offSet * 4);
    // 17
    g.drawLine(offSet, offSet * 4, offSet * 6, offSet * 4);
    // 18
    g.drawLine(offSet * 7, offSet * 3, offSet * 7, offSet * 5);
    // 19
    g.drawLine(offSet * 7, offSet * 3, offSet * 10, offSet * 3);
    // 20
    g.drawLine(offSet * 8, offSet * 4, offSet * 11, offSet * 4);
    // 21
    g.drawLine(offSet, offSet * 5, offSet * 2, offSet * 5);
    // 22
    g.drawLine(offSet * 3, offSet * 5, offSet * 5, offSet * 5);
    // 23
    g.drawLine(offSet * 7, offSet * 5, offSet * 8, offSet * 5);
    // 24
    g.drawLine(offSet * 8, offSet * 5, offSet * 8, offSet * 7);
    // 25
    g.drawLine(offSet * 9, offSet * 4, offSet * 9, offSet * 8);
    // 26
    g.drawLine(offSet * 10, offSet * 5, offSet * 10, offSet * 6);
    // 27
    g.drawLine(offSet * 10, offSet * 5, offSet * 13, offSet * 5);
    // 28
    g.drawLine(0, offSet * 7, offSet, offSet * 7);
    // 29
    g.drawLine(offSet, offSet * 6, offSet, offSet * 7);
    // 30
    g.drawLine(offSet * 2, offSet * 5, offSet * 2, offSet * 9);
    // 31
    g.drawLine(offSet, offSet * 8, offSet * 5, offSet * 8);
    // 32
    g.drawLine(offSet * 3, offSet * 6, offSet * 4, offSet * 6);
    // 33
    g.drawLine(offSet * 3, offSet * 6, offSet * 3, offSet * 7);
    // 34
    g.drawLine(offSet * 3, offSet * 7, offSet * 6, offSet * 7);
    // 35
    g.drawLine(offSet * 5, offSet * 5, offSet * 5, offSet * 7);
    // 36
    g.drawLine(offSet * 6, offSet * 7, offSet * 6, offSet * 9);
    // 37
    g.drawLine(offSet * 6, offSet * 6, offSet * 7, offSet * 6);
    // 38
    g.drawLine(offSet * 7, offSet * 6, offSet * 7, offSet * 10);
    // 39
    g.drawLine(offSet * 7, offSet * 8, offSet * 9, offSet * 8);
    // 40
    g.drawLine(offSet * 10, offSet * 7, offSet * 10, offSet * 8);
    // 41
    g.drawLine(offSet * 10, offSet * 7, offSet * 12, offSet * 7);
    // 42
    g.drawLine(offSet * 10, offSet * 6, offSet * 12, offSet * 6);
    // 43
    g.drawLine(offSet * 12, offSet * 6, offSet * 12, offSet * 7);
    // 44
    g.drawLine(offSet, offSet * 9, offSet, offSet * 10);
    // 45
    g.drawLine(0, offSet * 10, offSet * 3, offSet * 10);
    // 46
    g.drawLine(offSet * 3, offSet * 9, offSet * 3, offSet * 10);
    // 47
    g.drawLine(offSet * 4, offSet * 8, offSet * 4, offSet * 12);
    // 48
    g.drawLine(offSet * 5, offSet * 9, offSet * 5, offSet * 10);
    // 49
    g.drawLine(offSet * 5, offSet * 9, offSet * 6, offSet * 9);
    // 50
    g.drawLine(offSet * 4, offSet * 10, offSet * 8, offSet * 10);
    // 51
    g.drawLine(offSet * 7, offSet * 9, offSet * 10, offSet * 9);
    // 52
    g.drawLine(offSet * 10, offSet * 9, offSet * 10, offSet * 11);
    // 53
    g.drawLine(offSet * 11, offSet * 8, offSet * 13, offSet * 8);
    // 54
    g.drawLine(offSet * 11, offSet * 9, offSet * 13, offSet * 9);
    // 55
    g.drawLine(offSet * 11, offSet * 9, offSet * 11, offSet * 10);
    // 56
    g.drawLine(offSet, offSet * 11, offSet, offSet * 12);
    // 57
    g.drawLine(offSet, offSet * 11, offSet * 4, offSet * 11);
    // 58
    g.drawLine(offSet * 3, offSet * 11, offSet * 3, offSet * 12);
    // 59
    g.drawLine(offSet * 4, offSet * 12, offSet * 6, offSet * 12);
    // 60
    g.drawLine(offSet * 5, offSet * 11, offSet * 7, offSet * 11);
    // 61
    g.drawLine(offSet * 8, offSet * 10, offSet * 8, offSet * 11);
    // 62
    g.drawLine(offSet * 9, offSet * 10, offSet * 9, offSet * 12);
    // 63
    g.drawLine(offSet * 10, offSet * 11, offSet * 11, offSet * 11);
    // 64
    g.drawLine(offSet * 11, offSet * 10, offSet * 12, offSet * 10);
    // 65
    g.drawLine(offSet * 12, offSet * 10, offSet * 12, offSet * 12);
    // 66
    g.drawLine(offSet * 2, offSet * 12, offSet * 2, offSet * 13);
    // 67
    g.drawLine(offSet * 7, offSet * 11, offSet * 7, offSet * 13);
    // 68
    g.drawLine(offSet * 7, offSet * 12, offSet * 9, offSet * 12);
    // 69
    g.drawLine(offSet * 10, offSet * 12, offSet * 10, offSet * 13);
    // 70
    g.drawLine(offSet * 11, offSet * 12, offSet * 12, offSet * 12);
  }

  /**
   * 初始化迷宫2的坐标
   */
  public static void initMaze2Point() {
    // 1
    maze2Points.add(new int[]{0, offSet * 2, offSet * 2, offSet * 2});
    // 2
    maze2Points.add(new int[]{offSet, offSet, offSet * 3, offSet});
    // 3
    maze2Points.add(new int[]{offSet * 3, offSet, offSet * 3, offSet * 3});
    // 4
    maze2Points.add(new int[]{offSet * 4, 0, offSet * 4, offSet * 2});
    // 5
    maze2Points.add(new int[]{0, offSet * 3, offSet * 5, offSet * 3});
    // 6
    maze2Points.add(new int[]{offSet * 5, offSet, offSet * 5, offSet * 3});
    // 7
    maze2Points.add(new int[]{offSet * 6, 0, offSet * 6, offSet});
    // 8
    maze2Points.add(new int[]{offSet * 6, offSet * 2, offSet * 6, offSet * 6});
    // 9
    maze2Points.add(new int[]{offSet * 6, offSet * 2, offSet * 9, offSet * 2});
    // 10
    maze2Points.add(new int[]{offSet * 7, offSet, offSet * 9, offSet});
    // 11
    maze2Points.add(new int[]{offSet * 9, offSet, offSet * 9, offSet * 2});
    // 12
    maze2Points.add(new int[]{offSet * 10, 0, offSet * 10, offSet * 3});
    // 13
    maze2Points.add(new int[]{offSet * 11, offSet, offSet * 11, offSet * 4});
    // 14
    maze2Points.add(new int[]{offSet * 11, offSet, offSet * 12, offSet});
    // 15
    maze2Points.add(new int[]{offSet * 12, offSet, offSet * 12, offSet * 4});
    // 16
    maze2Points.add(new int[]{offSet * 12, offSet * 4, offSet * 13, offSet * 4});
    // 17
    maze2Points.add(new int[]{offSet, offSet * 4, offSet * 6, offSet * 4});
    // 18
    maze2Points.add(new int[]{offSet * 7, offSet * 3, offSet * 7, offSet * 5});
    // 19
    maze2Points.add(new int[]{offSet * 7, offSet * 3, offSet * 10, offSet * 3});
    // 20
    maze2Points.add(new int[]{offSet * 8, offSet * 4, offSet * 11, offSet * 4});
    // 21
    maze2Points.add(new int[]{offSet, offSet * 5, offSet * 2, offSet * 5});
    // 22
    maze2Points.add(new int[]{offSet * 3, offSet * 5, offSet * 5, offSet * 5});
    // 23
    maze2Points.add(new int[]{offSet * 7, offSet * 5, offSet * 8, offSet * 5});
    // 24
    maze2Points.add(new int[]{offSet * 8, offSet * 5, offSet * 8, offSet * 7});
    // 25
    maze2Points.add(new int[]{offSet * 9, offSet * 4, offSet * 9, offSet * 8});
    // 26
    maze2Points.add(new int[]{offSet * 10, offSet * 5, offSet * 10, offSet * 6});
    // 27
    maze2Points.add(new int[]{offSet * 10, offSet * 5, offSet * 13, offSet * 5});
    // 28
    maze2Points.add(new int[]{0, offSet * 7, offSet, offSet * 7});
    // 29
    maze2Points.add(new int[]{offSet, offSet * 6, offSet, offSet * 7});
    // 30
    maze2Points.add(new int[]{offSet * 2, offSet * 5, offSet * 2, offSet * 9});
    // 31
    maze2Points.add(new int[]{offSet, offSet * 8, offSet * 5, offSet * 8});
    // 32
    maze2Points.add(new int[]{offSet * 3, offSet * 6, offSet * 4, offSet * 6});
    // 33
    maze2Points.add(new int[]{offSet * 3, offSet * 6, offSet * 3, offSet * 7});
    // 34
    maze2Points.add(new int[]{offSet * 3, offSet * 7, offSet * 6, offSet * 7});
    // 35
    maze2Points.add(new int[]{offSet * 5, offSet * 5, offSet * 5, offSet * 7});
    // 36
    maze2Points.add(new int[]{offSet * 6, offSet * 7, offSet * 6, offSet * 9});
    // 37
    maze2Points.add(new int[]{offSet * 6, offSet * 6, offSet * 7, offSet * 6});
    // 38
    maze2Points.add(new int[]{offSet * 7, offSet * 6, offSet * 7, offSet * 10});
    // 39
    maze2Points.add(new int[]{offSet * 7, offSet * 8, offSet * 9, offSet * 8});
    // 40
    maze2Points.add(new int[]{offSet * 10, offSet * 7, offSet * 10, offSet * 8});
    // 41
    maze2Points.add(new int[]{offSet * 10, offSet * 7, offSet * 12, offSet * 7});
    // 42
    maze2Points.add(new int[]{offSet * 10, offSet * 6, offSet * 12, offSet * 6});
    // 43
    maze2Points.add(new int[]{offSet * 12, offSet * 6, offSet * 12, offSet * 7});
    // 44
    maze2Points.add(new int[]{offSet, offSet * 9, offSet, offSet * 10});
    // 45
    maze2Points.add(new int[]{0, offSet * 10, offSet * 3, offSet * 10});
    // 46
    maze2Points.add(new int[]{offSet * 3, offSet * 9, offSet * 3, offSet * 10});
    // 47
    maze2Points.add(new int[]{offSet * 4, offSet * 8, offSet * 4, offSet * 12});
    // 48
    maze2Points.add(new int[]{offSet * 5, offSet * 9, offSet * 5, offSet * 10});
    // 49
    maze2Points.add(new int[]{offSet * 5, offSet * 9, offSet * 6, offSet * 9});
    // 50
    maze2Points.add(new int[]{offSet * 4, offSet * 10, offSet * 8, offSet * 10});
    // 51
    maze2Points.add(new int[]{offSet * 7, offSet * 9, offSet * 10, offSet * 9});
    // 52
    maze2Points.add(new int[]{offSet * 10, offSet * 9, offSet * 10, offSet * 11});
    // 53
    maze2Points.add(new int[]{offSet * 11, offSet * 8, offSet * 13, offSet * 8});
    // 54
    maze2Points.add(new int[]{offSet * 11, offSet * 9, offSet * 13, offSet * 9});
    // 55
    maze2Points.add(new int[]{offSet * 11, offSet * 9, offSet * 11, offSet * 10});
    // 56
    maze2Points.add(new int[]{offSet, offSet * 11, offSet, offSet * 12});
    // 57
    maze2Points.add(new int[]{offSet, offSet * 11, offSet * 4, offSet * 11});
    // 58
    maze2Points.add(new int[]{offSet * 3, offSet * 11, offSet * 3, offSet * 12});
    // 59
    maze2Points.add(new int[]{offSet * 4, offSet * 12, offSet * 6, offSet * 12});
    // 60
    maze2Points.add(new int[]{offSet * 5, offSet * 11, offSet * 7, offSet * 11});
    // 61
    maze2Points.add(new int[]{offSet * 8, offSet * 10, offSet * 8, offSet * 11});
    // 62
    maze2Points.add(new int[]{offSet * 9, offSet * 10, offSet * 9, offSet * 12});
    // 63
    maze2Points.add(new int[]{offSet * 10, offSet * 11, offSet * 11, offSet * 11});
    // 64
    maze2Points.add(new int[]{offSet * 11, offSet * 10, offSet * 12, offSet * 10});
    // 65
    maze2Points.add(new int[]{offSet * 12, offSet * 10, offSet * 12, offSet * 12});
    // 66
    maze2Points.add(new int[]{offSet * 2, offSet * 12, offSet * 2, offSet * 13});
    // 67
    maze2Points.add(new int[]{offSet * 7, offSet * 11, offSet * 7, offSet * 13});
    // 68
    maze2Points.add(new int[]{offSet * 7, offSet * 12, offSet * 9, offSet * 12});
    // 69
    maze2Points.add(new int[]{offSet * 10, offSet * 12, offSet * 10, offSet * 13});
    // 70
    maze2Points.add(new int[]{offSet * 11, offSet * 12, offSet * 12, offSet * 12});
  }

  public static Map<Integer, List<int[]>> getMazeMaps() {
    return mazeMaps;
  }
}
