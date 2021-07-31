package prj.enumerate;

/**
 * 迷宫图地图类
 *
 * @author：wangXinYu
 * @date：2021/7/31 4:04 下午
 */
public enum MazeTypeEnum {
  /**
   * 迷宫1
   */
  MAZE_1(1, new int[]{10, 24}, new int[]{360, 140, 390, 140}),
  /**
   * 迷宫2
   */
  MAZE_2(2, new int[]{10, 84}, new int[]{375, 120, 375, 150}),
  ;
  /**
   * 迷宫图编号
   */
  private int code;
  /**
   * 起始点坐标
   */
  private int[] startPoint;
  /**
   * 结束点坐标线
   */
  private int[] endPoint;

  MazeTypeEnum(int code, int[] startPoint, int[] endPoint) {
    this.code = code;
    this.startPoint = startPoint;
    this.endPoint = endPoint;
  }

  public int getCode() {
    return code;
  }

  public int[] getStartPoint() {
    return startPoint;
  }

  public int[] getEndPoint() {
    return endPoint;
  }

  public static MazeTypeEnum getMazeTypeEnumByCode(int code) {
    for (MazeTypeEnum value : MazeTypeEnum.values()) {

      if (code == value.getCode()) {
        return value;
      }
    }
    return null;
  }
}
