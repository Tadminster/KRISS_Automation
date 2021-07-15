import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Hashtable;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.EventQueue;
import java.awt.Desktop;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FontUIResource;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TempAutomation {
    private JFrame frmNull;
    private JTextField textField;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TempAutomation window = new TempAutomation();
                    window.frmNull.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initialize() {

        // 프레임
        frmNull = new JFrame();
        frmNull.setTitle("null");
        frmNull.setBounds(100, 100, 450, 130);
        frmNull.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmNull.getContentPane().setLayout(null);

        URL imageURL = TempAutomation.class.getClassLoader().getResource("null_icon.png");
        ImageIcon img = new ImageIcon(imageURL);
        frmNull.setIconImage(img.getImage());

        // 파일 경로
        textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setText("경로를 입력하세요.");
        textField.setBounds(12, 15, 306, 45);
        frmNull.getContentPane().add(textField);
        textField.setColumns(10);

        // 변환
        JButton btnConvert = new JButton("변환");
        btnConvert.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ExcelWrite(ExcelRead(textField.getText()));
                textField.setText("변환 완료!");
            }
        });
        btnConvert.setFont(new Font("맑은 고딕", Font.BOLD, 14));
        btnConvert.setBackground(SystemColor.controlHighlight);
        btnConvert.setBounds(330, 15, 97, 45);
        frmNull.getContentPane().add(btnConvert);

        // 메뉴
        JMenuBar menuBar = new JMenuBar();
        frmNull.setJMenuBar(menuBar);

        JMenu mnMenu = new JMenu("메뉴");
        mnMenu.setBackground(SystemColor.activeCaptionBorder);
        mnMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        menuBar.add(mnMenu);

        // 불러오기
        JMenuItem menuLoad = new JMenuItem("경로 불러오기");
        menuLoad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                fileChooser.setFileFilter(new FileNameExtensionFilter("엑셀", "xls", "xlsx"));
                fileChooser.setDialogTitle("엑셀 파일을 선택하세요.");

                int response = fileChooser.showOpenDialog(null);

                if (response == JFileChooser.APPROVE_OPTION) {
                    // File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });
        menuLoad.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        mnMenu.add(menuLoad);

        // 도움말
        JMenu menuHelp = new JMenu("도움말");
        menuHelp.setBackground(SystemColor.activeCaptionBorder);
        menuHelp.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        menuBar.add(menuHelp);

        JMenuItem helpManual = new JMenuItem("사용방법");
        helpManual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String urlLink = "https://tadminster.tistory.com/12";

                try {
                    Desktop.getDesktop().browse(new URI(urlLink));
                } catch (IOException ee) {
                    ee.printStackTrace();
                } catch (URISyntaxException ee) {
                    ee.printStackTrace();
                }
            }
        });
        helpManual.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        menuHelp.add(helpManual);

        JMenuItem helpUpdate = new JMenuItem("변경사항");
        helpUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String urlLink = "https://tadminster.tistory.com/11";

                try {
                    Desktop.getDesktop().browse(new URI(urlLink));
                } catch (IOException ee) {
                    ee.printStackTrace();
                } catch (URISyntaxException ee) {
                    ee.printStackTrace();
                }
            }
        });
        helpUpdate.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        menuHelp.add(helpUpdate);

        JMenuItem helpContact = new JMenuItem("문의하기");
        helpContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String urlLink = "https://open.kakao.com/o/sSWuETmd";

                try {
                    Desktop.getDesktop().browse(new URI(urlLink));
                } catch (IOException ee) {
                    ee.printStackTrace();
                } catch (URISyntaxException ee) {
                    ee.printStackTrace();
                }
            }
        });
        helpContact.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
        menuHelp.add(helpContact);
    }

    public TempAutomation() {
        initialize();
    }

    private static Hashtable<String, String> ExcelRead(String path) {
        Hashtable<String, String> result = new Hashtable<>();
        int row_index = 0;
        int col_index = 0;

        try {

            FileInputStream file = new FileInputStream(path);

            String[] strs = path.split("\\.");
            String[] paths = strs[0].split("(/|\\\\)");
            String fileName = paths[paths.length - 1];

            if (strs[strs.length - 1].equals("xlsx")) {
                XSSFWorkbook workbook = new XSSFWorkbook(path);

                // 시트 수 (첫번째에만 존재하므로 0을 준다)
                // 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
                XSSFSheet sheet = workbook.getSheetAt(0);
                // 행의 수
                int rows = sheet.getPhysicalNumberOfRows();
                row_index = rows;
                for (int rowindex = 0; rowindex < rows; rowindex++) {
                    // 행을읽는다
                    XSSFRow row = sheet.getRow(rowindex);
                    if (row != null) {
                        // 셀의 수
                        int cells = row.getPhysicalNumberOfCells();
                        col_index = cells;
                        for (int columnindex = 0; columnindex <= cells; columnindex++) {
                            // 셀값을 읽는다
                            XSSFCell cell = row.getCell(columnindex);
                            String value = "";
                            // 셀이 빈값일경우를 위한 널체크
                            if (cell == null) {
                                continue;
                            } else {
                                // 타입별로 내용 읽기
                                switch (cell.getCellType()) {
                                    case FORMULA:
                                        value = cell.getCellFormula();
                                        break;
                                    case NUMERIC:
                                        value = cell.getNumericCellValue() + "";
                                        break;
                                    case STRING:
                                        value = cell.getStringCellValue() + "";
                                        break;
                                    case BLANK:
                                        value = cell.getBooleanCellValue() + "";
                                        break;
                                    case ERROR:
                                        value = cell.getErrorCellValue() + "";
                                        break;
                                }
                            }
                            // 읽어온 값들을 해쉬테이블에 저장
                            result.put(rowindex + "-" + columnindex, value);
                        }
                    }
                }
                result.put("row_index", row_index + "");
                result.put("col_index", col_index + "");
                result.put("fileName", fileName);
                workbook.close();

            } else {
                Workbook workbook = WorkbookFactory.create(file);

                // 시트 수 (첫번째에만 존재하므로 0을 준다)
                // 만약 각 시트를 읽기위해서는 FOR문을 한번더 돌려준다
                Sheet sheet = workbook.getSheetAt(0);
                // 행의 수
                int rows = sheet.getPhysicalNumberOfRows();
                row_index = rows;
                for (int rowindex = 0; rowindex < rows; rowindex++) {
                    // 행을읽는다
                    Row row = sheet.getRow(rowindex);
                    if (row != null) {
                        // 셀의 수
                        int cells = row.getPhysicalNumberOfCells();
                        col_index = cells;
                        for (int columnindex = 0; columnindex <= cells; columnindex++) {
                            // 셀값을 읽는다
                            Cell cell = row.getCell(columnindex);
                            String value = "";
                            // 셀이 빈값일경우를 위한 널체크
                            if (cell == null) {
                                continue;
                            } else {
                                // 타입별로 내용 읽기
                                switch (cell.getCellType()) {
                                    case FORMULA:
                                        value = cell.getCellFormula();
                                        break;
                                    case NUMERIC:
                                        value = cell.getNumericCellValue() + "";
                                        break;
                                    case STRING:
                                        value = cell.getStringCellValue() + "";
                                        break;
                                    case BLANK:
                                        value = cell.getBooleanCellValue() + "";
                                        break;
                                    case ERROR:
                                        value = cell.getErrorCellValue() + "";
                                        break;
                                }
                            }
                            // 읽어온 값들을 해쉬테이블에 저장
                            result.put(rowindex + "-" + columnindex, value);
                        }
                    }
                }
                result.put("row_index", row_index + "");
                result.put("col_index", col_index + "");
                result.put("fileName", fileName);
                workbook.close();
            }

        } catch (Exception e) {
            UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("맑은 고딕", Font.BOLD, 16)));
            JOptionPane.showMessageDialog(null, "잘못된 경로이거나 잘못된 파일입니다.", "ERROR", JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }
        return result;
    }

    private static void ExcelWrite(Hashtable<String, String> result) {
        result = secondKriss(result);

        // Labeling tag
        Hashtable<String, String> labelingTable = new Hashtable<>();
        labelingTable = labelingSet();

        try {
            int row = Integer.parseInt(result.get("row_index"));
            int col = Integer.parseInt(result.get("col_index"));

            // BI 판독용 변수
            boolean beginning = true;

            // 쓰기
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("null");

            Row rows;
            Cell cell;

            for (int i = 0; i < row; i++) {
                // 행 생성
                rows = sheet.createRow(i);
                for (int j = 0; j < col; j++) {
                    // 열 생성
                    cell = rows.createCell(j);
                    if (result.get(i + "-" + j).equals("false")) {
                        // 빈 값 출력하지 않음
                        beginning = true;
                        continue;
                    } else if (i == 0 || i % 2 == 1 || j == 0) {
                        // 본문은
                        if (isStringDouble(result.get(i + "-" + j))) {
                            // 숫자면 더블로 변환
                            double doubleValue = Double.parseDouble(result.get(i + "-" + j));
                            cell.setCellValue(doubleValue);
                        } else {
                            // 그외엔 그대로 쓰기
                            cell.setCellValue(result.get(i + "-" + j));
                        }
                    } else if (i % 2 == 0 & j == 1) {
                        // category 함수
                        cell.setCellFormula("\"[\"&COUNTIF(C" + (i + 1) + ":ZZ" + (i + 1)
                                + ",\"*-m*-*-*\")&\", \"&COUNTIF(C" + (i + 1) + ":ZZ" + (i + 1)
                                + ",\"*-d*\")&\", \"&COUNTIF(C" + (i + 1) + ":ZZ" + (i + 1)
                                + ",\"*-p*\")&\", \"&COUNTIF(C" + (i + 1) + ":ZZ" + (i + 1)
                                + ",\"*mc*\")&\", \"&COUNTIF(C" + (i + 1) + ":ZZ" + (i + 1)
                                + ",\"*-e-*\")&\", \"&COUNTIF(C" + (i + 1) + ":ZZ" + (i + 1) + ",\"*-s-*\")&\"]\"");
                    } else if (labelingTable.containsKey(result.get(i + "-" + j))) {
                        if (beginning) {
                            // 시작하는 문장은 B-tag
                            cell.setCellValue("B-" + labelingTable.get(result.get(i + "-" + j)));
                            beginning = false;
                        } else {
                            // 연속된 문장은 I-tag
                            cell.setCellValue("I-" + labelingTable.get(result.get(i + "-" + j)));
                        }
                    } else {
                        // 그 외엔("o") 본문 그대로 출력
                        cell.setCellValue(result.get(i + "-" + j));
                        beginning = true;
                    }
                }
            }

            String path = ".\\" + result.get("fileName") + "_변환.xlsx";
            FileOutputStream Output = new FileOutputStream(path);
            workbook.write(Output);
            Output.close();
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean isStringDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static Hashtable<String, String> secondKriss(Hashtable<String, String> result) {
        Hashtable<String, String> secondTable = new Hashtable<>();
        secondTable.put("CBRAM", "da");
        secondTable.put("ReRAM", "da");
        secondTable.put("oxram", "da");
        secondTable.put("mram", "da");
        secondTable.put("stt-ram", "da");
        secondTable.put("rram", "da");
        secondTable.put("rom", "da");

        secondTable.put("multilayer", "ds");

        secondTable.put("vacuum", "e");

        secondTable.put("conductive", "mp");
        secondTable.put("magneto-electrical", "mp");
        secondTable.put("magnetic", "mp");
        secondTable.put("ferromagnetism", "mp");
        secondTable.put("diamagnetic", "mp");
        secondTable.put("electrical", "mp");

        secondTable.put("transition", "mc");

        secondTable.put("reswitching", "po");

        secondTable.put("RHRS", "pr");
        secondTable.put("RLRS", "pr");
        secondTable.put("resistive", "pr");
        secondTable.put("resistance-state", "pr");
        secondTable.put("resistance", "pr");
        secondTable.put("HRS,LRS", "pr");
        secondTable.put("HRS", "pr");
        secondTable.put("LRS", "pr");
        secondTable.put("high‐resistance,low-resistance", "pr");
        secondTable.put("high‐resistance", "pr");
        secondTable.put("low-resistance", "pr");
        secondTable.put("conductivity", "pr");

        secondTable.put("retention", "pre");
        secondTable.put("lifetime", "pre");
        secondTable.put("duration", "pre");

        secondTable.put("Vset", "pv");
        secondTable.put("Vreset", "pv");
        secondTable.put("Vread", "pv");
        secondTable.put("Vprogram", "pv");
        secondTable.put("voltage", "pv");
        secondTable.put("Vforming", "pv");
        secondTable.put("Verase", "pv");

        secondTable.put("anneal", "s");

        try {

            int row = Integer.parseInt(result.get("row_index"));
            int col = Integer.parseInt(result.get("col_index"));

            Pattern pattern = Pattern.compile(
                    "(rom|electrical|reswitching|Verase|Vforming|voltage|Vprogram|Vread|Vreset|Vset|duration|conductivity|CBRAM|ReRAM|oxram|mram|stt-ram|rram|conductive|RHRS|RLRS|retention|lifetime|anneal|multilayer|vacuum|transition|magneto-electrical|magnetic|ferromagnetism|diamagnetic|conductive|resistance|resistance-state|resistive|HRS,LRS|HRS|LRS|high‐resistance,low-resistance|high‐resistance|low-resistance)");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Matcher matcher = pattern.matcher(result.get(i + "-" + j));
                    if (matcher.find()) {
                        result.put((i + 1) + "-" + j, secondTable.get(matcher.group()));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private static Hashtable<String, String> labelingSet() {
        Hashtable<String, String> labelingSet = new Hashtable<>();

        labelingSet.put("d1", "m1-o-o");
        labelingSet.put("d2", "m2-o-o");
        labelingSet.put("d3", "m3-o-o");
        labelingSet.put("d4", "m4-o-o");
        labelingSet.put("d5", "m5-o-o");
        labelingSet.put("d6", "m5-o-o");

        labelingSet.put("d1s", "m1-s-o");
        labelingSet.put("d2s", "m2-s-o");
        labelingSet.put("d3s", "m3-s-o");
        labelingSet.put("d4s", "m4-s-o");
        labelingSet.put("d5s", "m5-s-o");
        labelingSet.put("d6s", "m5-s-o");

        labelingSet.put("d1ds", "m1-ds-o");
        labelingSet.put("d2ds", "m2-ds-o");
        labelingSet.put("d3ds", "m3-ds-o");
        labelingSet.put("d4ds", "m4-ds-o");
        labelingSet.put("d5ds", "m5-ds-o");
        labelingSet.put("d6ds", "m5-ds-o");

        labelingSet.put("d", "o-d-o");
        labelingSet.put("m1d", "m1-d-o");
        labelingSet.put("m2d", "m2-d-o");
        labelingSet.put("m3d", "m3-d-o");
        labelingSet.put("m4d", "m4-d-o");
        labelingSet.put("m5d", "m5-d-o");
        labelingSet.put("m6d", "m5-d-o");

        labelingSet.put("ds", "o-ds-o");
        labelingSet.put("m1ds", "m1-ds-o");
        labelingSet.put("m2ds", "m2-ds-o");
        labelingSet.put("m3ds", "m3-ds-o");
        labelingSet.put("m4ds", "m4-ds-o");
        labelingSet.put("m5ds", "m5-ds-o");
        labelingSet.put("m6ds", "m6-ds-o");

        labelingSet.put("da", "o-da-o");
        labelingSet.put("m1da", "m1-da-o");
        labelingSet.put("m2da", "m2-da-o");
        labelingSet.put("m3da", "m3-da-o");
        labelingSet.put("m4da", "m4-da-o");
        labelingSet.put("m5da", "m5-da-o");
        labelingSet.put("m6da", "m6-da-o");

        labelingSet.put("m", "o-m-o");
        labelingSet.put("m1m", "m1-m-o");
        labelingSet.put("m2m", "m2-m-o");
        labelingSet.put("m3m", "m3-m-o");
        labelingSet.put("m4m", "m4-m-o");
        labelingSet.put("m5m", "m5-m-o");
        labelingSet.put("m6m", "m6-m-o");

        labelingSet.put("mc", "o-mc-o");
        labelingSet.put("m1mc", "m1-mc-o");
        labelingSet.put("m2mc", "m2-mc-o");
        labelingSet.put("m3mc", "m3-mc-o");
        labelingSet.put("m4mc", "m4-mc-o");
        labelingSet.put("m5mc", "m5-mc-o");
        labelingSet.put("m6mc", "m6-mc-o");

        labelingSet.put("mp", "o-mp-o");
        labelingSet.put("m1mp", "m1-mp-o");
        labelingSet.put("m2mp", "m2-mp-o");
        labelingSet.put("m3mp", "m3-mp-o");
        labelingSet.put("m4mp", "m4-mp-o");
        labelingSet.put("m5mp", "m5-mp-o");
        labelingSet.put("m6mp", "m5-mp-o");

        labelingSet.put("m1", "m1-o-o");
        labelingSet.put("m2", "m2-o-o");
        labelingSet.put("m3", "m3-o-o");
        labelingSet.put("m4", "m4-o-o");
        labelingSet.put("m5", "m5-o-o");
        labelingSet.put("m6", "m5-o-o");

        labelingSet.put("p", "o-p-o");
        labelingSet.put("m1p", "m1-p-o");
        labelingSet.put("m2p", "m2-p-o");
        labelingSet.put("m3p", "m3-p-o");
        labelingSet.put("m4p", "m4-p-o");
        labelingSet.put("m5p", "m5-p-o");
        labelingSet.put("m6p", "m6-p-o");

        labelingSet.put("pp", "o-pp-o");
        labelingSet.put("m1pp", "m1-pp-o");
        labelingSet.put("m2pp", "m2-pp-o");
        labelingSet.put("m3pp", "m3-pp-o");
        labelingSet.put("m4pp", "m4-pp-o");
        labelingSet.put("m5pp", "m5-pp-o");
        labelingSet.put("m6pp", "m6-pp-o");

        labelingSet.put("pc", "o-pc-o");
        labelingSet.put("m1pc", "m1-pc-o");
        labelingSet.put("m2pc", "m2-pc-o");
        labelingSet.put("m3pc", "m3-pc-o");
        labelingSet.put("m4pc", "m4-pc-o");
        labelingSet.put("m5pc", "m5-pc-o");
        labelingSet.put("m6pc", "m6-pc-o");

        labelingSet.put("pv", "o-pv-o");
        labelingSet.put("m1pv", "m1-pv-o");
        labelingSet.put("m2pv", "m2-pv-o");
        labelingSet.put("m3pv", "m3-pv-o");
        labelingSet.put("m4pv", "m4-pv-o");
        labelingSet.put("m5pv", "m5-pv-o");
        labelingSet.put("m6pv", "m6-pv-o");

        labelingSet.put("pr", "o-pr-o");
        labelingSet.put("m1pr", "m1-pr-o");
        labelingSet.put("m2pr", "m2-pr-o");
        labelingSet.put("m3pr", "m3-pr-o");
        labelingSet.put("m4pr", "m4-pr-o");
        labelingSet.put("m5pr", "m5-pr-o");
        labelingSet.put("m6pr", "m6-pr-o");

        labelingSet.put("po", "o-po-o");
        labelingSet.put("m1po", "m1-po-o");
        labelingSet.put("m2po", "m2-po-o");
        labelingSet.put("m3po", "m3-po-o");
        labelingSet.put("m4po", "m4-po-o");
        labelingSet.put("m5po", "m5-po-o");
        labelingSet.put("m6po", "m6-po-o");

        labelingSet.put("ps", "o-ps-o");
        labelingSet.put("m1ps", "m1-ps-o");
        labelingSet.put("m2ps", "m2-ps-o");
        labelingSet.put("m3ps", "m3-ps-o");
        labelingSet.put("m4ps", "m4-ps-o");
        labelingSet.put("m5ps", "m5-ps-o");
        labelingSet.put("m6ps", "m6-ps-o");

        labelingSet.put("pe", "o-pe-o");
        labelingSet.put("m1pe", "m1-pe-o");
        labelingSet.put("m2pe", "m2-pe-o");
        labelingSet.put("m3pe", "m3-pe-o");
        labelingSet.put("m4pe", "m4-pe-o");
        labelingSet.put("m5pe", "m5-pe-o");
        labelingSet.put("m6pe", "m6-pe-o");

        labelingSet.put("pre", "o-pre-o");
        labelingSet.put("m1pre", "m1-pre-o");
        labelingSet.put("m2pre", "m2-pre-o");
        labelingSet.put("m3pre", "m3-pre-o");
        labelingSet.put("m4pre", "m4-pre-o");
        labelingSet.put("m5pre", "m5-pre-o");
        labelingSet.put("m6pre", "m6-pre-o");

        labelingSet.put("pab", "o-pab-o");
        labelingSet.put("m1pab", "m1-pab-o");
        labelingSet.put("m2pab", "m2-pab-o");
        labelingSet.put("m3pab", "m3-pab-o");
        labelingSet.put("m4pab", "m4-pab-o");
        labelingSet.put("m5pab", "m5-pab-o");
        labelingSet.put("m6pab", "m6-pab-o");

        labelingSet.put("plec", "o-plec-o");
        labelingSet.put("m1plec", "m1-plec-o");
        labelingSet.put("m2plec", "m2-plec-o");
        labelingSet.put("m3plec", "m3-plec-o");
        labelingSet.put("m4plec", "m4-plec-o");
        labelingSet.put("m5plec", "m5-plec-o");
        labelingSet.put("m6plec", "m6-plec-o");

        labelingSet.put("e", "o-e-o");
        labelingSet.put("m1e", "m1-e-o");
        labelingSet.put("m2e", "m2-e-o");
        labelingSet.put("m3e", "m3-e-o");
        labelingSet.put("m4e", "m4-e-o");
        labelingSet.put("m5e", "m5-e-o");
        labelingSet.put("m6e", "m6-e-o");

        labelingSet.put("s", "o-s-o");
        labelingSet.put("m1s", "m1-s-o");
        labelingSet.put("m2s", "m2-s-o");
        labelingSet.put("m3s", "m3-s-o");
        labelingSet.put("m4s", "m4-s-o");
        labelingSet.put("m5s", "m5-s-o");
        labelingSet.put("m6s", "m6-s-o");

        labelingSet.put("v", "o-o-v");
        labelingSet.put("m1v", "m1-o-v");
        labelingSet.put("m2v", "m2-o-v");
        labelingSet.put("m3v", "m3-o-v");
        labelingSet.put("m4v", "m4-o-v");
        labelingSet.put("m5v", "m5-o-v");
        labelingSet.put("m6v", "m6-o-v");

        labelingSet.put("n", "o-o-v");
        labelingSet.put("m1n", "m1-o-v");
        labelingSet.put("m2n", "m2-o-v");
        labelingSet.put("m3n", "m3-o-v");
        labelingSet.put("m4n", "m4-o-v");
        labelingSet.put("m5n", "m5-o-v");
        labelingSet.put("m6n", "m6-o-v");

        labelingSet.put("u", "o-o-v");
        labelingSet.put("m1u", "m1-o-v");
        labelingSet.put("m2u", "m2-o-v");
        labelingSet.put("m3u", "m3-o-v");
        labelingSet.put("m4u", "m4-o-v");
        labelingSet.put("m5u", "m5-o-v");
        labelingSet.put("m6u", "m6-o-v");

        return labelingSet;
    }
}
