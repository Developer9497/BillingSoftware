package com.billingsoftware.app;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDatabase {

    public static void main(String[] args) {

        String excelFilePath = "E:\\IMP DATA\\RestoappWorkSpase\\Restaurant.zip_expanded\\Restaurant\\src\\main\\resources\\static\\medicine.xlsx";
        String jdbcUrl = "jdbc:mysql://localhost:3306/newbillingdb?useSSL=false";
        String username = "root";
        String password = "";

        // Excel/DB Columns (65 columns)
        String[] columns = {
                "ProductId","ProductName","ProductShortName","ManufacturerName","CompanyId","Packing",
                "UnitOfMeasure","ProductForm","QuantityPerPack","ProductCategory","ProductGrade",
                "ProductIngredient","VATPercentage","CSTPercentage","OctroiPercentage","ExcisePercentage",
                "LastSaleBatch","LastPurchaseBatch","MinimumOrderLevel","MaximumOrderLevel","MaximumDiscount",
                "ShelfCode","SupplierId1","SupplierId2","SupplierId3","SupplierId4",
                "UniqueCode","LocalBarcodeNumber","UseBarCode","VATCalculation","VATCode",
                "MinimumSaleQuantity","CaseQuantity","BoxSale","BoxQuantity","Scheduled",
                "Scheme","LooseSale","ProductDescription","PrefSupplier","UPCCode",
                "LastSaleMRP","LastPurchaseMRP","PurchaseDisc","OrderQuantity",
                "LastSalePurRate","LastPurchasePurRate","Active","ImagePath","IsBanProduct",
                "HSNCode","CompanyName","CompanyShortName","CombPacking","MarketedBy","IsGeneric"
        };

        try (
                Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
                FileInputStream fis = new FileInputStream(excelFilePath);
                Workbook workbook = new XSSFWorkbook(fis)
        ) {

            Sheet sheet = workbook.getSheetAt(0);

            // Build SQL dynamically
            StringBuilder sql = new StringBuilder("INSERT INTO productdetails (");

            // Add column names
            for (int i = 0; i < columns.length; i++) {
                sql.append(columns[i]);
                if (i < columns.length - 1) sql.append(",");
            }

            sql.append(") VALUES (");

            // Add placeholders ?
            for (int i = 0; i < columns.length; i++) {
                sql.append("?");
                if (i < columns.length - 1) sql.append(",");
            }
            sql.append(")");

            PreparedStatement ps = conn.prepareStatement(sql.toString());

            int rowStart = sheet.getFirstRowNum() + 1; // Skip header

            for (int i = rowStart; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);
                if (row == null) continue;

                for (int col = 0; col < columns.length; col++) {
                    Cell cell = row.getCell(col, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    ps.setString(col + 1, cell.toString().trim());
                }

                ps.addBatch();
            }

            ps.executeBatch();

            System.out.println("✔ ✔ Data Inserted Successfully into MySQL!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
