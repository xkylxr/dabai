package sdkd.com.ec.model;

/**
 * Created by xky on 2016/7/9.
 */
public class ShoppingCartItem {
    private  EbProduct product;
    private  long quantity;
    private  double cost;

    public ShoppingCartItem(EbProduct product, long quantity) {
        this.product = product;
        this.quantity = quantity;
        this.cost=product.getEpPrice()*quantity;
    }

    public EbProduct getProduct() {
        return product;
    }

    public void setProduct(EbProduct product) {
        this.product = product;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
        this.cost=product.getEpPrice()*quantity;
    }

    public double getCost() {
        return cost;
    }

}
