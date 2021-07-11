import java.io.FileInputStream;
import java.io.FileOutputStream;

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

public class TempAutomation {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("");
        System.out.println(" 패치 노트");
        System.out.println("    * 새로 추가된 물성표 대응");
        System.out.println("        [mp] conductive");
        System.out.println("        [da] CBRAM, ReRAM, oxram, mram, rram, stt-ram");
        System.out.println("        [pr] RHRS, RLRS");
        System.out.println("");
        System.out.println("    * xls, xlsx 확장자 지원");
        System.out.println("        다만 아쉽게도 구축도우미에서 받은 엑셀은 파일형식에 문제가 있기 때문에 ");
        System.out.println("        바로 불러와지지 않습니다. 기존에 하시던대로 .xls 또는 .xlsx 형식으로");
        System.out.println("        새로 저장하신 후 새로 만든 엑셀 파일을 불러 오셔야 합니다.");
        System.out.println("");
        System.out.println("    * 알고리즘 개선");
        System.out.println("        이제 파일명이나 경로가 잘못되어도 프로그램이 바로 종료되지 않습니다.");
        System.out.println("");
        System.out.println("    - 문의사항은 'https://open.kakao.com/o/sSWuETmd' 로 주십시오.");
        System.out.println("");

        ExcelWrite(ExcelRead());

    }

    private static Hashtable<String, String> ExcelRead() {
        Hashtable<String, String> result = new Hashtable<>();
        int row_index = 0;
        int col_index = 0;

        System.out.println(" ─────────────────────────────");
        System.out.print(" 변환할 파일의 경로를 입력하세요 : ");
        String path = scanner.nextLine();
        System.out.println(" 파일을 읽어오는 중 ....");

        try {

            FileInputStream file = new FileInputStream(path);

            String[] strs = path.split("\\.");
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
            }

        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println(" [ERROR] 잘못된 경로이거나 파일 형식 입니다.");

            ExcelWrite(ExcelRead());
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
                        // 본문은 그대로 쓰기
                        cell.setCellValue(result.get(i + "-" + j));
                    } else if (i % 2 == 0 & j == 1) {
                        // category 함수
                        cell.setCellValue("=\"[\"&COUNTIF(C" + (i + 1) + ":ZZ" + (i + 1)
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

                    System.out.println("[" + i + " 행, " + j + " 열]");
                }
            }

            System.out.println("[   완   료   ]");
            System.out.println(" ─────────────────────────────");
            System.out.println(" 파일은 프로그램이 있는 경로에 저장됩니다.");
            System.out.print(" 저장할 파일명을 입력하세요 : ");

            String fileName = scanner.next();
            scanner.close();
            String path = ".\\" + fileName + ".xlsx";
            FileOutputStream Output = new FileOutputStream(path);
            workbook.write(Output);
            workbook.close();

            System.out.println(" \"" + fileName + ".xlsx\" 저장완료. ");
            Thread.sleep(2000);

        } catch (Exception e) {
            // e.printStackTrace();
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
        secondTable.put("conductive", "mp");

        try {

            int row = Integer.parseInt(result.get("row_index"));
            int col = Integer.parseInt(result.get("col_index"));

            Pattern pattern = Pattern.compile("(CBRAM|ReRAM|oxram|mram|stt-ram|rram|conductive|RHRS|RLRS)");
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    Matcher matcher = pattern.matcher(result.get(i + "-" + j));
                    if (matcher.find()) {
                        result.put((i + 1) + "-" + j, secondTable.get(result.get(i + "-" + j)));
                    }
                }
            }
        } catch (Exception e) {
            // e.printStackTrace();
        }
        return result;
    }

    private static Hashtable<String, String> labelingSet() {
        Hashtable<String, String> labelingSet = new Hashtable<>();
        labelingSet.put("m1", "m1-o-o");
        labelingSet.put("m2", "m2-o-o");
        labelingSet.put("m3", "m3-o-o");
        labelingSet.put("m4", "m4-o-o");
        labelingSet.put("m5", "m5-o-o");
        labelingSet.put("m6", "m5-o-o");

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

        labelingSet.put("mp", "o-mp-o");
        labelingSet.put("m1mp", "m1-mp-o");
        labelingSet.put("m2mp", "m2-mp-o");
        labelingSet.put("m3mp", "m3-mp-o");
        labelingSet.put("m4mp", "m4-mp-o");
        labelingSet.put("m5mp", "m5-mp-o");
        labelingSet.put("m6mp", "m5-mp-o");

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

        labelingSet.put("mc", "o-mc-o");
        labelingSet.put("m1mc", "m1-mc-o");
        labelingSet.put("m2mc", "m2-mc-o");
        labelingSet.put("m3mc", "m3-mc-o");
        labelingSet.put("m4mc", "m4-mc-o");
        labelingSet.put("m5mc", "m5-mc-o");
        labelingSet.put("m6mc", "m6-mc-o");

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
