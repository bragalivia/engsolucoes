package business;

import dao.config.ConnectionMysql;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * Created by Livia on 16/06/2016.
 */
public class ImportExcel {

    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = null;
            try {
                con = ConnectionMysql.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            con.setAutoCommit(false);
            PreparedStatement pstm = null ;
            FileInputStream input = new FileInputStream("C://teste.xlsx");
            POIFSFileSystem fs = new POIFSFileSystem( input );
            //HSSFWorkbook wb = new HSSFWorkbook(fs);
            //HSSFSheet sheet = wb.getSheetAt(0);
            XSSFWorkbook wb = new XSSFWorkbook(input);
            XSSFSheet sheet = wb.getSheetAt(0);

            Row row;
            DataFormatter formatter = new DataFormatter(Locale.US);
            for(int i=1; i<=sheet.getLastRowNum(); i++){
                row = sheet.getRow(i);



                String id = formatter.formatCellValue(row.getCell(0));
                int effectiveTime = (int) row.getCell(1).getNumericCellValue();
                int active = (int) row.getCell(2).getNumericCellValue();
                String moduleId = formatter.formatCellValue(row.getCell(3));
                String refSetId = formatter.formatCellValue(row.getCell(4));
                String referencedComponentId = formatter.formatCellValue(row.getCell(5));
                String sctName = formatter.formatCellValue(row.getCell(6));
                int mapGroup = (int) row.getCell(7).getNumericCellValue();
                int mapPriority = (int) row.getCell(8).getNumericCellValue();
                String mapRule = formatter.formatCellValue(row.getCell(9));
                String mapAdvice = formatter.formatCellValue(row.getCell(10));
                String mapTarget =formatter.formatCellValue(row.getCell(11));
                String icdName = formatter.formatCellValue(row.getCell(12));
                int mmapCategoryId = (int) row.getCell(13).getNumericCellValue();
                String mapCategoryValue = formatter.formatCellValue(row.getCell(14));

                //String sql = "INSERT INTO sno10 VALUES('"+id+"','"+effectiveTime+"','"+active+"',"
                //+ "'"+moduleId+"','"+refSetId+"','"+referencedComponentId+"',"
                //+ "'"+sctName +"','"+mapGroup+"','"+mapPriority+"',"
                //+ "'"+mapRule+"','"+mapAdvice+"','"+mapTarget+"',"
                //  + "'"+icdName+"','"+mmapCategoryId+"','"+mapCategoryValue+"')";
                //pstm = (PreparedStatement) con.prepareStatement(sql);
                // pstm.execute();

                String sql = "INSERT INTO sno10 VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pstm = (PreparedStatement) con.prepareStatement(sql);

                pstm.setString(1, id);
                pstm.setInt(2, effectiveTime);
                pstm.setInt(3, active);
                pstm.setString(4, moduleId);
                pstm.setString(5, refSetId);
                pstm.setString(6, referencedComponentId);
                pstm.setString(7, sctName);
                pstm.setInt(8, mapGroup);
                pstm.setInt(9, mapPriority);
                pstm.setString(10, mapRule);
                pstm.setString(11, mapAdvice);
                pstm.setString(12, mapTarget);
                pstm.setString(13, icdName);
                pstm.setInt(14, mmapCategoryId);
                pstm.setString(15,mapCategoryValue);
                pstm.execute();



                System.out.println("Import rows "+i);
            }
            con.commit();
            pstm.close();
            con.close();
            input.close();
            System.out.println("Success import excel to mysql table");
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }catch(SQLException ex){
            System.out.println(ex);
        }catch(IOException ioe){
            System.out.println(ioe);
        }
    }
}
