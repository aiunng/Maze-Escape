package prj.enumerate;

/**
 * 音效类型
 *
 * @author：wangXinYu
 * @date：2021/7/29 2:56 下午
 */
public enum SoundTypeEnum {
  /**
   *
   */
  BGM(0, "sound/bgm.wav"),
  BUTTON(1, "sound/goblins/button.wav"),
  SUCCESS(2, "sound/goblins/success.wav"),
  FAIL(3, "sound/goblins/fail.wav"),
  LEFT(4, "sound/goblins/left.wav"),
  RIGHT(5, "sound/goblins/right.wav"),
  UP(6, "sound/goblins/up.wav"),
  DOWN(7, "sound/goblins/down.wav"),
  ASSAULT(8, "sound/goblins/assault.wav"),
  ;

  private int code;
  private String value;

  SoundTypeEnum(int code, String value) {
    this.code = code;
    this.value = value;
  }

  public int getCode() {
    return code;
  }

  public String getValue() {
    return value;
  }
}
