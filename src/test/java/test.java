import cn.itcast.pojo.ItemsCustom;
import cn.itcast.service.ItemsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by 高宇 on 2017/3/3.
 */
public class test {
    @Autowired
    private ItemsService itemsService;
    private ItemsCustom itemsCustom = new ItemsCustom();
    @Test
    public void dataTest(){
        try {
            itemsCustom = itemsService.findItemsById(1);
            System.out.println(itemsCustom.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
