package prj.manager;

import static prj.enumerate.GameStatusEnum.PAUSE;
import static prj.enumerate.GameStatusEnum.START;
import static prj.enumerate.MoveLevelEnum.getMoveLevelEnumByDesc;
import static prj.manager.KeyboardManager.setDirection;
import static prj.manager.MoveCtrlManager.moveing;
import static prj.manager.PlaySoundManager.playClip;
import static prj.model.EscapeJPanel.setxPoint;
import static prj.model.EscapeJPanel.setyPoint;
import static prj.util.Constant.ADVER;
import static prj.util.Constant.AUTHOR;
import static prj.util.Constant.BLOG_LINK;
import static prj.util.Constant.BLOG_TEXT;
import static prj.util.Constant.DEFAULT_DIRECTION;
import static prj.util.Constant.DEFAULT_XPOINT;
import static prj.util.Constant.DEFAULT_YPOINT;
import static prj.util.Constant.GAME_NAME;
import static prj.util.Constant.ICON_URL;
import static prj.util.Constant.TEXT_BOLD;
import static prj.util.Constant.TEXT_NORMAL;
import static prj.util.Constant.VERSION;
import static prj.util.SwingUtil.addJButton;
import static prj.util.SwingUtil.addLevelComboBox;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import prj.enumerate.GameStatusEnum;
import prj.enumerate.MoveLevelEnum;
import prj.enumerate.SoundTypeEnum;
import prj.model.EscapeJPanel;

/**
 * @author：wangXinYu
 * @date：2021/7/18 10:34 上午
 */
public class SwingManager {

  public static void start() {
    JFrame frame = new JFrame(GAME_NAME);
    frame.setBounds(500, 220, 430, 530);
    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());
    frame.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
    frame.setVisible(true);
    // 获取屏幕焦点 ，键盘监听使用
    frame.setFocusable(true);
    // 添加键盘监听
    frame.addKeyListener(new KeyMonitor());
    frame.setResizable(false);

    // 布局使用
    JPanel container = new JPanel();
    container.setBorder(BorderFactory.createLineBorder(Color.black, 20));
    container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));

    // 游戏区域
    EscapeJPanel escapePanel = new EscapeJPanel();
    // 设置JPanel的大小
    escapePanel.setPreferredSize(new Dimension(500, 500));
    escapePanel.setBorder(BorderFactory.createLineBorder(Color.black, 5, true));
    escapePanel.setLayout(null);

    // 按钮控制区域
    JPanel buttonJPanel = buttonZone(frame);

    container.add(escapePanel);
    container.add(buttonJPanel);

    contentPane.add(container);

    playClip(SoundTypeEnum.BGM);
    // 移动
    moveing();
    // 更新窗口
    escapePanel.updateUI();

  }


  private static JPanel buttonZone(JFrame frame) {
    JPanel buttonJPanel = new JPanel();
    buttonJPanel.setPreferredSize(new Dimension(500, 100));
    buttonJPanel.setBorder(BorderFactory.createLineBorder(Color.black, 40));
    buttonJPanel.setLayout(null);

    JButton startButton = addJButton(START.getEn(), TEXT_NORMAL, 30, 15, 60, 40, buttonJPanel);
    startButton.addActionListener((o) -> {
      playClip(SoundTypeEnum.BUTTON);
      // 如果状态是结束或者通关 则重新开始
      if (GameStatusEnum.OVER.getCode() == SysOptions.getStatus() ||
          GameStatusEnum.SUCCESS.getCode() == SysOptions.getStatus()) {
        // 恢复默认参数
        setxPoint(DEFAULT_XPOINT);
        setyPoint(DEFAULT_YPOINT);
        setDirection(DEFAULT_DIRECTION);
        // 重新开始
        moveing();
      }
      SysOptions.setStatus(START.getCode());
      // 初始化游戏开始时间
      SysOptions.setStartTime(System.currentTimeMillis());
      // 重新获取焦点 ，键盘监听使用
      frame.requestFocus();
    });

    JButton pauseButton = addJButton(PAUSE.getEn(), TEXT_NORMAL, 100, 15, 60, 40, buttonJPanel);
    pauseButton.addActionListener((o) -> {
      playClip(SoundTypeEnum.BUTTON);
      // 结束状态、未开始游戏状态、通关状态不能暂停
      if (GameStatusEnum.OVER.getCode() != SysOptions.getStatus() &&
          GameStatusEnum.STOP.getCode() != SysOptions.getStatus() &&
          GameStatusEnum.SUCCESS.getCode() != SysOptions.getStatus()
      ) {
        SysOptions.setStatus(PAUSE.getCode());
      }
      // 重新获取焦点 ，键盘监听使用
      frame.requestFocus();
    });

    JComboBox levelComboBox = addLevelComboBox(TEXT_NORMAL, 170, 15, 90, 40, buttonJPanel);

    levelComboBox.addActionListener((o) -> {

      playClip(SoundTypeEnum.BUTTON);

      String levelDesc = levelComboBox.getSelectedItem().toString();
      MoveLevelEnum levelEnum = getMoveLevelEnumByDesc(levelDesc);
      SysOptions.setLevel(levelEnum);
      // 重新获取焦点 ，键盘监听使用
      frame.requestFocus();
    });

    // 帮助信息
    buildHelpRegion(buttonJPanel);

    return buttonJPanel;
  }

  private static void buildHelpRegion(JPanel contentPanel) {

    JButton cfgButton = addJButton("ABOUT", TEXT_NORMAL, 270, 15, 60, 40, contentPanel);

    cfgButton.addActionListener(e -> {
      playClip(SoundTypeEnum.BUTTON);
      JDialog jDialog = new JDialog();
      jDialog.setTitle("about");
      jDialog.setBounds(580, 360, 220, 180);
      jDialog.setVisible(true);
      jDialog.setLayout(null);
      // 禁止用户调整窗口大小
      jDialog.setResizable(false);

      Container contentPane = jDialog.getContentPane();

      JLabel imgLabel = new JLabel();
      ImageIcon img = null;
      try {
        img = new ImageIcon(new URL(ICON_URL));
      } catch (MalformedURLException me) {
        me.printStackTrace();
      }
      imgLabel.setIcon(img);
      imgLabel.setBounds(85, 10, 50, 50);

      int y1 = 70;
      int offset1 = 20;

      JLabel versionLabel = new JLabel(VERSION);
      versionLabel.setBounds(55, y1, 150, 25);
      versionLabel.setFont(TEXT_BOLD);

      y1 = y1 + offset1;
      JLabel textLabel = new JLabel(ADVER);
      textLabel.setBounds(10, y1, 220, 25);
      textLabel.setFont(TEXT_BOLD);

      y1 = y1 + offset1;
      JLabel linklabel = new JLabel(BLOG_TEXT);
      // 光标类型
      linklabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
      linklabel.setBounds(35, y1, 200, 25);
      linklabel.setFont(TEXT_BOLD);

      // 鼠标监听
      linklabel.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
          try {
            //打开网址
            Desktop.getDesktop().browse(new URI(BLOG_LINK));
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      });

      y1 = y1 + offset1;
      JLabel authorLabel = new JLabel(AUTHOR);
      authorLabel.setBounds(70, y1, 100, 25);
      authorLabel.setFont(TEXT_BOLD);

      contentPane.add(imgLabel);
      contentPane.add(versionLabel);
      contentPane.add(textLabel);
      contentPane.add(linklabel);
      contentPane.add(authorLabel);
    });
  }

  public static void main(String[] args) {

  }
}
