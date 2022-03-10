package models;

public class GeroceryItem {
    private Integer id;
    private String name;
    private Integer amount;
    private Boolean inCart;
    private Integer listId;

    public GeroceryItem() {
    }

    public GeroceryItem(String name, Integer amount, Integer listId) {
        this.name = name;
        this.amount = amount;
        this.listId = listId;
    }

    public GeroceryItem(Integer id, String name, Integer amount, Boolean inCart, Integer listId) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.inCart = inCart;
        this.listId = listId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Boolean getInCart() {
        return inCart;
    }

    public void setInCart(Boolean inCart) {
        this.inCart = inCart;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    @Override
    public String toString() {
        return "GeroceryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", inCart=" + inCart +
                ", listId=" + listId +
                '}';
    }
}
