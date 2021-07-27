package prj.enumerate;

/**
 * 方向
 * @author：wangXinYu
 * @date：2021/7/21 9:07 下午
 */
public enum DirectionEnum {
  /**
   * 方向
   */
  LEFT(0, "LEFT", 1),
  RIGHT(1, "RIGHT", 380),
  UP(2, "UP", 15),
  DOWN(3, "DOWN", 390),

  ;

  private int code;
  private String direction;
  // 边界最大值
  private int max;

  DirectionEnum(int code, String direction, int max) {
    this.code = code;
    this.direction = direction;
    this.max = max;
  }

  public int getCode() {
    return code;
  }

  public String getDirection() {
    return direction;
  }

  public int getMax() {
    return max;
  }
}
