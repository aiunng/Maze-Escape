package prj.manager;

import static prj.manager.KeyboardManager.addDirection;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 键盘监听
 *
 * @author：wangXinYu
 * @date：2021/7/22 10:44 上午
 */
public class KeyMonitor implements KeyListener {

  /**
   * 按下
   *
   * @param e
   */
  @Override
  public void keyPressed(KeyEvent e) {
    addDirection(e);
  }

  /**
   * 松开
   *
   * @param e
   */
  @Override
  public void keyReleased(KeyEvent e) {
  }

  /**
   * @param e
   */
  @Override
  public void keyTyped(KeyEvent e) {

  }


}
