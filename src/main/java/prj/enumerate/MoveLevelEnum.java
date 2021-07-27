package prj.enumerate;

/**
 * 等级
 *
 * @author：wangXinYu
 * @date：2021/7/21 6:10 下午
 */
public enum MoveLevelEnum {
  /**
   * 等级
   */
  L1(1, 0, 25000L, "Easy"),
  L2(2, 20, 20000L, "Normal"),
  L3(3, 50, 15000L, "Diffic"),
  L4(4, 80, 10000L, "Hell"),
  L5(5, 100, 7000L, "Ashes"),

  ;

  private int code;

  // 分数
  private int score;
  // 毫秒
  private long time;

  private String desc;

  MoveLevelEnum(int code, int score, long time, String desc) {
    this.code = code;
    this.score = score;
    this.time = time;
    this.desc = desc;
  }

  public int getCode() {
    return code;
  }

  public int getScore() {
    return score;
  }

  public long getTime() {
    return time;
  }

  public String getDesc() {
    return desc;
  }

  /**
   * 根据分数获取当前等级
   *
   * @param score
   * @return
   */
  public static MoveLevelEnum getByScore(int score) {
    if (score < L2.score) {
      return L1;
    } else if (score < L3.score) {
      return L2;
    } else if (score < L4.score) {
      return L3;
    } else if (score < L5.score) {
      return L4;
    } else if (score >= L5.score) {
      return L5;
    } else {
      return L1;
    }
  }

  public static MoveLevelEnum getMoveLevelEnumByDesc(String desc) {
    for (MoveLevelEnum value : MoveLevelEnum.values()) {

      if (desc.equals(value.getDesc())) {
        return value;
      }
    }
    return null;
  }
}
