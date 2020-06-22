package demo.utils.excel;

import org.springframework.beans.BeanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: pmj
 * @date: 2018/7/16 12:46
 * @description: excel中的字段和pojo的映射
 */
public class MapExcel2Pojo<T> {

    /**
     * 顺序映射
     */
    private Map<Integer, BeanFieldProperty> sortMap = new HashMap<>();

    /**
     * 名称映射
     */
    private Map<String, BeanFieldProperty> nameMap = new HashMap<>();

    /**
     * 转换类型
     */
    private ConvertType convertType;


    private Class<T> tClass;

    public MapExcel2Pojo(ConvertType convertType, Class<T> tClass) {
        this.convertType = convertType;
        this.tClass = tClass;
    }


    public void addSortMap(Integer sort, BeanFieldProperty name) {
        sortMap.put(sort, name);
    }

    public void addNameMap(String column, BeanFieldProperty name) {
        nameMap.put(column, name);
    }

    public ConvertType getConvertType() {
        return convertType;
    }

    public BeanFieldProperty getNameBySort(Integer sort) {
        return sortMap.get(sort);
    }

    public BeanFieldProperty getNameByColumnName(String columnName) {
        return nameMap.get(columnName);
    }

    public T getInstance() {
        return (T) BeanUtils.instantiate(tClass);
    }
}
