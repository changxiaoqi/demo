package demo.utils.excel;

/**
 * @author: pmj
 * @date: 2018/7/16 12:32
 * @description: 根据顺序来转换父类抽象了转换的方法
 * {@link ConvertFactory}:注释
 */
public class ConvertByColumnSort<T> extends AbstractConvertExcel2Pojo {


    protected ConvertByColumnSort() {
    }


    @Override
    protected BeanFieldProperty getBeanFieldProperty(int index, String columnName) {

        return pojo.getNameBySort(index);
    }


    @Override
    protected boolean validateParam() {
        if (pojo.getConvertType().equals(ConvertType.BY_SORT))
            return true;
        return false;
    }
}
