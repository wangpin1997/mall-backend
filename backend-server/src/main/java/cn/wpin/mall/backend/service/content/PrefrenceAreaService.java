package cn.wpin.mall.backend.service.content;


import cn.wpin.mall.client.content.PrefrenceAreaClient;
import cn.wpin.mall.content.entity.PrefrenceArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品优选Service实现类
 * @author wangpin 
 * @date 2019-9-12 14:41:44
 */
@Service
public class PrefrenceAreaService {
    
    @Autowired
    private PrefrenceAreaClient prefrenceAreaClient;

    public List<PrefrenceArea> listAll() {
        return prefrenceAreaClient.listAll();
    }
}
