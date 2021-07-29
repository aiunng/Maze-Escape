package prj.enumerate;

/**
 * 状态
 *
 * @author：wangXinYu
 * @date：2021/7/21 6:13 下午
 */
public enum GameStatusEnum {
  /**
   * 状态
   */
  STOP(0, "READY","STOP"),
  START(1, "开始","START"),
  RUN(2, "运行","RUN"),
  PAUSE(3, "PAUSE","PAUSE"),
  OVER(4, "GAME OVER","OVER"),
  SUCCESS(5, "FINISH TIME:","SUCCESS"),
  ;
  private int code;
  private String desc;
  private String en;

  GameStatusEnum(int code, String desc, String en) {
    this.code = code;
    this.desc = desc;
    this.en = en;
  }

  public int getCode() {
    return code;
  }

  public String getDesc() {
    return desc;
  }

  public String getEn() {
    return en;
  }
}
