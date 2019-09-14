package cn.wpin.mall.backend.service.content;

import cn.wpin.mall.client.content.SubjectClient;
import cn.wpin.mall.common.entity.CommonPage;
import cn.wpin.mall.content.entity.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 商品专题Service实现类
 *
 * @author wangpin
 * @date 2019-9-12 14:42:20
 */
@Service
public class SubjectService {
    @Autowired
    private SubjectClient subjectClient;

    public List<Subject> listAll() {
        return subjectClient.listAll();
    }

    public CommonPage<Subject> list(String keyword, Integer pageNum, Integer pageSize) {
        return subjectClient.getList(keyword, pageNum, pageSize);
    }
}
