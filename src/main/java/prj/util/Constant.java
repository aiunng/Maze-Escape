package prj.util;

import java.awt.Font;
import prj.enumerate.DirectionEnum;

/**
 * @author：wangXinYu
 * @date：2021/7/16 5:00 下午
 */
public class Constant {

  public static final String GAME_NAME = "Maze-Escape";
  public static final DirectionEnum DEFAULT_DIRECTION = DirectionEnum.RIGHT;
  public static final String PLAYER_ICON = "☻";
  public static final String START_ICON = "➡︎";
  public static final String CROWN_ICON = "♛";
  public static final int MAZE1_SUCCESS_POINTX = 368;
  public static final int MAZE1_SUCCESS_POINTY = 140;
  public static final int[] MAZE1_SUCCESS_LINE = new int[]{30 * 12, 30 * 4 + 20, 30 * 13, 30 * 4 + 20};

  //字体
  public static final Font BIG_BOLD = new Font("宋体", Font.BOLD, 50);
  public static final Font LEVE_1 = new Font("宋体", Font.BOLD, 25);
  public static final Font LEVE_2 = new Font("宋体", Font.BOLD, 20);
  public static final Font LEVE_3 = new Font("宋体", Font.BOLD, 15);
  //正文加粗
  public static final Font TEXT_BOLD = new Font("宋体", Font.BOLD, 10);
  //正文普通
  public static final Font TEXT_NORMAL = new Font("宋体", Font.PLAIN, 15);
  //正文小字号
  public static final Font TEXT_SMALL = new Font("宋体", Font.PLAIN, 12);

  /**
   * 关于信息
   */
  public static final String ICON_URL = "https://cdn.nlark.com/yuque/0/2021/png/379666/1627383439100-8c568e4a-ee36-4f10-ab1c-05ae4cba5d3a.png";
  public static final String VERSION = "版本2021.07.27 (1.0.1)";
  public static final String ADVER = "Maze-Escape make you happy life.";
  public static final String BLOG_LINK = "https://www.yuque.com/aiunng/elrg1e/gegs4r";
  public static final String BLOG_TEXT = "<html><a href='" + BLOG_LINK + "'>使用帮助、提出建议、问题反馈</a></html>";
  public static final String AUTHOR = "author：w*Yu";
}
