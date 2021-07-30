package prj.manager;

import static java.util.Objects.isNull;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import prj.enumerate.SoundTypeEnum;

/**
 * 此类兼容本地调试及打为jar包后使用
 *
 * @author：wangXinYu
 * @date：2021/7/29 1:27 下午
 */
public class SoundManager {

  private static volatile Clip clip;

  private static AudioInputStream ais;

  /**
   * 播放
   */
  public static void playClip(SoundTypeEnum soundType) {
    try {
      clip = AudioSystem.getClip();

      InputStream is = SoundManager.class.getResourceAsStream(File.separator + soundType.getValue());
      if (isNull(is)) {
        is = SoundManager.class.getClassLoader().getResourceAsStream(soundType.getValue());
      }
      if (is != null) {
        //获取输入流
        ais = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
      }
      clip.open(ais);
      // 从音频的6000毫秒后开始播放
      clip.setMicrosecondPosition(6000);

      //开始播放
      clip.start();

    } catch (Exception e) {
      System.out.println("SoundManager.playClip error. ｜" + e.getMessage() + "｜" + File.separator + soundType.getValue());
      e.printStackTrace();
    }
  }

  /**
   * 停止播放
   */
  public static void stopClip() {
    clip.stop();
  }
}
