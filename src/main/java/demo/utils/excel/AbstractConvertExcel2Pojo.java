package demo.utils.excel;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.util.CollectionUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: pmj
 * @date: 2018/7/16 12:02
 * @description: 转换器的抽象类
 */
public abstract class AbstractConvertExcel2Pojo<T> implements IConvertExcel2Pojo {

    protected HSSFWorkbook hssfWorkbook;

    protected MapExcel2Pojo pojo;

    protected AbstractConvertExcel2Pojo() {

    }

    public void initHSSFWorkbook(HSSFWorkbook hssfWorkbook, MapExcel2Pojo mapExcel2Pojo) throws IOException {
        if (hssfWorkbook == null) {
            throw new IOException("excel文件不存在----");
        }
        this.hssfWorkbook = hssfWorkbook;
        this.pojo = mapExcel2Pojo;
    }

    public void initHSSFWorkbook(String url, MapExcel2Pojo mapExcel2Pojo) throws IOException {
        InputStream file = new FileInputStream(url);
        initHSSFWorkbook(file, mapExcel2Pojo);
    }

    public void initHSSFWorkbook(InputStream inputStream, MapExcel2Pojo mapExcel2Pojo) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
        initHSSFWorkbook(hssfWorkbook, mapExcel2Pojo);
    }


    @Override
    public List convertToList() {
        if (!validateParam()) {
            throw new IllegalArgumentException("请检查转换的类型->ConvertType");
        }
        List<T> result = new ArrayList<>();
        int numberOfSheets = hssfWorkbook.getNumberOfSheets();
        if (numberOfSheets == 0) {
            return result;
        }
        try {
            for (int j = 0; j < numberOfSheets; j++) {
                //获取页
                HSSFSheet sheetAt = hssfWorkbook.getSheetAt(j);
                //获取页的行数
                Integer rowCount = sheetAt.getPhysicalNumberOfRows();
                for (int k = 1; k < rowCount; k++) {
                    //获取一行
                    HSSFRow row = sheetAt.getRow(k);
                    Integer cellCount = row.getPhysicalNumberOfCells();
                    T instance = (T) pojo.getInstance();
                    for (int z = 0; z < cellCount; z++) {
                        String columnName = sheetAt.getRow(0).getCell(z).getStringCellValue();
                        HSSFCell cell = row.getCell(z);
                        Object value = getValue(z, columnName, cell);
                        if (value != null) {
                            setInstanceValue(z, columnName, value, instance);
                        }
                    }
                    result.add(instance);

                }

            }
            return result;
        } finally {
            if (hssfWorkbook != null){
                try {
                    hssfWorkbook.close();
                    //help gc
                    hssfWorkbook = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    /**
     * 获取rowsheet里面的值
     *
     * @param index
     * @param columnName
     * @param cell
     * @return
     */
    protected Object getValue(int index, String columnName, HSSFCell cell) {
        BeanFieldProperty property = getBeanFieldProperty(index, columnName);
        if (property.isDate())
            return cell.getDateCellValue();
        if (property.isString()) {
            String value = "";
            int cellType = cell.getCellType();
            switch (cellType) {
                case HSSFCell.CELL_TYPE_NUMERIC: // 数字
                    Double numericCellValue = cell.getNumericCellValue();
                    long l = numericCellValue.longValue();
                    return String.valueOf(l);
                case HSSFCell.CELL_TYPE_STRING: // 字符串
                    return cell.getStringCellValue();

            }

            return value;
        }

        if (property.isNumberic())
            return cell.getNumericCellValue();
        return null;
    }


    /**
     * 根据列的顺序或者列的名称给对象赋值
     *
     * @param index
     * @param columnName
     * @param value
     * @return
     */
    private void setInstanceValue(int index, String columnName, Object value, T instance) {

        BeanFieldProperty property = getBeanFieldProperty(index, columnName);
        try {
            if (property != null) {
                BeanUtils.setProperty(instance, property.getFieldName(), value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T convertSingleOne() {
        List<T> list = this.convertToList();
        if (CollectionUtils.isEmpty(list))
            return null;
        return list.get(0);
    }

    /**
     * 获取BeanFieldProperty
     *
     * @return
     */
    protected abstract BeanFieldProperty getBeanFieldProperty(int index, String columnName);

    /**
     * 效验
     *
     * @return
     */
    protected abstract boolean validateParam();


}
