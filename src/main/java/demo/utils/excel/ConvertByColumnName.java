package demo.utils.excel;

/**
 * @author: pmj
 * @date: 2018/7/16 12:32
 * @description: 根据名称转换
 * {@link ConvertFactory}:注释
 */
public class ConvertByColumnName<T> extends AbstractConvertExcel2Pojo {

    protected ConvertByColumnName() {
    }



    @Override
    protected BeanFieldProperty getBeanFieldProperty(int index, String columnName) {

        return pojo.getNameByColumnName(columnName);
    }


    @Override
    protected boolean validateParam() {
        if (pojo.getConvertType().equals(ConvertType.BY_NAME))
            return true;
        return false;
    }

}
