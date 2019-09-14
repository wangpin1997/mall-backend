package cn.wpin.mall.backend.service.sale;

import cn.wpin.mall.client.sale.HomeAdvertiseClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeAdvertise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页广告管理Service实现类
 *
 * @author wangpin
 * @date 2019-9-13 10:26:17
 */
@Service
public class HomeAdvertiseService  {

    @Autowired
    private HomeAdvertiseClient homeAdvertiseClient;

    public int create(HomeAdvertise advertise) {
        return homeAdvertiseClient.create(advertise);
    }

    public int delete(List<Long> ids) {
       return homeAdvertiseClient.delete(ids);
    }

    public int updateStatus(Long id, Integer status) {
        return homeAdvertiseClient.updateStatus(id,status);
    }

    public HomeAdvertise getItem(Long id) {
        return homeAdvertiseClient.getItem(id);
    }

    public int update(Long id, HomeAdvertise advertise) {
        return homeAdvertiseClient.update(id, advertise);
    }

    public CommonPage<HomeAdvertise> list(String name, Integer type, String endTime, Integer pageSize, Integer pageNum) {
        return homeAdvertiseClient.list(name, type, endTime, pageSize, pageNum);
    }
}
