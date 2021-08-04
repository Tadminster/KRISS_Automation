package KRISS;

import java.util.ArrayList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class Windows {
  private JFrame frmNull;

  private JMenuItem mntmNotice = new JMenuItem("Notice");
  private JMenuItem mntmInput = new JMenuItem("Input");
  private JMenuItem mntmParagraph = new JMenuItem("Paragraph");
  private JMenuItem mntmText = new JMenuItem("Text");
  private JMenuItem mntmQnA = new JMenuItem("Q&A");
  private JMenuItem mntmEtc = new JMenuItem("ETC");

  private JScrollPane scrollNotice = new JScrollPane();
  private JScrollPane scrollParagraph;

  private JScrollPane scrollAbstract = new JScrollPane();
  private JScrollPane scrollIntroduction = new JScrollPane();
  private JScrollPane scrollMainText = new JScrollPane();
  private JScrollPane scrollMethods = new JScrollPane();
  private JScrollPane scrollSummary = new JScrollPane();
  private JScrollPane scrollCaptions = new JScrollPane();

  private JButton btnAbstract = new JButton("Abstract");
  private JButton btnIntroduction = new JButton("Introduction");
  private JButton btnMainText = new JButton("Main text");
  private JButton btnMethods = new JButton("Methods");
  private JButton btnSummary = new JButton("Summary");
  private JButton btnCaptions = new JButton("Captions");

  private JButton btnAdd = new JButton("Add");
  private JButton btnRemove = new JButton("Remove");
  private JButton btnClear = new JButton("Clear");

  private JTextArea textAbstract = new JTextArea();
  private JTextArea textIntroduction = new JTextArea();
  private JTextArea textMainText = new JTextArea();
  private JTextArea textMethods = new JTextArea();
  private JTextArea textSummary = new JTextArea();
  private JTextArea textCaptions = new JTextArea();

  ArrayList<String> ArrayAlltexts = new ArrayList<>();

  private String[] ArrayAbstract;
  private String[] ArrayIntroduction;
  private String[] ArrayMainText;
  private String[] ArrayMethods;
  private String[] ArraySummary;
  private String[] ArrayCaptions;

  /**
   * Create the application.
   */
  public Windows() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    /* 프레임 */
    setFrmNull(new JFrame());
    getFrmNull().setTitle("Null");
    getFrmNull().setBounds(100, 100, 900, 670);
    getFrmNull().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getFrmNull().getContentPane().setLayout(null);

    /* 내용 */
    // 공지
    scrollNotice.setToolTipText("notice");
    scrollNotice.setBounds(12, 10, 860, 588);
    getFrmNull().getContentPane().add(scrollNotice);

    JTextArea textNotice = new JTextArea();
    scrollNotice.setViewportView(textNotice);
    textNotice.setText("\n공지를 적을 것임. 하하하");
    textNotice.setEnabled(false);

    // Paragraph

    String[] columnNames = { "index", "paragraph", "abstract", "intro", "main", "method", "summary", "caption" };
    Object[][] data = { { "1", "asd", "1", "0", "0", "0", "0", "0" }, { "2", "asf", "1", "0", "0", "0", "0", "0" },
        { "3", "asdg", "1", "0", "0", "0", "0", "0" }, };
    JTable paragraphTable = new JTable(data, columnNames);
    scrollParagraph = new JScrollPane(paragraphTable);
    scrollParagraph.setToolTipText("Paragraph");
    scrollParagraph.setBounds(12, 10, 860, 588);

    frmNull.getContentPane().add(scrollParagraph);

    // Abstract
    scrollAbstract.setToolTipText("Abstract");
    scrollAbstract.setBounds(12, 49, 760, 549);
    getFrmNull().getContentPane().add(scrollAbstract);

    textAbstract.setText("Abstractzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
    scrollAbstract.setViewportView(textAbstract);

    // Introduction
    scrollIntroduction.setToolTipText("Introduction");
    scrollIntroduction.setBounds(12, 49, 760, 549);
    getFrmNull().getContentPane().add(scrollIntroduction);

    scrollIntroduction.setViewportView(textIntroduction);

    // MainText
    scrollMainText.setToolTipText("MainText");
    scrollMainText.setBounds(12, 49, 760, 549);
    getFrmNull().getContentPane().add(scrollMainText);

    scrollMainText.setViewportView(textMainText);

    // Methods
    scrollMethods.setToolTipText("Methods");
    scrollMethods.setBounds(12, 49, 760, 549);
    getFrmNull().getContentPane().add(scrollMethods);

    scrollMethods.setViewportView(textMethods);

    // Summary
    scrollSummary.setToolTipText("Summary");
    scrollSummary.setBounds(12, 49, 760, 549);
    getFrmNull().getContentPane().add(scrollSummary);

    scrollSummary.setViewportView(textSummary);

    // Caption
    scrollCaptions.setToolTipText("Captions");
    scrollCaptions.setBounds(12, 49, 760, 549);
    getFrmNull().getContentPane().add(scrollCaptions);

    scrollCaptions.setViewportView(textCaptions);

    /* 버튼 */
    // Abstract
    btnAbstract.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputSetting(btnAbstract);
      }
    });
    btnAbstract.setBounds(12, 10, 104, 29);
    btnAbstract.setVisible(false);
    getFrmNull().getContentPane().add(btnAbstract);

    // Introduction
    btnIntroduction.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputSetting(btnIntroduction);
      }
    });
    btnIntroduction.setBounds(128, 10, 104, 29);
    btnIntroduction.setVisible(false);
    getFrmNull().getContentPane().add(btnIntroduction);

    // Main text
    btnMainText.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputSetting(btnMainText);
      }
    });
    btnMainText.setBounds(244, 10, 104, 29);
    btnMainText.setVisible(false);
    getFrmNull().getContentPane().add(btnMainText);

    // Methods
    btnMethods.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputSetting(btnMethods);
      }
    });
    btnMethods.setBounds(360, 10, 104, 29);
    btnMethods.setVisible(false);
    getFrmNull().getContentPane().add(btnMethods);

    // Summary
    btnSummary.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputSetting(btnSummary);
      }
    });
    btnSummary.setBounds(476, 10, 104, 29);
    btnSummary.setVisible(false);
    getFrmNull().getContentPane().add(btnSummary);

    // Captions
    btnCaptions.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        inputSetting(btnCaptions);
      }
    });
    btnCaptions.setBounds(592, 10, 104, 29);
    btnCaptions.setVisible(false);
    getFrmNull().getContentPane().add(btnCaptions);

    // Add
    btnAdd.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        System.out.println(textAbstract.getText());
      }
    });
    btnAdd.setBounds(775, 100, 104, 29);
    btnAdd.setVisible(false);
    getFrmNull().getContentPane().add(btnAdd);

    // Remove
    btnRemove.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });
    btnRemove.setBounds(775, 140, 104, 29);
    btnRemove.setVisible(false);
    getFrmNull().getContentPane().add(btnRemove);

    // Clear
    btnClear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

      }
    });
    btnClear.setBounds(775, 180, 104, 29);
    btnClear.setVisible(false);
    getFrmNull().getContentPane().add(btnClear);

    /* 메뉴 */
    JMenuBar menuBar = new JMenuBar();
    getFrmNull().setJMenuBar(menuBar);
    mntmNotice.setSelected(true);

    // 공지
    mntmNotice.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setting(mntmNotice);
      }
    });
    menuBar.add(mntmNotice);

    // 본문 입력
    mntmInput.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setting(mntmInput);
      }
    });
    menuBar.add(mntmInput);

    // 문단 라벨링
    mntmParagraph.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setting(mntmParagraph);
      }
    });
    menuBar.add(mntmParagraph);

    // 텍스트 라벨링
    mntmText.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setting(mntmText);
      }
    });
    menuBar.add(mntmText);

    // Q&A
    mntmQnA.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setting(mntmQnA);
      }
    });
    menuBar.add(mntmQnA);

    // ETC
    mntmEtc.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        setting(mntmEtc);
      }
    });
    menuBar.add(mntmEtc);

    @Deprecated
    JMenuItem mntm1 = new JMenuItem("");
    menuBar.add(mntm1);

    @Deprecated
    JMenuItem mntm2 = new JMenuItem("");
    menuBar.add(mntm2);

    @Deprecated
    JMenuItem mntm3 = new JMenuItem("");
    menuBar.add(mntm3);
  }

  private void inputSetting(JButton jbtn) {
    String str = jbtn.getText();

    scrollAbstract.setVisible(false);
    scrollIntroduction.setVisible(false);
    scrollMainText.setVisible(false);
    scrollMethods.setVisible(false);
    scrollSummary.setVisible(false);
    scrollCaptions.setVisible(false);

    if (str.equals("Abstract")) {
      scrollAbstract.setVisible(true);
    } else if (str.equals("Introduction")) {
      scrollIntroduction.setVisible(true);
    } else if (str.equals("Main text")) {
      scrollMainText.setVisible(true);
    } else if (str.equals("Methods")) {
      scrollMethods.setVisible(true);
    } else if (str.equals("Summary")) {
      scrollSummary.setVisible(true);
    } else if (str.equals("Captions")) {
      scrollCaptions.setVisible(true);
    }
  }

  private void setting(JMenuItem jmntm) {
    String str = jmntm.getText();

    scrollNotice.setVisible(false);
    scrollParagraph.setVisible(false);
    scrollAbstract.setVisible(false);
    scrollIntroduction.setVisible(false);
    scrollMainText.setVisible(false);
    scrollMethods.setVisible(false);
    scrollSummary.setVisible(false);
    scrollCaptions.setVisible(false);

    btnAbstract.setVisible(false);
    btnIntroduction.setVisible(false);
    btnMainText.setVisible(false);
    btnMethods.setVisible(false);
    btnSummary.setVisible(false);
    btnCaptions.setVisible(false);

    btnAdd.setVisible(false);
    btnRemove.setVisible(false);
    btnClear.setVisible(false);

    mntmNotice.setSelected(false);
    mntmInput.setSelected(false);
    mntmParagraph.setSelected(false);
    mntmText.setSelected(false);
    mntmQnA.setSelected(false);
    mntmEtc.setSelected(false);

    if (str.equals("Notice")) {
      mntmNotice.setSelected(true);
      scrollNotice.setVisible(true);
    } else if (str.equals("Input")) {
      mntmInput.setSelected(true);

      scrollAbstract.setVisible(true);

      btnAbstract.setVisible(true);
      btnIntroduction.setVisible(true);
      btnMainText.setVisible(true);
      btnMethods.setVisible(true);
      btnSummary.setVisible(true);
      btnCaptions.setVisible(true);

      btnAdd.setVisible(true);
      btnRemove.setVisible(true);
      btnClear.setVisible(true);
    } else if (str.equals("Paragraph")) {
      // 문단 쪼개기
      splitParagraph();

      mntmParagraph.setSelected(true);

      scrollParagraph.setVisible(true);
    } else if (str.equals("Text")) {
      mntmText.setSelected(true);
    } else if (str.equals("Q&A")) {
      mntmQnA.setSelected(true);
    } else if (str.equals("ETC")) {
      mntmEtc.setSelected(true);
    }

  }

  private void splitParagraph() {
    this.ArrayAbstract = textAbstract.getText().split("\\n\\n");
    this.ArrayIntroduction = textIntroduction.getText().split("\\n\\n");
    this.ArrayMainText = textMainText.getText().split("\\n\\n");
    this.ArrayMethods = textMethods.getText().split("\\n\\n");
    this.ArraySummary = textSummary.getText().split("\\n\\n");
    this.ArrayCaptions = textCaptions.getText().split("\\n\\n");

    System.out.println(ArrayAbstract.length);
    System.out.println(ArrayIntroduction.length);
    System.out.println(ArrayMainText.length);
    System.out.println(ArrayMethods.length);
    System.out.println(ArraySummary.length);
    System.out.println(ArrayCaptions.length);

    ArrayAlltexts.clear();
    for (int i = 0; i < 6; i++) {
      int x = 0;
      if (i == 0) {
        x = this.ArrayAbstract.length;
      } else if (i == 1) {
        x = this.ArrayIntroduction.length;
      } else if (i == 2) {
        x = this.ArrayMainText.length;
      } else if (i == 3) {
        x = this.ArrayMethods.length;
      } else if (i == 4) {
        x = this.ArraySummary.length;
      } else if (i == 5) {
        x = this.ArrayCaptions.length;
      }
      for (int j = 0; j < x; j++) {
        if (i == 0 & !ArrayAbstract[j].equals("")) {
          ArrayAlltexts.add(ArrayAbstract[j]);
        } else if (i == 1 & !ArrayIntroduction[j].equals("")) {
          ArrayAlltexts.add(ArrayIntroduction[j]);
        } else if (i == 2 & !ArrayMainText[j].equals("")) {
          ArrayAlltexts.add(ArrayMainText[j]);
        } else if (i == 3 & !ArrayMethods[j].equals("")) {
          ArrayAlltexts.add(ArrayMethods[j]);
        } else if (i == 4 & !ArraySummary[j].equals("")) {
          ArrayAlltexts.add(ArraySummary[j]);
        } else if (i == 5 & !ArrayCaptions[j].equals("")) {
          ArrayAlltexts.add(ArrayCaptions[j]);
        }
      }
    }
  }

  public JFrame getFrmNull() {
    return frmNull;
  }

  public void setFrmNull(JFrame frmNull) {
    this.frmNull = frmNull;
  }
}
