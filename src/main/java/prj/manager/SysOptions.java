package prj.manager;

import static prj.manager.MazeManager.getMazeMaps;
import static prj.model.EscapeJPanel.rand;

import java.util.concurrent.atomic.AtomicInteger;
import prj.enumerate.GameStatusEnum;
import prj.enumerate.MoveLevelEnum;

/**
 * 系统运行参数
 *
 * @author：wangXinYu
 * @date：2021/7/21 8:05 下午
 */
public class SysOptions {
  // 状态
  public static volatile int status = GameStatusEnum.STOP.getCode();
  // 分数 暂时未用到
  public static int score = 0;
  // 等级
  public static volatile MoveLevelEnum level = MoveLevelEnum.L1;
  // 生命
  public static volatile AtomicInteger life = new AtomicInteger(3);
  // 开始时间
  public static volatile long startTime;
  // 完成时间
  public static volatile long finishTime;
  // 当前迷宫
  public static volatile Integer currentMaze;
  // 迷宫总数 用于顺序获取迷宫图
  private static int mazeSize = getMazeMaps().size();
  // 当前迷宫下标 用于顺序获取迷宫图
  private static volatile int currentMazeIndex = 0;

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
