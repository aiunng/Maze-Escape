package prj.manager;

import static prj.manager.MazeManager.getMazeMaps;
import static prj.model.EscapeJPanel.rand;
import static prj.util.ExecutorUtil.getExecutorPool;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import prj.enumerate.GameStatusEnum;
import prj.enumerate.MazeTypeEnum;
import prj.enumerate.MoveLevelEnum;

/**
 * 系统运行参数
 *
 * @author：wangXinYu
 * @date：2021/7/21 8:05 下午
 */
public class SysOptions {
  /**
   * 状态
   */
  public static volatile int status = GameStatusEnum.STOP.getCode();
  /**
   * 分数 暂时未用到
   */
  public static int score = 0;
  /**
   * 等级 移动速度
   */
  public static volatile MoveLevelEnum level = MoveLevelEnum.L1;
  /**
   * 生命值 暂时未用到
   */
  public static volatile AtomicInteger life = new AtomicInteger(3);
  /**
   * 开始时间
   */
  public static volatile long startTime;
  /**
   * 完成时间
   */
  public static volatile long finishTime;
  /**
   * 当前迷宫
   */
  public static volatile Integer currentMaze;
  /**
   * 迷宫总数 用于顺序获取迷宫图
   */
  private static int mazeSize = getMazeMaps().size();
  /**
   * 当前迷宫下标 用于顺序获取迷宫图
   */
  private static int currentMazeIndex = 0;
  /**
   * 每次移动距离， 默认1-正常速度、10-突击
   */
  public static volatile int moveDistance = 1;
  /**
   * 每张地图的起始点坐标
   */
  public static volatile Map<Integer, int[]> initPoints = new ConcurrentHashMap<>();
  /**
   * 每张地图的结束点坐标
   */
  public static volatile Map<Integer, int[]> endPoints = new ConcurrentHashMap<>();

  static {

    initPoints.put(1, MazeTypeEnum.MAZE_1.getStartPoint());
    initPoints.put(2, MazeTypeEnum.MAZE_2.getStartPoint());

    endPoints.put(1, MazeTypeEnum.MAZE_1.getEndPoint());
    endPoints.put(2, MazeTypeEnum.MAZE_2.getEndPoint());

    // 突击的时间
    getExecutorPool().execute(() -> {
      while (true) {
        // 每次突击60毫秒
        if (10 == moveDistance) {
          try {
            TimeUnit.MILLISECONDS.sleep(60L);
          } catch (InterruptedException interruptedException) {
          }
          moveDistance = 1;
        }
      }
    });
  }

  public static int getStatus() {
    return status;
  }

  public static void setStatus(int status) {
    SysOptions.status = status;
  }

  public static int getScore() {
    return score;
  }

  public static void addScore() {
    SysOptions.score = SysOptions.score + 1;
  }

  public static void setScore(int score) {
    SysOptions.score = score;
  }

  public static MoveLevelEnum getLevel() {
    return level;
  }

  public static void setLevel(MoveLevelEnum level) {
    SysOptions.level = level;
  }

  public static AtomicInteger getLife() {
    return life;
  }

  public static void setLife(AtomicInteger life) {
    SysOptions.life = life;
  }

  public static long getFinishTime() {
    return finishTime;
  }

  public static void setFinishTime(long finishTime) {
    SysOptions.finishTime = finishTime;
  }

  public static long getStartTime() {
    return startTime;
  }

  public static void setStartTime(long startTime) {
    SysOptions.startTime = startTime;
  }

  public static Integer getCurrentMaze() {
    return currentMaze;
  }

  public static void setCurrentMaze(Integer currentMaze) {
    SysOptions.currentMaze = currentMaze;
  }

  public static void setMoveDistance(int moveDistance) {
    SysOptions.moveDistance = moveDistance;
  }

  /**
   * 获取随机地图 ((max-min)+min)+min
   *
   * @return
   */
  public static Integer getRandMaze() {
    return rand.nextInt((2 - 1) + 1) + 1;
  }

  /**
   * 顺序获取迷宫图
   *
   * @return
   */
  public static Integer getNextMaze() {
    if (currentMazeIndex == mazeSize) {
      currentMazeIndex = 0;
    }
    currentMazeIndex = currentMazeIndex + 1;
    return currentMazeIndex;
  }
}
