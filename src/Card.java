// Abstract untuk card
abstract class Card{
    // inisialisasi
    private String CardName;
    private int CardCost = 0;
    private int Damage = 0;
	private int Heal = 0;
	private int Block = 0;
    
    // Mengganti/memberi nama
    void setCardName(String Name){
        this.CardName = Name;
    }
    // Mengambil nama
    String getCardName(){
        return this.CardName;
    }

    // Mengganti/memberi Card Cost
    void setCardCost(int CardCost){
        this.CardCost = CardCost;
    }
    // Mengambil Card Cost
    int getCardCost(){
        return this.CardCost;
    }

    // Mengganti/memberi Damage
    void setDamage(int Damage){
        this.Damage = Damage;
    }
    // Mengambil Damage
    int getDamage(){
        return this.Damage;
    }

    // Mengganti/memberi Heal
    void setHeal(int Heal){
        this.Heal = Heal;
    }
    // Mengambil Heal
    int getHeal(){
        return this.Heal;
    }

    // Mengganti/memberi Block
    void setBlock(int Block){
        this.Block = Block;
    }
    // Mengambil Block
    int getBlock(){
        return this.Block;
    }
    
    // Method abstract = harus dimiliki sub-class
    abstract Card show();
}