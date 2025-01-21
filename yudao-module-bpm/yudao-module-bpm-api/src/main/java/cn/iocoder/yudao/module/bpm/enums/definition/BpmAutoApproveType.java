package cn.iocoder.yudao.module.bpm.enums.definition;

import cn.iocoder.yudao.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * BPM 自动去重的类型的枚举
 *
 * @author Lesan
 */
@Getter
@AllArgsConstructor
public enum BpmAutoApproveType implements IntArrayValuable {

    NONE(1, "不自动通过"),
    APPROVE_ALL(2, "仅审批一次，后续重复的审批节点均自动通过"),
    APPROVE_SEQUENT(3, "仅针对连续审批的节点自动通过");

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(BpmAutoApproveType::getType).toArray();

    private final Integer type;
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }

}