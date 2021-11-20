package base.service;

import base.anno.Cache;
import base.dao.RankDao;
import base.dao.UserMapper;
import base.entity.RItem;
import base.entity.RankItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {
    private final RankDao rankDao;

    public RankService(RankDao rankDao) {
        this.rankDao = rankDao;
    }

    @Cache
    public List<RankItem> getRank() {
        return rankDao.getRank();
    }

    @Cache
    public RItem getTest() {
        return new RItem("heihei", false);
    }
}
