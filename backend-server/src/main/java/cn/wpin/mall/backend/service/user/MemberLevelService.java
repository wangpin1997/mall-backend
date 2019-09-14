package cn.wpin.mall.backend.service.user;

import cn.wpin.mall.client.user.MemberLevelClient;
import cn.wpin.mall.user.entity.MemberLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author wangpin
 */
@Component
public class MemberLevelService {

    @Autowired
    private MemberLevelClient memberLevelClient;

    public List<MemberLevel> list(Integer defaultStatus) {
        return memberLevelClient.list(defaultStatus);
    }
}
