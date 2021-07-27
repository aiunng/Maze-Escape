package prj.util;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import prj.enumerate.MoveLevelEnum;

/**
 * @author：wangXinYu
 * @date：2021/7/21 6:49 下午
 */
public class SwingUtil {

  public static JButton addJButton(String text, Font font, int x, int y, int width, int height, JPanel contentPanel) {
    JButton button = new JButton(text);
    button.setFont(font);
    button.setBounds(x, y, width, height);
    contentPanel.add(button);
    return button;
  }

  public static JComboBox addLevelComboBox(Font font, int x, int y, int width, int height, JPanel contentPanel) {
    // 创建下拉框
    JComboBox comboBox = new JComboBox();

    // 绑定下拉框选项
    for (MoveLevelEnum value : MoveLevelEnum.values()) {
      comboBox.addItem(value.getDesc());
    }

    comboBox.setFont(font);
    comboBox.setBounds(x, y, width, height);
    comboBox.setSelectedIndex(0);
    contentPanel.add(comboBox);

    return comboBox;
  }
}
