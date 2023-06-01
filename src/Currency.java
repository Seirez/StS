// Class currency
class Currency{
    // inisialisasi
    private int Money;

    // Mengganti/memberi Max Energy
    void setMoney(int Money){
        this.Money = Money;
    }
    // Mengambil Max Energy
    int getMoney(){
        return this.Money;
    }

    // Menghitung pembelian
    public int buy(int money, int price){
        money = money-price;
        return money;
    }
    // Menghitung penjualan
    public int sell(int money, int price){
        money = money+price;
        return money;
    }
}