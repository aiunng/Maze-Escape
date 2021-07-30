package prj.manager;

import static prj.enumerate.DirectionEnum.DOWN;
import static prj.enumerate.DirectionEnum.LEFT;
import static prj.enumerate.DirectionEnum.RIGHT;
import static prj.enumerate.DirectionEnum.UP;
import static prj.manager.KeyboardManager.getDirection;
import static prj.manager.MazeManager.getMazeMaps;
import static prj.manager.SoundManager.playClip;
import static prj.model.EscapeJPanel.getxPoint;
import static prj.model.EscapeJPanel.getyPoint;
import static prj.model.EscapeJPanel.setxPoint;
import static prj.model.EscapeJPanel.setyPoint;
import static prj.util.CollisionCheckUtil.checkCollision4Lines;
import static prj.util.Constant.MAZE1_SUCCESS_LINE;
import static prj.util.ExecutorUtil.getExecutorPool;

import java.util.Collections;
import java.util.concurrent.TimeUnit;
import prj.enumerate.DirectionEnum;
import prj.enumerate.GameStatusEnum;
import prj.enumerate.SoundTypeEnum;
import prj.model.PointMode;

/**
 * 移动控制
 *
 * @author：wangXinYu
 * @date：2021/7/21 6:17 下午
 */
public class MoveCtrlManager {
  /**
   * 获取当前的方向
   */
  private static volatile DirectionEnum[] old = {getDirection()};

  /**
   * 移动方法
   */
  public static void moveing() {
    PointMode pointMode = new PointMode();
    // 更新当前方向
    getExecutorPool().execute(() -> {
      while (true) {
        if (old[0].getCode() != getDirection().getCode()) {
          old[0] = getDirection();
        }
      }
    });

    // 移动
    getExecutorPool().execute(() -> {
      // 当前位置大于等于边界值，停止
      while (getStop(old[0])) {

        //当前位置
        int ypoint = getyPoint();
        int xpoint = getxPoint();

        // 状态为开始
        if (GameStatusEnum.START.getCode() == SysOptions.getStatus()) {
          // 等级控制
          try {
            TimeUnit.MICROSECONDS.sleep(SysOptions.getLevel().getTime());
          } catch (InterruptedException e) {
          }
          // 移动控制
          if (LEFT.equals(old[0])) {
            xpoint = left(xpoint);
            setxPoint(xpoint);
          } else if (RIGHT.equals(old[0])) {
            xpoint = right(xpoint);
            setxPoint(xpoint);
          } else if (UP.equals(old[0])) {
            ypoint = up(ypoint);
            setyPoint(ypoint);
          } else if (DOWN.equals(old[0])) {
            ypoint = down(ypoint);
            setyPoint(ypoint);
          }

          // 碰撞检测
          pointMode.setxPoint(getxPoint());
          pointMode.setyPoint(getyPoint());
          if (checkCollision4Lines(getMazeMaps().get(SysOptions.getCurrentMaze()), pointMode)) {
            playClip(SoundTypeEnum.FAIL);
            SysOptions.setStatus(GameStatusEnum.OVER.getCode());
          }

          // 边界检测
          if (!getStop(old[0])) {
            playClip(SoundTypeEnum.FAIL);
            SysOptions.setStatus(GameStatusEnum.OVER.getCode());
          }

          // 通关检测
          if (checkCollision4Lines(Collections.singletonList(MAZE1_SUCCESS_LINE), pointMode)) {
            playClip(SoundTypeEnum.SUCCESS);
            SysOptions.setStatus(GameStatusEnum.SUCCESS.getCode());
            // 设置通关时间
            SysOptions.setFinishTime(System.currentTimeMillis() - SysOptions.getStartTime());
          }
        }
      }

    });
  }

  /**
   * 根据方向、当前位置判断是否到达边界（停止移动）
   *
   * @param direction
   * @return
   */
  private static boolean getStop(DirectionEnum direction) {
    boolean stop = false;
    if (LEFT.equals(direction)) {
      stop = LEFT.getMax() <= getxPoint();
    } else if (RIGHT.equals(direction)) {
      stop = RIGHT.getMax() >= getxPoint();
    } else if (UP.equals(direction)) {
      stop = UP.getMax() <= getyPoint();
    } else if (DOWN.equals(direction)) {
      stop = DOWN.getMax() >= getyPoint();
    }
    return stop;
  }

  public static int left(int xPoint) {

    return xPoint - 1;
  }

  public static int right(int xPoint) {

    return xPoint + 1;
  }

  public static int up(int yPoint) {

    return yPoint - 1;
  }

  public static int down(int yPoint) {

    return yPoint + 1;
  }

}
