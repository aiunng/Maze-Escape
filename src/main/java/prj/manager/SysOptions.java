package prj.manager;

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
}
