package prj.model;

import static prj.manager.MazeManager.paintMaze;
import static prj.util.Constant.BIG_BOLD;
import static prj.util.Constant.CROWN_ICON;
import static prj.util.Constant.DEFAULT_XPOINT;
import static prj.util.Constant.DEFAULT_YPOINT;
import static prj.util.Constant.LEVE_1;
import static prj.util.Constant.PLAYER_ICON;
import static prj.util.Constant.TEXT_SMALL;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;
import javax.swing.JPanel;
import prj.enumerate.DirectionEnum;
import prj.enumerate.GameStatusEnum;
import prj.manager.SysOptions;

/**
 * @author：wangXinYu
 * @date：2021/7/21 5:27 下午
 */
public class EscapeJPanel extends JPanel {

  // 初始坐标
  public static int xPoint = DEFAULT_XPOINT;
  public static int yPoint = DEFAULT_YPOINT;
  private int xOffset = 30;

  private static Random rand = new Random();

  public static int getxPoint() {
    return xPoint;
  }

  public static void setxPoint(int xPoint) {
    EscapeJPanel.xPoint = xPoint;
  }

  public static int getyPoint() {
    return yPoint;
  }

  public static void setyPoint(int yPoint) {
    EscapeJPanel.yPoint = yPoint;
  }

  /**
   * 获取x轴随机点
   *
   * @return
   */
  public static int getXRand() {
    return rand.nextInt((DirectionEnum.RIGHT.getMax() - DirectionEnum.LEFT.getMax()) + 1) + DirectionEnum.LEFT.getMax();
  }

  /**
   * 获取y轴随机点
   *
   * @return
   */
  public static int getYRand() {
    return rand.nextInt((DirectionEnum.DOWN.getMax() - DirectionEnum.UP.getMax()) + 1) + DirectionEnum.UP.getMax();
  }

  @Override
  public void paint(Graphics g) {

    if (GameStatusEnum.START.getCode() == SysOptions.getStatus()) {
      g.setFont(LEVE_1);
      g.setColor(Color.black);
      g.drawString(PLAYER_ICON, xPoint, yPoint);
      paintWall(g);
    }
    if (GameStatusEnum.STOP.getCode() == SysOptions.getStatus()) {
      g.setFont(LEVE_1);
      g.setColor(Color.black);
      g.drawString(GameStatusEnum.STOP.getDesc(), 150, 280);

      g.setFont(TEXT_SMALL);
      g.drawString("push start or space bar to start the game", 75, 300);
      printBkg(g, xOffset);
    }
    if (GameStatusEnum.OVER.getCode() == SysOptions.getStatus()) {
      g.setFont(LEVE_1);
      g.setColor(Color.gray);
      g.drawString(GameStatusEnum.OVER.getDesc(), 115, 280);
      printBkg(g, xOffset);
    }
    if (GameStatusEnum.PAUSE.getCode() == SysOptions.getStatus()) {
      g.setFont(LEVE_1);
      g.setColor(Color.gray);
      g.drawString(PLAYER_ICON, xPoint, yPoint);
      paintWall(g);
      g.setFont(LEVE_1);
      g.drawString(GameStatusEnum.PAUSE.getDesc(), 150, 280);
    }

    if (GameStatusEnum.SUCCESS.getCode() == SysOptions.getStatus()) {
      printSuccesBkg(g);
      g.setColor(Color.black);
      g.setFont(BIG_BOLD);
      g.drawString(CROWN_ICON, 180, 250);
      g.setFont(LEVE_1);
      g.drawString(GameStatusEnum.SUCCESS.getEn(), 140, 280);
      g.drawString(GameStatusEnum.SUCCESS.getDesc(), 80, 310);
    }

    this.updateUI();
  }

  /**
   * 画背景
   *
   * @param g
   * @param xOffset
   */
  private void printBkg(Graphics g, int xOffset) {
    for (int i = 0; i < 100; i++) {
      g.drawLine(xOffset * i, getYRand(), xOffset * i, getYRand());
      g.drawLine(getXRand(), xOffset * i, getXRand(), xOffset * i);
    }
  }

  private void printSuccesBkg(Graphics g) {
    for (int i = 0; i < 20; i++) {
      // 设置线宽
      Graphics2D g2d = (Graphics2D) g;
      BasicStroke basicStroke = new BasicStroke(2.0f);
      g2d.setStroke(basicStroke);
      g.setColor(Color.lightGray);
      paintWall(g);
    }
  }

  /**
   * 画迷宫墙
   *
   * @param g
   */
  private void paintWall(Graphics g) {
    g.setFont(LEVE_1);
    paintMaze(g);
  }

}
