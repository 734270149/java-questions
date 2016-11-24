package sg;

import java.math.BigDecimal;

/**
 * Created by shiguang3 on 2016/4/22.
 */
public class Range implements Comparable<Range> {

    /**
     * 起始指标
     */
    private BigDecimal bottomIndicator;

    /**
     * 截止指标
     */
    private BigDecimal topIndicator;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Range range = (Range) o;

        if (bottomIndicator != null ? !bottomIndicator.equals(range.bottomIndicator) : range.bottomIndicator != null) return false;
        return topIndicator != null ? topIndicator.equals(range.topIndicator) : range.topIndicator == null;

    }

    @Override
    public String toString() {
        return "Range{" +
                "bottomIndicator=" + bottomIndicator +
                ", topIndicator=" + topIndicator +
                '}';
    }

    @Override
    public int hashCode() {
        int result = bottomIndicator != null ? bottomIndicator.hashCode() : 0;
        result = 31 * result + (topIndicator != null ? topIndicator.hashCode() : 0);
        return result;
    }

    public BigDecimal getBottomIndicator() {

        return bottomIndicator;
    }

    public void setBottomIndicator(BigDecimal bottomIndicator) {
        this.bottomIndicator = bottomIndicator;
    }

    public BigDecimal getTopIndicator() {
        return topIndicator;
    }

    public void setTopIndicator(BigDecimal topIndicator) {
        this.topIndicator = topIndicator;
    }

    public Range(BigDecimal bottomIndicator, BigDecimal topIndicator) {

        this.bottomIndicator = bottomIndicator;
        this.topIndicator = topIndicator;
    }

    public Range() {

    }

    public int compareTo(Range o) {
        return bottomIndicator.compareTo(o.bottomIndicator);
    }
}
