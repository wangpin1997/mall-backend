package cn.wpin.mall.backend.service.sale;

import cn.wpin.mall.client.sale.HomeRecommendSubjectClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.sale.entity.HomeRecommendSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 首页专题推荐管理Service实现类
 *
 * @author wangpin
 */
@Service
public class HomeRecommendSubjectService {

    @Autowired
    private HomeRecommendSubjectClient homeRecommendSubjectClient;

    public int create(List<HomeRecommendSubject> recommendSubjectList) {
        return homeRecommendSubjectClient.create(recommendSubjectList);
    }

    public int updateSort(Long id, Integer sort) {
        return homeRecommendSubjectClient.updateSort(id, sort);
    }

    public int delete(List<Long> ids) {
        return homeRecommendSubjectClient.delete(ids);
    }

    public int updateRecommendStatus(List<Long> ids, Integer recommendStatus) {
        return homeRecommendSubjectClient.updateRecommendStatus(ids, recommendStatus);
    }

    public CommonPage<HomeRecommendSubject> list(String subjectName, Integer recommendStatus, Integer pageSize, Integer pageNum) {
        return homeRecommendSubjectClient.list(subjectName, recommendStatus, pageSize, pageNum);
    }
}
