package pub.codex.user.db.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.jnh.simple.common.core.utils.DateUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateFillMybatisPlusHandler implements MetaObjectHandler {
    public DateFillMybatisPlusHandler() {
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, DateUtil.getDate()); // 起始版本 3.3.0(推荐使用)
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, DateUtil.getDate()); // 起始版本 3.3.0(推荐)
    }
}