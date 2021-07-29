package prj.manager;

import static prj.manager.SoundManager.playClipNew;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import prj.enumerate.SoundTypeEnum;

/**
 * @author：wangXinYu
 * @date：2021/7/29 8:31 下午
 */
public class PlaySoundManager {

  private File file;
  private AudioInputStream stream;
  private AudioFormat format;
  private DataLine.Info info;
  private Clip clip;

  void open(String s) throws UnsupportedAudioFileException, IOException {
    file = new File(s);
    stream = AudioSystem.getAudioInputStream(file);
    format = stream.getFormat();
  }


  void play() throws LineUnavailableException, IOException {
    info = new DataLine.Info(Clip.class, format);
    clip = (Clip) AudioSystem.getLine(info);
    clip.open(stream);
  }


  void stop() {
    clip.stop();
  }


  void start() {
    clip.setMicrosecondPosition(6000);
    clip.start();
  }


  void loop() {
    clip.loop(20);
  }

  public static void playClip(SoundTypeEnum soundType) {
    try {
      PlaySoundManager p = new PlaySoundManager();
      p.open(soundType.getValue());
      p.play();
      p.start();
    } catch (Exception e) {
      try {
        playClipNew(soundType);
      } catch (Exception e2) {
      }
    }
  }
}
