package cn.com.hiseas.common.constant;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 启用状态枚举
 *
 * @author zhengxiang
 * @date 2025/1/16 00:21
 * @since 0.0.1
 */
@Getter
public enum ValidEnum implements BaseEnum {

    /**
     * 启用
     */
    ENABLED(1, "启用"),
    /**
     * 禁用
     */
    DISABLED(2, "禁用");

    @EnumValue
    private final int code;

    private final String description;

    @Override
    public String getDescription() {
        return this.description;
    }

    ValidEnum(int code, String description) {
        this.code = code;
        this.description = description;
    }

}
