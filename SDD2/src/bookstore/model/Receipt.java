package bookstore.model;

import java.util.Objects;

/** Result of pricing an order. All amounts are in cents. */
public final class Receipt {
    private final long subtotalCents;
    private final long discountCents;
    private final long totalCents;

    public Receipt(long subtotalCents, long discountCents, long totalCents) {
        this.subtotalCents = subtotalCents;
        this.discountCents = discountCents;
        this.totalCents = totalCents;
    }

    public long getSubtotalCents() {
        return subtotalCents;
    }

    public long getDiscountCents() {
        return discountCents;
    }

    public long getTotalCents() {
        return totalCents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receipt)) return false;
        Receipt r = (Receipt) o;
        return subtotalCents == r.subtotalCents
                && discountCents == r.discountCents
                && totalCents == r.totalCents;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtotalCents, discountCents, totalCents);
    }

    @Override
    public String toString() {
        return "Receipt{subtotalCents=" + subtotalCents + ", discountCents=" + discountCents
                + ", totalCents=" + totalCents + "}";
    }
}
