package demo.utils.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * @author: pmj
 * @date: 2018/7/16 11:58
 * @description: 将excel转换成pojo对象接口
 */
public interface IConvertExcel2Pojo<T> {


    /**
     * 将excel对象转换成list的pojo
     *
     * @return
     */
    List<T> convertToList();


    /**
     * 将excel对象为单个pojo
     *
     * @param <T>
     * @return
     */
    <T> T convertSingleOne();


    /**
     * @param hssfWorkbook
     * @param mapExcel2Pojo
     */
    void initHSSFWorkbook(HSSFWorkbook hssfWorkbook, MapExcel2Pojo mapExcel2Pojo) throws IOException;

    /**
     * @param url
     * @param mapExcel2Pojo
     */
    void initHSSFWorkbook(String url, MapExcel2Pojo mapExcel2Pojo) throws IOException;


    /**
     * @param inputStream
     * @param mapExcel2Pojo
     */
    void initHSSFWorkbook(InputStream inputStream, MapExcel2Pojo mapExcel2Pojo) throws IOException;
}
