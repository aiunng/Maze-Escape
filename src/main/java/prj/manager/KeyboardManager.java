package prj.manager;

import static prj.manager.PlaySoundManager.playClip;
import static prj.util.Constant.DEFAULT_DIRECTION;

import java.awt.event.KeyEvent;
import prj.enumerate.DirectionEnum;
import prj.enumerate.GameStatusEnum;
import prj.enumerate.SoundTypeEnum;

/**
 * 设置当前方向
 *
 * @author：wangXinYu
 * @date：2021/7/22 10:26 上午
 */
public class KeyboardManager {
  // 默认方向
  private static DirectionEnum direction = DEFAULT_DIRECTION;

  /**
   * 按下某个键，设置相应的方向
   *
   * @param e
   */
  public static void addDirection(KeyEvent e) {
    switch (e.getKeyCode()) {
      // 方向键
      case KeyEvent.VK_LEFT:
        playClip(SoundTypeEnum.LEFT);
        direction = DirectionEnum.LEFT;
        break;
      case KeyEvent.VK_UP:
        playClip(SoundTypeEnum.UP);
        direction = DirectionEnum.UP;
        break;
      case KeyEvent.VK_RIGHT:
        playClip(SoundTypeEnum.RIGHT);
        direction = DirectionEnum.RIGHT;
        break;
      case KeyEvent.VK_DOWN:
        playClip(SoundTypeEnum.DOWN);
        direction = DirectionEnum.DOWN;
        break;
      case KeyEvent.VK_SPACE:
        playClip(SoundTypeEnum.BUTTON);
        // 空格键 暂停<->开始
        if (SysOptions.getStatus() == GameStatusEnum.START.getCode()) {
          SysOptions.setStatus(GameStatusEnum.PAUSE.getCode());
        } else if (SysOptions.getStatus() == GameStatusEnum.PAUSE.getCode()) {
          SysOptions.setStatus(GameStatusEnum.START.getCode());
        } else if (SysOptions.getStatus() == GameStatusEnum.STOP.getCode()) {
          SysOptions.setStatus(GameStatusEnum.START.getCode());
        }
        break;
      default:
        break;
    }
  }

  public static DirectionEnum getDirection() {
    return direction;
  }

  public static void setDirection(DirectionEnum direction) {
    KeyboardManager.direction = direction;
  }
}
