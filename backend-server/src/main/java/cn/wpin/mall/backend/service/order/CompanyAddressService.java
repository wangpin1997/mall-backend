package cn.wpin.mall.backend.service.order;


import cn.wpin.mall.client.order.CompanyAddressClient;
import cn.wpin.mall.order.entity.CompanyAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 收货地址管Service
 * @author wangpin
 */
@Service
public class CompanyAddressService {

    @Autowired
    private CompanyAddressClient companyAddressClient;


    /**
     * 获取全部收货地址
     */
    public List<CompanyAddress> list() {
        return companyAddressClient.list();
    }
}
