package prj.model;

/**
 * @author：wangXinYu
 * @date：2021/7/24 2:15 下午
 */
public class PointMode {

  private int xPoint;
  private int yPoint;

  public PointMode() {
  }

  public PointMode(int xPoint, int yPoint) {
    this.xPoint = xPoint;
    this.yPoint = yPoint;
  }

  public int getxPoint() {
    return xPoint;
  }

  public void setxPoint(int xPoint) {
    this.xPoint = xPoint;
  }

  public int getyPoint() {
    return yPoint;
  }

  public void setyPoint(int yPoint) {
    this.yPoint = yPoint;
  }

  @Override
  public String toString() {
    return "PointMode{" +
        "xPoint=" + xPoint +
        ", yPoint=" + yPoint +
        '}';
  }
}
