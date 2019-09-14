package cn.wpin.mall.backend.service.product;

import cn.wpin.mall.client.product.BrandClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.product.dto.BrandParam;
import cn.wpin.mall.product.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品品牌Service实现类
 *
 * @author wangpin
 */
@Service
public class BrandService {

    @Autowired
    private BrandClient brandClient;


    public List<Brand> listAllBrand() {
        return brandClient.getList();
    }


    public int createBrand(BrandParam brandParam) {
        return brandClient.create(brandParam);
    }


    public int updateBrand(Long id, BrandParam brandParam) {
        return brandClient.update(id, brandParam);
    }


    public int deleteBrand(Long id) {
        return brandClient.delete(id);
    }


    public int deleteBrand(List<Long> ids) {
        return brandClient.deleteBatch(ids);
    }


    public CommonPage<Brand> listBrand(String keyword, int pageNum, int pageSize) {
        return brandClient.getList(keyword, pageNum, pageSize);
    }


    public Brand getBrand(Long id) {
        return brandClient.getItem(id);
    }


    public int updateShowStatus(List<Long> ids, Integer showStatus) {
        return brandClient.updateShowStatus(ids, showStatus);
    }


    public int updateFactoryStatus(List<Long> ids, Integer factoryStatus) {
        return brandClient.updateFactoryStatus(ids, factoryStatus);
    }
}
